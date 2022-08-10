package com.example.listener;

import com.example.entity.Sample;
import com.example.utils.DataConsumeUtil;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Enumeration;

/**
 * 自定义的监听器
 * 用于监听Web应用的启动和关闭
 *
 * @author zhoupeng
 * @create time 2021-05-06-14:38
 */
//如果在web.xml中配置了<listener>这里就不需要@WebListener了
//@WebListener
public class MyListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        System.out.println("servletContext.getContextPath():"+servletContext.getContextPath());
        //将servletContext所有的初始化参数和值打印出来
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            System.out.println("servletContext的初始化参数："+s+"，对应的值是："+servletContext.getInitParameter(s));
        }
        System.out.println("servletContext.getServletContextName():"+servletContext.getServletContextName());
        System.out.println("servletContext.getServerInfo():"+servletContext.getServerInfo());
        //System.out.println("servletContext.getVirtualServerName():"+servletContext.getVirtualServerName());
        String rootWebApplicationContextAttributeName = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        System.out.println("rootWebApplicationContextAttributeName:"+rootWebApplicationContextAttributeName);
        //在servletContext中获取父容器（spring容器），key是：“WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE”
        XmlWebApplicationContext xmlWebApplicationContext = (XmlWebApplicationContext) servletContext.getAttribute(rootWebApplicationContextAttributeName);
       //父容器中获得sample1这个bean
        Sample sample1 = (Sample) xmlWebApplicationContext.getBean("sample1");
        System.out.println("sample:"+ sample1.toString());
        //将servletContext所有的属性打印出来
        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String s = attributeNames.nextElement();
            System.out.println("servletContext中的属性:"+s);
        }
        DataConsumeUtil.init();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听器销毁方法执行了。。。");
    }
}
