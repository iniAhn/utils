package com.example.twodatabase.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
//@MapperScan(value = "com.example.twodatabase.mysql.mapper" , sqlSessionFactoryRef="primarySqlSessionFactory")
@MapperScan(value = "com.example.twodatabase.mysql.mapper", sqlSessionFactoryRef="primarySqlSessionFactory")
  public class MyBatisPrimaryConfiguration {

    @Bean
    @Primary
    @Qualifier("primaryHikariConfig")
//    @ConfigurationProperties(prefix="spring.datasource.hikari.primary")
    @ConfigurationProperties(prefix="spring.datasource.hikari.secondary")
    public HikariConfig primaryHikariConfig() {
        return new HikariConfig();
    }

    @Bean
    @Primary
    @Qualifier("primaryDataSource")
    public DataSource primaryDataSource() throws Exception {
        return new HikariDataSource(primaryHikariConfig());
    }

      @Primary
      @Bean(name = "primarySqlSessionFactory")
      public SqlSessionFactory sqlSessionFactory(
              @Qualifier("primaryDataSource") DataSource dataSource, ApplicationContext applicationContext) throws Exception {
          SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
          sqlSessionFactoryBean.setDataSource(dataSource);
//          sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis/mybatis-config.xml"));
//          sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:postgres/mapper/**/*.xml"));

          return sqlSessionFactoryBean.getObject();
      }

      @Primary
      @Bean(name = "primarySqlSessionTemplate")
      public SqlSessionTemplate sqlSessionTemplate(
              @Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
          return new SqlSessionTemplate(sqlSessionFactory);
      }
  }	