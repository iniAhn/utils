package com.example.twodatabase.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.example.twodatabase.postgres.mapper" , sqlSessionFactoryRef="secondarySqlSessionFactory")
  public class SecondaryMyBatisConfiguration {

    @Bean
    @Qualifier("secondaryHikariConfig")
//    @ConfigurationProperties(prefix="spring.datasource.hikari.secondary")
    @ConfigurationProperties(prefix="spring.datasource.hikari.primary")
    public HikariConfig secondaryHikariConfig() {
        return new HikariConfig();
    }

    @Bean
    @Qualifier("secondaryDataSource")
    public DataSource secondaryDataSource() throws Exception {
        return new HikariDataSource(secondaryHikariConfig());
    }

      @Bean(name = "secondarySqlSessionFactory")
      public SqlSessionFactory sqlSessionFactory(
              @Qualifier("secondaryDataSource") DataSource dataSource, ApplicationContext applicationContext) throws Exception {
          SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
          sqlSessionFactoryBean.setDataSource(dataSource);
//          sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis/mybatis-config.xml"));
//          sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mysql/mapper/**/*.xml"));

          return sqlSessionFactoryBean.getObject();
      }

      @Bean(name = "secondarySqlSessionTemplate")
      public SqlSessionTemplate sqlSessionTemplate(
              @Qualifier("secondarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
          return new SqlSessionTemplate(sqlSessionFactory);
      }
  }