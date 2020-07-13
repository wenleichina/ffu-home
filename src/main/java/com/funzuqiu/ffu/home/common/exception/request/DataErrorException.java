package com.funzuqiu.ffu.home.common.exception.request;

import com.funzuqiu.ffu.home.common.exception.BaseException;
import com.funzuqiu.ffu.home.common.web.entity.StatusCode;

public class DataErrorException extends BaseException {

    private static final long serialVersionUID = 1L;

    public DataErrorException(String message) {
        super(StatusCode.DATA_ERROR, message);
    }

}
