package com.uintell.demo.utils;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private static Logger logger = Logger.getLogger(DateUtils.class);
	
	private static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";  
      
    /** 
     * 获取当前日期时间
     * @return 
     */  
    public static Date getCurrentDate(){  
        try {
        	SimpleDateFormat format = new SimpleDateFormat(yyyyMMddHHmmss);        
            return format.parse(format.format(new Date()));  
		} catch (Exception e) {
			logger.error(e);
		}
        return null;
    }  
    
}
