package com.example.utils;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 08 16 14:06
 */
public class EncodePhoneUtil {
    private static final byte[] KEYS = Global.getConfig("EncryptTypeHandler_KEYS").getBytes(StandardCharsets.UTF_8);
    private static final AES aes = SecureUtil.aes(KEYS);
    public static List<String> splitAndEncrypt(String phone){
        List<String> list = new ArrayList<>();
        for(int i=0;i<phone.length()-2;i++){
            String string = ""+phone.charAt(i)+phone.charAt(i+1)+phone.charAt(i+2);
            System.out.println("string:"+string);
            String newString = aes.encryptHex(string);
            System.out.println(newString);
            list.add(newString);
        }
        return list;
    }
    public static String encrypt(String phone){
        return aes.encryptHex(phone);
    }
    public static String decrypt(String value){
        return aes.decryptStr(value);
    }
    public static void main(String[] args) {
        String phone = "13855128828";
        String newPhone = encrypt(phone);
        System.out.println(newPhone);

        for(int i=0;i<phone.length()-2;i++){
            String string = ""+phone.charAt(i)+phone.charAt(i+1)+phone.charAt(i+2);
            System.out.println("string:"+string);
            String newString = encrypt(string);
            System.out.println(newString);
        }

    }
}
