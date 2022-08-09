package com.example.interceptors;

import com.example.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 第一个拦截器
 *
 * @author zhoupeng
 * @create time 2021-04-15-13:56
 */
public class MyFirstInterceptors implements HandlerInterceptor {
    public MyFirstInterceptors() {
        super();
    }
    //在进入controller之前执行，只有在spring-mvc配置文件中配置了被拦截的请求才会执行拦截器代码，不被拦截的请求根本不会执行拦截器代码
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle...");
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("CURRENT_USER");
        //是否放行，即：是否进入controller
        if(null!=currentUser){
            System.out.println("session----->currentUser:"+currentUser.toString());
            return true;
        }
        request.getRequestDispatcher("/WEB-INF/views/tips.jsp").forward(request,response);
        return false;
    }
    //对controller的返回结果进行二次处理，然后返回该结果
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }
    //在controller的返回值返回之后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
