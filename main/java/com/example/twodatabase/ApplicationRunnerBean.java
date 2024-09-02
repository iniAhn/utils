package com.example.twodatabase;

import com.example.twodatabase.mysql.mapper.UserDaoMapper;
import com.example.twodatabase.postgres.mapper.PostUserDaoMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class ApplicationRunnerBean implements ApplicationRunner {

    private final UserDaoMapper userDaoMapper;
    private final PostUserDaoMapper postUserDaoMapper;

    @Override
    public void run(ApplicationArguments args)
    {
        log.info(postUserDaoMapper.selectUserById1().toString());
        log.info(userDaoMapper.selectUserById().toString());
        log.info(postUserDaoMapper.selectUserById1().toString());
        System.out.println("mangoo");  //여기
    }
}