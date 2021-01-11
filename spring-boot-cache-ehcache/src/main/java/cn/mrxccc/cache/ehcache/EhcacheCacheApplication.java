package cn.mrxccc.cache.ehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author mrxccc
 * @create 2021/1/11
 */
@SpringBootApplication
@EnableCaching
public class EhcacheCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(EhcacheCacheApplication.class, args);
    }
}
