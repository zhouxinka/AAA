package com.example.utils;


import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Properties;

/**
 * @author zhoupeng
 * @create time 2021-05-11-10:58
 */
public class PropertiesLoader {
    private static Logger logger = Logger.getLogger(PropertiesLoader.class);
    private Properties properties;

    public PropertiesLoader(String... resource) {
        properties = loadProperties(resource);
    }

    private Properties loadProperties(@org.jetbrains.annotations.NotNull String... resource) {
        Properties properties = new Properties();
        for (String location : resource) {
           InputStreamReader inputStreamReader= null;
            try {
                inputStreamReader = new InputStreamReader(PropertiesLoader.class.getClassLoader().getResourceAsStream(location),"UTF-8");
                properties.load(inputStreamReader);
            } catch (IOException e) {
                logger.error("Could not load properties from path:" + location + ", " + e.getMessage());
            }finally {
                try {
                    inputStreamReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return properties;
    }

    public String getProperty(String key) {
        String value = getValue(key);
        if(value==null){
            throw new NoSuchElementException();
        }
        return value;
    }
    /**
     * 取出Property，但以System的Property优先,取不到返回空字符串.
     */
    private String getValue(String key) {
        String value = System.getProperty(key);
        if (value != null) {
            return value;
        }
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        }
        return "";
    }
}
