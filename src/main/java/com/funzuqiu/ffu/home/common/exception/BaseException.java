package com.funzuqiu.ffu.home.common.exception;

import java.util.HashMap;
import java.util.Map;

public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    protected Integer code;
    protected Map<String, Object> data;

    public BaseException() {
        super();
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException put(String key, Object value) {
        if (data == null) {
            data = new HashMap<String, Object>();
        }
        data.put(key, value);
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public BaseException setCode(Integer code) {
        this.code = code;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public BaseException setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }

}
