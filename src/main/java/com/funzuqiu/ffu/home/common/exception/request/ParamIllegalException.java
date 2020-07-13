package com.funzuqiu.ffu.home.common.exception.request;

import com.funzuqiu.ffu.home.common.exception.BaseException;
import com.funzuqiu.ffu.home.common.web.entity.StatusCode;

public class ParamIllegalException extends BaseException {

    private static final long serialVersionUID = 1L;

    public ParamIllegalException(String message) {
        super(StatusCode.PARAM_ILLEGAL, message);
    }

}
