package com.uintell.demo.utils;

import com.cmos.base.util.PropertiesUtil;

import java.io.Serializable;

public class Constants implements Serializable {
	private static final long serialVersionUID = 243675615047619695L;
	public interface CONFIG_NAME{
		String SYSTEM="system";
		String SYSTEM_CODE="system_code";
		String REDIS="redis";
	}
	public static final String LOCALHOST =PropertiesUtil.getString("system", "LOCAL_HOST");	
	public static final String ENCRYPT_PARAMS = "params";
	public static final String BUSICODE = "busiCode";
	public static final String RES_ERROR_CODE="9999";
	public static final String INPUTOBJECT = "inputObject";
	public static final String VERIFY_CODE = "verifyCode";
	public static final String APP_RANDOM_CODE = "randomCode";
	public static final String RETRY_PRE = "retry_times:";
	public static final String LOCK_PRE = "login_lock:";
	//android和ios区分
	public static final String ANDROID_RETRY_PRE = "android_retry_times:";
	
	public static final String IOS_RETRY_PRE = "ios_retry_times:";
	public static final String ANDROID_RANDOM_CODE_PRE = "android_randomCode:";
	public static final String IOS_RANDOM_CODE_PRE = "ios_randomCode:";
	public static final String APP_TOKEN_USER_PRE = "app_token_user:";
	//有效期
	public static final int APP_EXPIRE = 60 * 60 * 24 * 30;//app的token有效期
	public static final int VERIFY_EXPIRE = 60 * 30;//尝试登录次数有效期
	
	//请求方式
	public static final String REQUEST_PUT = "PUT";
	public static final String REQUEST_POST = "POST";
	public static final String REQUEST_DELETE = "DELETE";
	public static final String REQUEST_GET = "GET";
	//平台分类
	public static final String PLATFORM = "platform";
	public static final String TOKEN = "token";
	public static final String IOS = "ios";
	public static final String ANDROID = "android";
	public static final String APPVERSION = "versionCode";
	public static final String DEVICE = "device";
	public static final String AIO_DEVICE = "ytj_android";
	public static final String DEVICE_SN = "sn";
	public static final String DEVICE_TYPE = "type";
	public static final String MEETING = "meeting";
	public static final String H5 = "h5";
	//pc平台session
	public static final String PC_AUTH = "authenticate";
	//请求地址
	public static final String OPERATER = "operater";
	public static final String CLIENTIP = "clientip";
	
	//登录尝试次数及锁定
	public static final String LOCK_STATUS = "locked";//锁定标识
	public static final int RETRY_CODE_LIMIT = 5;//验证码出现尝试次数
	public static final int RETRY_LOCK1_LIMIT = 20;//锁定1小时尝试次数
	public static final int RETRY_LOCK24_LIMIT = 40;//锁定24小时尝试次数
	public static final int LOCK_1HORE = 60 * 60;//错误20次锁定1小时
	public static final int LOCK_24HORE = 60 * 60 * 24;//错误40次锁定24小时
	
	//设备
	public static final String DEVICE_TOKEN_USER_PRE = "device_token_user:";
	public static final String AIO_DEVICE_TOKEN_USER_PRE = "aio_device_token_user:";
	public static final String PUSH_TASK_LOCK = "push_task_lock";
	public static final String REALTIME_PUSH_LOCK = "realtime_push_lock:";
	public static final String NEED_RECORD = "need_record:";//记录一分钟内识别记录请求次数
	
	public static final String MEETING_TOKEN_USER_PRE = "meeting_token_user:";
	
	
	//后台返回码
	public static final String SUCCESS="0000";
	public static final String FAIL="9999";
	public static final String FRONT_SUCCESS="0000";
	public static final String FRONT_FAIL="9999";
	public static final String FRONT_SPEC_SUCCESS="1";
	
	// 分页参数KEY
	public static final String CURRENT_PAGE = "currentPage";
	public static final String PAGE_SIZE = "pageSize";
	public static final String DATA_INDEX = "index";
	public static final String RETURN_CODE = "returnCode";
	public static final String RETURN_MSG = "returnMessage";
	public static final String COMP_CODE = "companyCode";
	
	// 数据库加密字段秘钥
	/**
	 * 秘钥参数名
	 */
	public static final String SECRET_KEY_NAME = "secretKey";
	/**
	 * 秘钥
	 */
	public static final String SECRET_KEY = "ccps";
	
	public interface  suffix{
		String XLSX = ".xlsx";
		String XLS = ".xls";
		String DOCX = ".docx";
		String DOC = ".doc";
	}
	
	// 一体机支付流水号前缀
	public static final String PAY_TRANSACTION_ID_PREFIX = "20";
	
	// 一体机支付订单号前缀
	public static final String PAY_ORDER_ID_PREFIX = "30";
	
	// 外部人员名称长度
	public static final int NAME_LENGTH = 50;
	
}
