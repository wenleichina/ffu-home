package com.funzuqiu.ffu.home.common.exception.request;

import com.funzuqiu.ffu.home.common.exception.BaseException;
import com.funzuqiu.ffu.home.common.web.entity.StatusCode;

public class ParamLackException extends BaseException {

    private static final long serialVersionUID = 1L;

    public ParamLackException(String message) {
        super(StatusCode.PARAM_LACK, message);
    }

}
