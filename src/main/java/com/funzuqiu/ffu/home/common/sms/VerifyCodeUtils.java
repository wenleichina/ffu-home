package com.funzuqiu.ffu.home.common.sms;

import org.apache.commons.lang3.StringUtils;

import com.funzuqiu.commons.constant.Regexp;
import com.funzuqiu.commons.gen.RandomUtils;
import com.funzuqiu.ffu.home.common.constant.Constant;
import com.funzuqiu.ffu.home.common.exception.request.OperationIllegalException;
import com.funzuqiu.ffu.home.common.exception.request.ParamIllegalException;

/**
 * 短信发送工具类
 */
public final class VerifyCodeUtils {

    /**
     * 发送验证码
     * 
     * @param phone
     * @return
     */
    public static void sendVerifyCode(String phone) {
        if (StringUtils.isBlank(phone) || !Regexp.match(Regexp.Phone, phone)) {
            throw new ParamIllegalException("手机号格式错误");
        }

        if (SmsCacheUtils.isTooFrequently(phone)) {
            throw new OperationIllegalException("获取验证码过于频繁，请稍后再试");
        }

        // 生成个验证码和手机号一起扔缓存里，设置2分钟缓存时长
        String code = Long.toString(RandomUtils.randomNumeric(Constant.VERIFY_CODE_LENGTH));
        SmsCacheUtils.put(phone, code);
        SmsUtils.sendIdentificationVerificationCode(phone, code);
    }

    /**
     * 校验验证码
     * 
     * @param phone
     * @param code
     * @return
     */
    public static boolean checkVerifyCode(String phone, String code) {
        if (StringUtils.isAnyBlank(phone, code)) {
            return false;
        }

        // 缓存进行验证码校验（如果正确，清除该条缓存）
        String authCode = SmsCacheUtils.get(phone);
        if (authCode == null || !authCode.equals(code)) {
            return false;
        } else {
            SmsCacheUtils.remove(phone);
            return true;
        }
    }

}
