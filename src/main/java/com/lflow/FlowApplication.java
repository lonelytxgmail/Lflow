package com.lflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description:
 * @Title: FlowApplication
 * @Package com.lflow
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/7 10:39
 */

@SpringBootApplication
@EnableTransactionManagement
public class FlowApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlowApplication.class,args);
    }
}
