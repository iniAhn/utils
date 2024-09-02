package com.example.twodatabase.mysql.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
  public interface UserDaoMapper {

    @Select("SELECT * FROM employee")
      Map<String,String> selectUserById();
  }