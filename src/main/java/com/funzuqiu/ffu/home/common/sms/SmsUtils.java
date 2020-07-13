package com.funzuqiu.ffu.home.common.sms;

import org.apache.commons.lang3.StringUtils;

import com.funzuqiu.ffu.home.common.sms.template.IdentificationVerificationCodeTemplate;

/**
 * 短信发送工具类
 */
public final class SmsUtils {

    /**
     * 身份验证码
     */
    public static void sendIdentificationVerificationCode(String phone, String verifyCode) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(verifyCode)) {
            return;
        }
        try {
            SmsSender.appendToMessageQueue(
                    new SmsMessage(phone, new IdentificationVerificationCodeTemplate(verifyCode)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
