package com.example.twodatabase.postgres.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
  public interface PostUserDaoMapper {
    @Select("SELECT * FROM ucs_auth")
      Map<String,String> selectUserById1();
  }