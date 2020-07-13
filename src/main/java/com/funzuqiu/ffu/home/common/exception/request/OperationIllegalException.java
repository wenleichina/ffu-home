package com.funzuqiu.ffu.home.common.exception.request;

import com.funzuqiu.ffu.home.common.exception.BaseException;
import com.funzuqiu.ffu.home.common.web.entity.StatusCode;

public class OperationIllegalException extends BaseException {

    private static final long serialVersionUID = 1L;

    public OperationIllegalException() {
        this("操作不正确或无权限");
    }

    public OperationIllegalException(String message) {
        super(StatusCode.OPERATION_ILLEGAL, message);
    }

}
