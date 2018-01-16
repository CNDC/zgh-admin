package com.uintell.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    private static final Logger logger = LoggerFactory.getLogger(MD5Util.class);
	public static void main(String[] args) {
		System.out.println("admin字符串经过32位MD5加密结果为:" + getMD5Str("aio_abcd_"));
	}

	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;
		byte[] byteArray = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
			byteArray = messageDigest.digest();
		} catch (NoSuchAlgorithmException e) {
		    logger.error(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
		    logger.error(e.getMessage(), e);
		}

		StringBuilder md5StrBuff = new StringBuilder();
		if(byteArray != null){
			for (int i = 0; i < byteArray.length; i++) {
				if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
					md5StrBuff.append("0").append(
							Integer.toHexString(0xFF & byteArray[i]));
				else
					md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
			}
		}
		return md5StrBuff.toString();
	}
}
