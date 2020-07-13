package com.funzuqiu.ffu.home.common.exception.authentication;

import com.funzuqiu.ffu.home.common.exception.BaseException;
import com.funzuqiu.ffu.home.common.web.entity.StatusCode;

public class AuthExpireException extends BaseException {

    private static final long serialVersionUID = 1L;

    public AuthExpireException(String message) {
        super(StatusCode.AUTH_EXPIRE, message);
    }

}
