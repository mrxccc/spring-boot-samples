package cn.mrxccc.multiple.datasource.mybatis.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author mrxccc
 * @create 2021/1/11
 */
@Configuration
@MapperScan(basePackages = LocalDatasourceConfig.PACKAGE, sqlSessionFactoryRef = "localSqlSessionFactory")
public class LocalDatasourceConfig {

    // 扫描路径
    static final String PACKAGE = "com.springboot.localdao";
    // mybatis mapper扫描路径
    static final String MAPPER_LOCATION = "classpath:mapper/local/*.xml";

    @Primary
    @Bean(name = "local")
    @ConfigurationProperties("spring.datasource.local")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }


    @Bean(name = "localSqlSessionFactory")
    @Primary
    public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("local") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        //如果不使用xml的方式配置mapper，则可以省去下面这行mapper location的配置。
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(LocalDatasourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
