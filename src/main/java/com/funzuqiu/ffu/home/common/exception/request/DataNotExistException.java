package com.funzuqiu.ffu.home.common.exception.request;

import com.funzuqiu.ffu.home.common.exception.BaseException;
import com.funzuqiu.ffu.home.common.web.entity.StatusCode;

public class DataNotExistException extends BaseException {

    private static final long serialVersionUID = 1L;

    public DataNotExistException() {
        this("数据不存在");
    }

    public DataNotExistException(String message) {
        super(StatusCode.DATA_NOT_EXIST, message);
    }

}
