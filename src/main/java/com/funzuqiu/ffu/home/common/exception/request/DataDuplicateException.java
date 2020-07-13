package com.funzuqiu.ffu.home.common.exception.request;

import com.funzuqiu.ffu.home.common.exception.BaseException;
import com.funzuqiu.ffu.home.common.web.entity.StatusCode;

public class DataDuplicateException extends BaseException {

    private static final long serialVersionUID = 1L;

    public DataDuplicateException(String message) {
        super(StatusCode.DATA_DUPLICATE, message);
    }

}
