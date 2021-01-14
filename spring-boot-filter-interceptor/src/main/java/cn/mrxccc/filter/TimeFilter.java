package cn.mrxccc.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author mrxccc
 * @create 2021/1/14
 */
@Slf4j
@Component
@WebFilter(urlPatterns = {"/*"})
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("开始执行过滤器");
        Long start = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("【过滤器】耗时 " + (LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")) - start));
        log.info("结束执行过滤器");
    }

    @Override
    public void destroy() {
        log.info("过滤器销毁");
    }
}
