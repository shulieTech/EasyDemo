package com.easydemo.usercenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="mailto:mitsui#shulie.io">mitsui</a>
 * @version 1.0
 * @date 2021-06-25
 */
@SpringBootApplication
@MapperScan(basePackages = "com.easydemo.usercenter.dao")
public class DemoUsercenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoUsercenterApplication.class, args);
    }

}
