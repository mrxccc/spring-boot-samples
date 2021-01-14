package cn.mrxccc.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author mrxccc
 * @create 2021/1/14
 */
@Slf4j
@Component
public class TimeInterceptor extends HandlerInterceptorAdapter {
    // 处理拦截之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("处理拦截之前");
        request.setAttribute("startTime", LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));
        if (!(handler instanceof HandlerMethod)) {
            return false;
        }
        log.info(((HandlerMethod) handler).getBean().getClass().getName());
        log.info(((HandlerMethod) handler).getMethod().getName());
        return true;
    }

    // 当被拦截的方法没有抛出异常成功时才会处理
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("开始处理拦截");
        Long start = (Long) request.getAttribute("startTime");
        log.info("【拦截器】耗时 " + (LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")) - start));
    }

    // 无论被拦截的方法抛出异常与否都会执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("处理拦截之后");
        Long start = (Long) request.getAttribute("startTime");
        log.info("【拦截器】耗时 " + (LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")) - start));
        log.info("异常信息 " + ex);
    }
}
