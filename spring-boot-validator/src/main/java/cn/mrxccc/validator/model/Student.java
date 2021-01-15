package cn.mrxccc.validator.model;

import cn.mrxccc.validator.group.Create;
import cn.mrxccc.validator.group.Update;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.groups.Default;

/**
 * @author mrxccc
 * @create 2021/1/15
 */
@Data
public class Student {
    @NotEmpty(groups = Create.class)
    private String name;

    @NotEmpty(groups = Update.class)
    private String motto;

    @NotEmpty(groups = {Create.class, Update.class})
    private String hobby ;

    @NotEmpty(groups = Default.class)
    private String idNo;

    @NotEmpty
    private String address;
}
