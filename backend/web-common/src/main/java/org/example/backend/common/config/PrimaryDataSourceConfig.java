package org.example.backend.common.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/1/28 10:13
 */
@Configuration
@MapperScan(value = {"org.example.backend.common.primary.dao",
        "org.example.backend.common.primary.base.dao"},
        sqlSessionTemplateRef = DbConstant.primarySqlSessionTemplate)
public class PrimaryDataSourceConfig {

    @Primary
    @Bean(name = DbConstant.primaryDataSource)
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = DbConstant.primaryJdbcTemplate)
    public JdbcTemplate primaryJdbcTemplate(@Qualifier(DbConstant.primaryDataSource) DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Primary
    @Bean(name = DbConstant.primaryTransactionManager)
    public DataSourceTransactionManager primaryTransactionManager(@Qualifier(DbConstant.primaryDataSource) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = DbConstant.primarySqlSessionFactory)
    public SqlSessionFactory dbSqlSessionFactory(@Qualifier(DbConstant.primaryDataSource) DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper/*.xml,/META-INF/modeler-mybatis-mappings/*.xml"));
        bean.setTypeAliasesPackage("org.example.backend.common.primary.entity");
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(config);
        return bean.getObject();
    }

    @Primary
    @Bean(name = DbConstant.primarySqlSessionTemplate)
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier(DbConstant.primarySqlSessionFactory) SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
