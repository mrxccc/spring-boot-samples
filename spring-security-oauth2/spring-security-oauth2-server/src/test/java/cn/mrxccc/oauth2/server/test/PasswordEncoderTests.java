package cn.mrxccc.oauth2.server.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author mrxccc
 * @create 2020/11/27
 */
public class PasswordEncoderTests {
    @Test
    public void encodePassword(){
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
    }
}
