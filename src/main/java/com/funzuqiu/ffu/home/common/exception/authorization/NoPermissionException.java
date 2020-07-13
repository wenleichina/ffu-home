package com.funzuqiu.ffu.home.common.exception.authorization;

import com.funzuqiu.ffu.home.common.exception.BaseException;
import com.funzuqiu.ffu.home.common.web.entity.StatusCode;

public class NoPermissionException extends BaseException {

    private static final long serialVersionUID = 1L;

    public NoPermissionException() {
        this("没有该操作权限");
    }

    public NoPermissionException(String message) {
        super(StatusCode.NO_PERMISSION, message);
    }

}
