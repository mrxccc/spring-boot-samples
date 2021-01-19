package cn.mrxccc.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author mrxccc
 * @create 2021/1/19
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.mrxccc.shiro.mapper")
public class ShiroApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class,args);
    }
}
