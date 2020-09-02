package com.inno.rws.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @apiNote rws 데이터 베이스 설정
 * @author es-seungglee
 *
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.inno.rws.dao.rws", sqlSessionFactoryRef = "rwsSqlSessionFactory")
public class RWSDataSourceConfig extends HikariConfig {
    
    @Bean(name = "rwsDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari.rws")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
    
    @Bean(name = "rwsSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier("rwsDataSource") DataSource dataSource,
            ApplicationContext context) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(context.getResources("classpath:mybatis/mapper/rws/*.xml"));
        sqlSessionFactory.setConfigLocation(context.getResource("classpath:mybatis/Mybatis-config.xml"));
        
        return sqlSessionFactory.getObject();
    }
    
    @Bean(name = "rwsSqlSession")
    public SqlSessionTemplate sqlSession(@Qualifier("rwsSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
    @Bean(name = "rwsTransactionManager")
    public PlatformTransactionManager rwsTransactionManager(@Autowired @Qualifier("rwsDataSource") DataSource secondaryDataSource) {
        return new DataSourceTransactionManager(secondaryDataSource);
    }
    
}
