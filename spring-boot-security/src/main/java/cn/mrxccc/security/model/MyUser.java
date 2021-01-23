package cn.mrxccc.security.model;

import lombok.Data;

/**
 * @author mrxccc
 * @create 2021/1/23
 */
@Data
public class MyUser {
    private String userName;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;
}
