
package com.funzuqiu.ffu.home.modules.ffu.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funzuqiu.ffu.home.common.exception.request.OperationIllegalException;
import com.funzuqiu.ffu.home.common.service.BaseService;
import com.funzuqiu.ffu.home.common.service.WriteTx;
import com.funzuqiu.ffu.home.modules.ffu.entity.FfuApplication;
import com.funzuqiu.ffu.home.modules.ffu.enums.FfuApplicationStateEnum;
import com.funzuqiu.ffu.home.modules.ffu.mapper.FfuApplicationMapper;

@Service
public class FfuService extends BaseService {

    private final String SESSION_FFU_APPLICATION = "ffu_application";

    @Autowired
    private FfuApplicationMapper applicationMapper;

    public FfuApplication getApplication(String phone) {
        return applicationMapper.getByPhone(phone);
    }

    @WriteTx
    public FfuApplication register(FfuApplication application, HttpSession session) {
        String phone = application.getPhone();

        FfuApplication db = getApplication(phone);
        if (db != null) {
            if (FfuApplicationStateEnum.fromValue(db.getState()) != FfuApplicationStateEnum.DENYED) {
                session.setAttribute(SESSION_FFU_APPLICATION, db);
                throw new OperationIllegalException("您已注册过，请勿重复注册");
            }

            application.setId(db.getId());
        }

        application.setState(FfuApplicationStateEnum.PENDING.value);

        if (application.isNewRecord()) {
            applicationMapper.insert(application);
        } else {
            applicationMapper.update(application);
        }

        session.setAttribute(SESSION_FFU_APPLICATION, application);

        return application;
    }

}
