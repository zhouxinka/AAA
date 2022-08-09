package com.example.interceptors;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 08 03 14:33
 */
@Intercepts({@Signature(type = Executor.class, method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class PageInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("#############PageInterceptor intercept#############");
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        String mapId = mappedStatement.getId();
        System.out.println("mapId:"+mapId);
        Object parameter = invocation.getArgs()[1];
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        Object parameterObject = boundSql.getParameterObject();
        System.out.println("parameterObject:"+parameterObject);
        String sqlString = boundSql.getSql();
        System.out.println("sqlString:"+sqlString);
        //调用原对象的方法，进入责任链的下一级
        return invocation.proceed();
    }


    //获取代理对象
    public Object plugin(Object o) {
        //生成object对象的动态代理对象
        return Plugin.wrap(o, this);
    }

    //设置代理对象的参数
    public void setProperties(Properties properties) {
    }
}
