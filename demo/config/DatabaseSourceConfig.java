package com.example.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DatabaseSourceConfig {

//	private String driverClassName;
//	private String url;
//	private String username;
//	private String password;
	
	@Bean(name = "datasource1")
	@Primary
	public DataSource datasource() throws Exception {
		
		Properties props = new Properties();

//		props.put("driverClassName", driverClassName);
//		props.put("url", url);
//		props.put("username", username);
//		props.put("password", password);

		props.put("driverClassName", "org.mariadb.jdbc.Driver");
		props.put("url", "jdbc:mariadb://localhost:3306/sample");
		props.put("username", "root");
		props.put("password", "root");
		
		return BasicDataSourceFactory.createDataSource(props);
		
		
		
//		return null;
//		return DataSourceBuilder.create()
//				.driverClassName("")
//				.url("")
//				.username("")
//				.password("").build();
	}
	
	@Bean(name = "datasource2")
	@Primary
	public DataSource datasource2() throws Exception {
		
		Properties props = new Properties();

//		props.put("driverClassName", driverClassName);
//		props.put("url", url);
//		props.put("username", username);
//		props.put("password", password);

		props.put("driverClassName", "org.mariadb.jdbc.Driver");
		props.put("url", "jdbc:mariadb://localhost:3306/evpark");
		props.put("username", "root");
		props.put("password", "root");
		
		return BasicDataSourceFactory.createDataSource(props);
		
		
		
//		return null;
//		return DataSourceBuilder.create()
//				.driverClassName("")
//				.url("")
//				.username("")
//				.password("").build();
	}
}
