package com.example.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 第二个拦截器
 *
 * @author zhoupeng
 * @create time 2021-04-15-14:38
 */
public class MySecondInterceptors implements HandlerInterceptor {
    public MySecondInterceptors() {
        super();
    }
    //在进入controller之前执行，只有在spring-mvc配置文件中配置了被拦截的请求才会执行拦截器代码，不被拦截的请求根本不会执行拦截器代码
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle...");
        //放行
        return true;
    }
    //对controller的返回结果进行二次处理，然后返回该结果
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("age","30");
        modelAndView.setViewName("addUser1");
        System.out.println("postHandle...");
    }
    //在controller的返回值返回之后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
