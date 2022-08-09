package com.example.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * controller类的父类,定义一些基本属性，如日志，访问的路径等等
 *
 * @author zhoupeng
 * @create time 2021-05-08-14:30
 */

public abstract class BaseController {
    protected Logger log = Logger.getLogger(BaseController.class);
    /**
     * 管理基础路径
     */
    @Value("${adminPath}")
    protected String adminPath;

    /**
     * 前端基础路径
     */
    @Value("${frontPath}")
    protected String frontPath;

    /**
     * 前端URL后缀
     */
    @Value("${urlSuffix}")
    protected String urlSuffix;
    /**
     * 添加Flash消息
     * @param
     */
    protected void addMessage(RedirectAttributes redirectAttributes,String... messages){
        StringBuilder sb = new StringBuilder();
        for (String message : messages) {
            sb.append(message).append(messages.length>1?"<br/>":"");
        }
        redirectAttributes.addFlashAttribute("message",sb.toString());
    }
}
