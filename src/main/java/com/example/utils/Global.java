package com.example.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 定义一些全局变量
 *
 * @author zhoupeng
 * @create time 2021-05-11-10:55
 */
public class Global {
    private static Map<String,String> map = new HashMap<String, String>();

    private static PropertiesLoader properties = new PropertiesLoader("base.properties");


    public static String getAdminPath(){
        return getConfig("adminPath");
    }

    public static String getConfig(String key) {
        String value = map.get(key);
        if(value==null){
            value = properties.getProperty(key);
            map.put(key,value!=null?value: StringUtils.EMPTY);
        }
        return value;
    }
}
