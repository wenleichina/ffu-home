package com.funzuqiu.ffu.home.common.sms;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.funzuqiu.commons.mapper.JsonMapper;

/**
 * 短信发送服务
 */
public final class SmsSender implements Runnable {

    protected static boolean CONFIGURATION_ENABLED = true; // 是否真实发送短信
    protected static boolean LOG_ENABLED = false; // 是否记录发送日志
    protected static String LOG_NAME;
    protected final Logger logger;

    private final String REGION_ID = "cn-hangzhou";
    private final String ACCESS_KEY_ID = "";
    private final String ACCESS_KEY_SECRET = "";
    private final String DOMAIN = "dysmsapi.aliyuncs.com";
    private final String VERSION = "2017-05-25";
    private final String SIGN = "泛足球";

    private static final BlockingQueue<SmsMessage> smsQueue = new LinkedBlockingDeque<SmsMessage>();

    private volatile static SmsSender sender;
    private volatile Thread sendThread;
    private volatile boolean on = false;

    private SmsSender() {
        if (LOG_ENABLED) {
            if (StringUtils.isNotBlank(LOG_NAME)) {
                logger = LoggerFactory.getLogger(LOG_NAME);
            } else {
                logger = LoggerFactory.getLogger(getClass());
            }
        } else {
            logger = null;
        }
    }

    /**
     * 待发送短信放入队列
     * 
     * @param message
     * @throws InterruptedException
     */
    public static void appendToMessageQueue(SmsMessage message) throws InterruptedException {
        smsQueue.put(message);
        if (!isRunning()) {
            start();
        }
    }

    /**
     * 服务启动状态
     */
    private static boolean isRunning() {
        return sender != null && sender.sendThread != null && sender.sendThread.isAlive();
    }

    /**
     * 服务启动
     */
    private static synchronized void start() {
        if (!isRunning()) {
            sender = new SmsSender();
            sender.sendThread = new Thread(sender);
            sender.sendThread.start();
        }
    }

    /**
     * 服务停止
     */
    public static synchronized void stop() {
        if (isRunning()) {
            sender.on = false;
            sender = null;
        }
    }

    @Override
    public void run() {
        on = true;
        while (on) {
            try {
                SmsMessage message = smsQueue.take();

                CommonResponse response = null;
                try {
                    response = send(message);
                } catch (ClientException e) {
                    e.printStackTrace();
                } finally {
                    log(message, response);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private CommonResponse send(SmsMessage message) throws ClientException {
        if (!CONFIGURATION_ENABLED) {
            return null;
        }

        DefaultProfile profile = DefaultProfile.getProfile(REGION_ID, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysProtocol(ProtocolType.HTTPS);
        request.setSysMethod(MethodType.POST);
        request.setSysDomain(DOMAIN);
        request.setSysVersion(VERSION);
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", REGION_ID);
        request.putQueryParameter("PhoneNumbers", message.getPhones());
        request.putQueryParameter("SignName", SIGN);
        request.putQueryParameter("TemplateCode", message.getTemplateCode());
        request.putQueryParameter("TemplateParam", message.getTeamplateParam());
        // request.putQueryParameter("OutId", "");

        return client.getCommonResponse(request);
    }

    private void log(SmsMessage message, CommonResponse response) {
        if (!LOG_ENABLED || logger == null) {
            return;
        }

        StringJoiner joiner = new StringJoiner(" ");
        joiner.add(message.getPhones());
        joiner.add(LocalDateTime.now().toString());
        joiner.add(message.getTemplateCode());
        joiner.add(message.getTeamplateParam());

        if (CONFIGURATION_ENABLED) {
            if (response != null && StringUtils.isNotBlank(response.getData())) {
                Map<String, Object> data = JsonMapper.fromJson(response.getData(), Map.class);
                String code = (String) data.get("Code");
                joiner.add(code);
                if (!"OK".equals(code)) {
                    joiner.add((String) data.get("Message"));
                }
            } else {
                joiner.add("UNKNOWN_ERROR");
            }
        } else {
            joiner.add("DISABLED");
        }

        logger.info(joiner.toString());
    }

}
