package com.funzuqiu.ffu.home.common.exception.server;

import com.funzuqiu.ffu.home.common.exception.BaseException;
import com.funzuqiu.ffu.home.common.web.entity.StatusCode;

public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1L;

    public BusinessException() {
        this("服务暂时无法访问");
    }

    public BusinessException(String message) {
        super(StatusCode.UNKNOW_ERROR, message);
    }

    public BusinessException(int code, String message) {
        super(code, message);
    }

}
