package cn.mrxccc.multiple.datasource.jdbctemplate.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author mrxccc
 * @create 2021/1/11
 */
@Configuration
public class DataSourceConfig {
    @Primary
    @Bean(name = "localDataSource")
    @ConfigurationProperties("spring.datasource.local")
    public DataSource dataSourceOne(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "remoteDataSource")
    @ConfigurationProperties("spring.datasource.remote")
    public DataSource dataSourceTwo(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "localJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(
            @Qualifier("localDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "remoteJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(
            @Qualifier("remoteDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
