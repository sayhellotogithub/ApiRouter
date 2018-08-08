package com.iblogstreet.apigate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Armyone
 * @date 2018/8/7 14:26
 * @desc
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.iblogstreet.apigate.mapper","com.iblogstreet.apigate.dao"})
public class ApiGateApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGateApplication.class, args);
    }
}
