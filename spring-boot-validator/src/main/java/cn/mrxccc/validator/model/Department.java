package cn.mrxccc.validator.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author mrxccc
 * @create 2021/1/15
 */
@Data
public class Department {

    @Min(value = 1, message = "部门id不能小于1")
    private Integer id;

    /** 部门名 */
    @NotEmpty(message = "部门名不能为空")
    private String name;

    /** 部门邮件地址 */
    @Email(message = "部门邮件地址不合法")
    private String email;

    /** 所属公司 */
    @Valid
    @NotNull
    private Company company;

    /** 员工 */
    @Valid
    @NotNull
    private List<Employee> employeeList;
}
