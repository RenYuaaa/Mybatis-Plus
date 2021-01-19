package com.ren.learn.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : renjiahui
 * @date : 2021/1/19 21:31
 * @desc :
 */
@SpringBootApplication
//这种方式更灵活
@MapperScan("com.ren.learn.mybatisplus.dao")
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }
}
