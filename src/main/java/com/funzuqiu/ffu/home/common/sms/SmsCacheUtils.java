package com.funzuqiu.ffu.home.common.sms;

import com.funzuqiu.ffu.home.common.cache.CacheUtils;

/**
 * 用户工具类
 */
public final class SmsCacheUtils {

    public static final String SMS_CACHE = "smsCache";
    public static final String SMS_CACHE_PHONE_ = "phone_";
    public static final String SMS_FREQUENCY_CACHE = "smsFrequencyCache";
    public static final String SMS_CACHE_FREQUENCY_ = "frequency_";

    /**
     * 根据phone获取code
     */
    public static String get(String phone) {
        return CacheUtils.get(SMS_CACHE, SMS_CACHE_PHONE_ + phone);
    }

    /**
     * 存入code
     */
    public static void put(String phone, String code) {
        CacheUtils.put(SMS_CACHE, SMS_CACHE_PHONE_ + phone, code);
        addSendCount(phone);
    }

    /**
     * 清除指定phone缓存
     */
    public static void remove(String phone) {
        CacheUtils.remove(SMS_CACHE, SMS_CACHE_PHONE_ + phone);
    }

    /**
     * 记录phone在缓存时间内发送次数，后续发现频率过高则进行限制
     */
    public static boolean isTooFrequently(String phone) {
        return getSendCount(phone) > 0;
    }

    private static Integer getSendCount(String phone) {
        Integer sendCount = CacheUtils.get(SMS_FREQUENCY_CACHE, SMS_CACHE_FREQUENCY_ + phone);
        return sendCount != null ? sendCount : 0;
    }

    private static void addSendCount(String phone) {
        Integer count = getSendCount(phone);
        count = count != null ? (count + 1) : 1;
        CacheUtils.put(SMS_FREQUENCY_CACHE, SMS_CACHE_FREQUENCY_ + phone, count);
    }

}
