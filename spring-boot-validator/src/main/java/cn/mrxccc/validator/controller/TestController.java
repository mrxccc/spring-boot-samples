package cn.mrxccc.validator.controller;

import cn.mrxccc.validator.annotation.MyConstraints;
import cn.mrxccc.validator.model.Department;
import cn.mrxccc.validator.model.Student;
import cn.mrxccc.validator.model.ValidationBeanModel;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.DecimalMax;
import java.util.List;

/**
 * Controller层 --- 初步简单测试 @Validated 的使用位置
 *
 * 对比测试过程:
 *    方案一 : 不在类上加@Validated注解，访问这六个接口
 *    方案二 : 在类上加@Validated注解，再次访问这六个接口
 *
 *    对比方案一和方案二，可初步得出@Validated的使用时机:
 *        1.当我们是在模型里面对模型字段添加约束注解，在Controller中使用模型接收数
 *          据时，@Validated要直接放在该模型参数前才有效。 如: "/test/one"
 *        2.当我们是直接在Controller层中的参数前，使用约束注解时，@Validated要直接放在类上，
 *          才会有效。如: /test/six
 *
 * @author mrxccc
 * @create 2021/1/15
 */
@RestController
@Validated
public class TestController {
    @GetMapping(value = "/test/one")
    public String validatioOne(@Validated ValidationBeanModel.AbcDecimalMax myDecimalMax) {
        System.out.println(myDecimalMax.getMyDecimalMax());
        return "one pass!";
    }

    @GetMapping(value = "/test/two")
    @Validated
    public String validatioTwo(ValidationBeanModel.AbcDecimalMax myDecimalMax) {
        System.out.println(myDecimalMax.getMyDecimalMax());
        return "two pass!";
    }

    @GetMapping(value = "/test/three")
    public String validatioThree(ValidationBeanModel.AbcDecimalMax myDecimalMax) {
        System.out.println(myDecimalMax.getMyDecimalMax());
        return "three pass!";
    }

    @GetMapping(value = "/test/four")
    public String validatioFour(@Validated  @DecimalMax(value = "12.3") String myDecimalMax) {
        System.out.println(myDecimalMax);
        return "four pass!";
    }

    @GetMapping(value = "/test/five")
    @Validated
    public String validatioFive(@DecimalMax(value = "12.3") String myDecimalMax) {
        System.out.println(myDecimalMax);
        return "five pass!";
    }

    @GetMapping(value = "/test/six")
    @Validated
    public String validatioSix(@DecimalMax(value = "12.3") String myDecimalMax) {
        System.out.println(myDecimalMax);
        return "six pass!";
    }

    /**
     * 自定义校验注解MyConstraints
     * @param str
     * @return
     */
    @GetMapping(value = "/test/seven")
    public String validationSeven(@MyConstraints(contains = "mrxccc")String str){
        System.out.println(str);
        return "seven pass!";
    }

    /**
     * 功能描述: BindingResult处理错误
     * @Param [student, bindingResult]
     * @return
     * @author caijiacheng
     * @date 2021/1/15 18:29
     */
    @PostMapping(value = "/test/eight")
    public String validationEight(@RequestBody @Validated Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                System.err.println(allError.getDefaultMessage());
            }
        }
        return "eight pass!";
    }

    @PostMapping(value = "/test/nine")
    public String validationNine(@RequestBody @Validated Student student){
        return "nine pass!";
    }

    @PostMapping(value = "/test/ten")
    public String validationTen(@Validated @RequestBody Department department) {
        System.out.println(department);
        return "ten pass!";
    }

}
