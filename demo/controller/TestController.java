package com.example.demo.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;

import com.example.demo.config.BeanContext;

@RestController
public class TestController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@GetMapping("/test/{userId}")
	public String testPath(@PathVariable("userId") String data) {
		log.info("testPath userId={}", data);
    	return "ok";
	}
   
    @GetMapping("test1/{userId}")
    public String mappingPath(@PathVariable String userId) throws SQLException {
        log.info("mappingPath userId={}", userId);
        
        DataSource ds = (DataSource)BeanContext.get("datasource1");
        
//        DataSource ds = (DataSource)BeanContext.get(DataSource.class);
        
//        DataSource ds = (DataSource)ContextLoader.getCurrentWebApplicationContext().getBean("datasouce1");
        
        try(Connection conn = ds.getConnection();){
        
	        String sql = "select * from employee  ";
	        
	        ResultSet rs = conn.prepareStatement(sql).executeQuery();
	        
	        while (rs.next()) {
				log.info("rs.getString(1) : "+rs.getString(1));
				log.info("rs.getString(2) : "+rs.getString(2));
			}
        }

        
        
        return "ok";
    }
   
    @GetMapping("test2/{userId}")
    public String mappingPath1(@PathVariable String userId) throws SQLException {
        log.info("mappingPath userId={}", userId);
        
        DataSource ds = (DataSource)BeanContext.get("datasource2");
        
//        DataSource ds = (DataSource)BeanContext.get(DataSource.class);
        
//        DataSource ds = (DataSource)ContextLoader.getCurrentWebApplicationContext().getBean("datasouce1");
        
        try(Connection conn = ds.getConnection();){
        
	        String sql = "select * from employee  ";
	        
	        ResultSet rs = conn.prepareStatement(sql).executeQuery();
	        
	        while (rs.next()) {
				log.info("rs.getString(1) : "+rs.getString(1));
				log.info("rs.getString(2) : "+rs.getString(2));
			}
        }

        
        
        return "ok";
    }
}
