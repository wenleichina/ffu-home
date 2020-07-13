package com.funzuqiu.ffu.home.common.web.entity;

/**
 * API访问结果
 */
public final class StatusCode {

    public static final int OK = 0; // SUCCESS

    // ------------ 认证错误 ------------//
    public static final int AUTH_ERROR = -200; // 认证失败
    public static final int AUTH_EXPIRE = -201; // 认证超时
    public static final int AUTH_UNUSUAL_DEVICE = -202; // 非常用设备

    // ------------ 权限错误 ------------//
    public static final int NO_PERMISSION = -300; // 没有操作或数据权限
    public static final int NO_TEAM = -301; // 没有加入球队

    // ------------ 请求错误 ------------//
    public static final int PARAM_LACK = -400; // 缺少参数
    public static final int PARAM_ILLEGAL = -401; // 参数不合法
    public static final int DATA_NOT_EXIST = -402; // 数据不存在
    public static final int DATA_DUPLICATE = -403; // 数据已存在
    public static final int DATA_ERROR = -404; // 数据错误（如订单金额错误等）
    public static final int OPERATION_ILLEGAL = -405; // 非法操作（如退冻结状态的保证金等）

    // ------------ 内部错误 ------------//
    public static final int UNKNOW_ERROR = -500; // 未知错误

}
