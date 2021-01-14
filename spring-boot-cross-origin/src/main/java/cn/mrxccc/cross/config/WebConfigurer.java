package cn.mrxccc.cross.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author mrxccc
 * @create 2021/1/14
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

     @Override
     public void addCorsMappings(CorsRegistry registry) {
         //添加映射路径
         registry.addMapping("/**")
                 //放行哪些原始域
                 .allowedOrigins("*")
                 //是否发送Cookie信息
                 .allowCredentials(true)
                 //放行哪些原始域(请求方式)
                 .allowedMethods("GET","POST", "PUT", "DELETE")
                 //放行哪些原始域(头部信息)
                 .allowedHeaders("*");
     }

//    @Bean
//    public FilterRegistrationBean corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("*");
//        source.registerCorsConfiguration("/**", config);
//        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//        bean.setOrder(0);
//        return bean;
//    }
}
