package cn.mrxccc.validator.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author mrxccc
 * @create 2021/1/15
 */
@Data
public class Company {

    /** 公司名称 */
    @NotEmpty(message = "公司名称不能为空")
    private String name;
}