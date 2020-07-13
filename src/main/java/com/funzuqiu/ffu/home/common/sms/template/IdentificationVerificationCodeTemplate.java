package com.funzuqiu.ffu.home.common.sms.template;

/**
 * 身份验证码模板
 * 
 * 模板内容：验证码${code}，您正在进行身份验证，打死不要告诉别人哦！
 */
public final class IdentificationVerificationCodeTemplate extends SmsTemplate {

    private String verifyCode;

    public IdentificationVerificationCodeTemplate(String verifyCode) {
        super("SMS_130180174");
        this.verifyCode = verifyCode;
    }

    @Override
    public String getTemplateParam() {
        return "{\"code\":\"" + verifyCode + "\"}";
    }

}
