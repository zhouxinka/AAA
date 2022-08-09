package com.example.utils;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.util.IdGenerator;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.UUID;

/**
 * @author zhoupeng
 * @create time 2021-06-10-13:59
 */
public class IdGen implements IdGenerator, SessionIdGenerator {
    @Override
    public UUID generateId() {
        return null;
    }

    private static SecureRandom random = new SecureRandom();

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 使用SecureRandom随机生成Long.
     */
    public static long randomLong() {
        return Math.abs(random.nextLong());
    }

    /**
     * Activiti ID 生成
     */
    public String getNextId() {
        return IdGen.uuid();
    }

    @Override
    public Serializable generateId(Session session) {
        return IdGen.uuid();
    }


}
