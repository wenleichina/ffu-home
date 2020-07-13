package com.funzuqiu.ffu.home.common.sms;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SmsProperties.class)
public class SmsConfiguration {

    public SmsConfiguration(SmsProperties properties) {
        SmsSender.CONFIGURATION_ENABLED = properties.isEnabled();
        SmsSender.LOG_ENABLED = properties.getLog().isEnabled();
        SmsSender.LOG_NAME = properties.getLog().getName();
    }

}
