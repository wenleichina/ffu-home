package com.funzuqiu.ffu.home.common.exception.authorization;

import com.funzuqiu.ffu.home.common.exception.BaseException;
import com.funzuqiu.ffu.home.common.web.entity.StatusCode;

public class NoTeamException extends BaseException {

    private static final long serialVersionUID = 1L;

    public NoTeamException(String message) {
        super(StatusCode.NO_TEAM, message);
    }

}
