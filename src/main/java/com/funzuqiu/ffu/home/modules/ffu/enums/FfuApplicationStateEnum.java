package com.funzuqiu.ffu.home.modules.ffu.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.OBJECT)
public enum FfuApplicationStateEnum {

    PENDING(0, "处理中"), APPROVED(1, "已通过"), DENYED(2, "未通过");

    public final int value;
    public final String name;

    private FfuApplicationStateEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static FfuApplicationStateEnum fromValue(Integer value) {
        if (value == null) {
            return null;
        }

        for (FfuApplicationStateEnum enu : values()) {
            if (enu.value == value) {
                return enu;
            }
        }
        return null;
    }

}
