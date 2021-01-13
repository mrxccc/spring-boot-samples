package cn.mrxccc.actuator.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mrxccc
 * @create 2021/1/13
 */
@RestController
@Slf4j
public class LogController {
    @RequestMapping("/")
    String index() {
        log.info("日志级别 info");
        log.warn("日志级别 warn");
        log.debug("日志级别 debug");
        log.error("日志级别 error");
        return "hello spring boot";
    }
}
