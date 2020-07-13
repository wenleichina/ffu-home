package com.funzuqiu.ffu.home.common.web.entity;

import java.io.Serializable;

import org.springframework.util.StringUtils;

/**
 * 提示消息
 */
public final class AlertMessage implements Serializable {

    private static final long serialVersionUID = -2643624539731104235L;

    String success;
    String info;
    String warning;
    String danger;
    String alert_message;
    String window_message;

    public void clear() {
        this.success = null;
        this.info = null;
        this.warning = null;
        this.danger = null;
        this.alert_message = null;
    }

    public AlertMessage success(String success) {
        clear();
        this.success = success;
        return this;
    }

    public AlertMessage info(String info) {
        clear();
        this.info = info;
        return this;
    }

    public AlertMessage warning(String warning) {
        clear();
        this.warning = warning;
        return this;
    }

    public AlertMessage danger(String danger) {
        clear();
        this.danger = danger;
        return this;
    }

    public AlertMessage alert_message(String alert_message) {
        clear();
        this.alert_message = alert_message;
        return this;
    }

    public AlertMessage window_message(String window_message) {
        this.window_message = window_message;
        return this;
    }

    public String getSuccess() {
        String temp = success;
        if (!StringUtils.isEmpty(temp)) {
            clear();
        }
        return temp;
    }

    public String getInfo() {
        String temp = info;
        if (!StringUtils.isEmpty(temp)) {
            clear();
        }
        return temp;
    }

    public String getWarning() {
        String temp = warning;
        if (!StringUtils.isEmpty(temp)) {
            clear();
        }
        return temp;
    }

    public String getDanger() {
        String temp = danger;
        if (!StringUtils.isEmpty(temp)) {
            clear();
        }
        return temp;
    }

    public String getAlert_message() {
        String temp = alert_message;
        if (!StringUtils.isEmpty(temp)) {
            clear();
        }
        return temp;
    }

    public String getWindow_message() {
        String temp = window_message;
        window_message = null;
        return temp;
    }

}
