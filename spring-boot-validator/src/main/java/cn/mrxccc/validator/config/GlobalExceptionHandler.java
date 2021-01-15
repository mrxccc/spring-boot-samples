package cn.mrxccc.validator.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mrxccc
 * @create 2021/1/15
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理Validated校验异常
     * <p>
     * 注: 常见的ConstraintViolationException异常， 也属于ValidationException异常
     *
     * @param e
     *            捕获到的异常
     * @return 返回给前端的data
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
    public Map<String, Object> handleParameterVerificationException(Exception e) {
        log.error(" handleParameterVerificationException has been invoked", e);
        Map<String, Object> resultMap = new HashMap<>(4);
        resultMap.put("code", "100001");
        StringBuilder message = new StringBuilder();
        /// BindException
        List<FieldError> fieldErrors = new ArrayList<>();
        if (e instanceof BindException) {
            // getFieldError获取的是第一个不合法的参数(P.S.如果有多个参数不合法的话)
            fieldErrors = ((BindException)e).getFieldErrors();
            /// MethodArgumentNotValidException
        } else if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException)e).getBindingResult();
            // getFieldError获取的是第一个不合法的参数(P.S.如果有多个参数不合法的话)
            fieldErrors = bindingResult.getFieldErrors();
            /// ValidationException 的子类异常ConstraintViolationException
        } else if (e instanceof ConstraintViolationException) {
            /*
             * ConstraintViolationException的e.getMessage()形如
             *     {方法名}.{参数名}: {message}
             *  这里只需要取后面的message即可
             */
            String msg = e.getMessage();
            if (msg != null) {
                int lastIndex = msg.lastIndexOf(':');
                if (lastIndex >= 0) {
                    msg = msg.substring(lastIndex + 1).trim();
                    message.append(msg);
                }
            }
            /// ValidationException 的其它子类异常
        } else {
            message.append("处理参数时异常");
        }
        if (fieldErrors.size() > 0) {
            for (FieldError error : fieldErrors) {
                message.append(error.getField()).append(error.getDefaultMessage()).append(",");
            }
        }
        resultMap.put("msg", message.toString());
        return resultMap;
    }

}
