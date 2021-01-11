package cn.mrxccc.aop.log.controller;

import cn.mrxccc.aop.log.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mrxccc
 * @create 2021/1/11
 */
@RestController
public class TestController {

    @Log("执行方法一")
    @GetMapping("/one")
    public void methodOne(String name) { }

    @Log("执行方法二")
    @GetMapping("/two")
    public void methodTwo() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Log("执行方法三")
    @GetMapping("/three")
    public void methodThree(String name, String age) { }
}
