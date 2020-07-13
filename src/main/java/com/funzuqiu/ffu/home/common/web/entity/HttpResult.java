package com.funzuqiu.ffu.home.common.web.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.funzuqiu.commons.mapper.JsonMapper;

/**
 * API返回结果
 */
public final class HttpResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code; // 状态码
    private String message; // 消息
    private Map<String, Object> data;

    private HttpResult() {
    }

    private HttpResult(int code) {
        this.code = code;
    }

    private HttpResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static HttpResult ok() {
        return new HttpResult(StatusCode.OK);
    }

    public static HttpResult error(int code, String message) {
        return new HttpResult(code, message);
    }

    public HttpResult setCodeAndMessage(int code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }

    public HttpResult put(String key, Object value) {
        if (data == null) {
            data = new HashMap<String, Object>();
        }
        data.put(key, value);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        if (data == null) {
            return null;
        }
        return (T) data.get(key);
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("message", message);
        map.put("data", data);
        return map;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return code == StatusCode.OK;
    }

    @Override
    public String toString() {
        return JsonMapper.toJson(this);
    }

    public Integer getCode() {
        return code;
    }

    public HttpResult setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public HttpResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public HttpResult setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }

}
