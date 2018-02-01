package com.abin.lee.spring.cassandra.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Created by abin on 2018/2/1 16:54.
 * spring-cassandra
 * com.abin.lee.spring.cassandra.api
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LibraryCassandraApplication {

    public static void main(String[] args) {

        SpringApplication.run(LibraryCassandraApplication.class, args);

    }


}
