package com.funzuqiu.ffu.home.common.sms;

import com.funzuqiu.ffu.home.common.sms.template.SmsTemplate;

public final class SmsMessage {

    private String phones;
    private SmsTemplate template;

    /**
     * @param phones   支持对多个手机号码发送短信，手机号码之间以英文逗号（,）分隔。上限为1000个手机号码。
     * @param template
     */
    public SmsMessage(String phones, SmsTemplate template) {
        this.phones = phones;
        this.template = template;
    }

    public String getPhones() {
        return phones;
    }

    public String getTemplateCode() {
        return template != null ? template.getTemplateCode() : null;
    }

    public String getTeamplateParam() {
        return template != null ? template.getTemplateParam() : null;
    }

}
