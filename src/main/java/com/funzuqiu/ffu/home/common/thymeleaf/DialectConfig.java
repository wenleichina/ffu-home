package com.funzuqiu.ffu.home.common.thymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.funzuqiu.ffu.home.common.thymeleaf.pager.PagerDialect;

@Configuration
public class DialectConfig {

    @Bean
    public PagerDialect pagerDialect() {
        return new PagerDialect();
    }

}
