package cn.mrxccc.cross.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mrxccc
 * @create 2021/1/14
 */
@Controller
public class TestController {
    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("hello")
    @ResponseBody
    // @CrossOrigin(value = "*")
    public String hello() {
        return "hello";
    }
}
