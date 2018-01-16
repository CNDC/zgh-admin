package com.uintell.demo.utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class EncryptUtil {
    private static final String DEFAULT_PATTERN = "yyyyMMddHHmmssSSS";

    /**
     * @param pirKey        私钥
     * @param busiCode
     * @param requestSource
     * @param userName
     * @param passWord
     * @return
     */
    public static String getSignature(String pirKey, String transactionID, String userId, String timeTag) {
        String source = transactionID + timeTag + userId;
        return new Rsa.Encoder(pirKey).encode(source);
    }


    public static String getSn() {

        String date = new SimpleDateFormat(DEFAULT_PATTERN).format(new Date());
        String random = generateRandomCode();// 生成6位随机数
        String sn = date + random;
        return sn;
    }

    /**
     * 生成6位随机数
     */
    private static String generateRandomCode() {
        return String.valueOf(new Random().nextInt(899999) + 100000);
    }

    public static void main(String[] args) {


    }
}
