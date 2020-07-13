package com.funzuqiu.ffu.home.common.sms.template;

/**
 * 短信模板
 */
public abstract class SmsTemplate {

    protected String templateCode;

    public SmsTemplate(String templateCode) {
        this.templateCode = templateCode;
    }

    /**
     * 模板ID
     * 
     * @return
     */
    public String getTemplateCode() {
        return templateCode;
    }

    /**
     * 模板参数JSON
     * 
     * @return
     */
    public abstract String getTemplateParam();

}
