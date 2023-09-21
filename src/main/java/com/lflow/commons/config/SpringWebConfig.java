package com.lflow.commons.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @Title: Config
 * @Package com.lflow.commons.config
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/12 18:44
 */

@Configuration
public class SpringWebConfig implements WebMvcConfigurer {
    @Bean
    @ConditionalOnMissingBean
    public FlowExceptionHandler flowExceptionHandler(){return new FlowExceptionHandler();}

}
