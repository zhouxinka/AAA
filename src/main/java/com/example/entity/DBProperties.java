package com.example.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 自定义的JDBCTemplate
 *
 * @author zhoupeng
 * @create time 2021-04-21-11:19
 */
@Service
public class DBProperties {
    @Value("${jdbc.type1}")
    private String type;
    @Value("${jdbc.url1}")
    private String url;
    @Value("${jdbc.driver1}")
    private String driver;
    @Value("${jdbc.username1}")
    private String username;
    @Value("${dbc.password1}")
    private String psd;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    @PostConstruct
    public void initMethod(){
        System.out.println("DBProperties的初始化方法执行了。。。");
    }
}
