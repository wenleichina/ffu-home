package com.funzuqiu.ffu.home.modules.ffu.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.funzuqiu.ffu.home.common.persistence.BaseMapper;
import com.funzuqiu.ffu.home.modules.ffu.entity.FfuApplication;

@Mapper
public interface FfuApplicationMapper extends BaseMapper {

    FfuApplication getByPhone(String phone);

    int insert(FfuApplication entity);

    int update(FfuApplication entity);

}
