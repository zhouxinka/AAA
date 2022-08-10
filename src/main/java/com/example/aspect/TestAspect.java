package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 08 10 13:48
 */
@Aspect
@Component
public class TestAspect {
    @Pointcut("execution(* com.example.controller.UserController.*(..))")
    public void pointCut(){
        System.out.println("pointCut()...");
    }
    @AfterReturning(value = "pointCut()", returning = "keys")
    public void operate(JoinPoint joinPoint, Object keys){
        System.out.println("返回结果:"+keys.toString());
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);

        try {
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            // 获取请求的类名
            String className = joinPoint.getTarget().getClass().getName();
            // 获取请求的方法名
            String methodName = method.getName();
            methodName = className + "." + methodName;
            System.out.println("请求的方法名:"+methodName);
            // 请求的参数
            request.getParameterMap();

        } catch (Exception e2) {
            e2.printStackTrace();
        }

    }
}
