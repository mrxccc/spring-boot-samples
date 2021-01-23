package cn.mrxccc.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mrxccc
 * @create 2021/1/23
 */
@RestController
public class TestController {

    @GetMapping("hello")
    public String hello() {
        return "hello spring security";
    }

    @GetMapping("index")
    public Object index(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping("index2")
    public Object index(Authentication authentication) {
        return authentication;
    }
}
