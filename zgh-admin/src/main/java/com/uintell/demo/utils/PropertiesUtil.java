package com.uintell.demo.utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author admin
 * @date 2018/1/3 10:49
 */
public class PropertiesUtil {
    private static final Logger logger = Logger.getLogger(PropertiesUtil.class);
    private static final String encoding = "UTF-8";
    private static Map<String, PropertiesConfiguration> propertiesMap = new HashMap();

    public PropertiesUtil() {
    }

    public static PropertiesConfiguration getConfig(String configName) {
        PropertiesConfiguration config = (PropertiesConfiguration) propertiesMap.get(configName);

        try {
            if (config == null) {
                config = new PropertiesConfiguration("./config/" + configName + ".properties");
                config.setReloadingStrategy(new FileChangedReloadingStrategy());
                config.setEncoding("UTF-8");
                propertiesMap.put(configName, config);
            }
        } catch (ConfigurationException var3) {
            logger.error("PropertiesUtil core", var3);
        }

        return config;
    }

    public static String getString(String configName, String key) {
        String str = "";

        try {
            str = getConfig(configName).getString(key);
        } catch (Exception var4) {
            logger.error("getString", var4);
        }

        return str;
    }

    public static int getInt(String configName, String key) throws Exception {
        String str = getConfig(configName).getString(key);

        try {
            return Integer.parseInt(str);
        } catch (Exception var4) {
            throw new Exception("key = " + key + "取到的值不是整形！", var4);
        }
    }

    public static Iterator<String> getKeys(String configName, String prefix) throws Exception {
        return getConfig(configName).getKeys(prefix);
    }

    public static void main(String[] args) {
        System.out.println(PropertiesUtil.getString("redis","Lifo"));
    }
}
