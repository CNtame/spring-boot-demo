package com.spring.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liu
 * @version 1.0
 * @description
 * @createDate 2020/11/12
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.spring.demo.dao","com.spring.demo"})
public class MybatisConfig {

}
