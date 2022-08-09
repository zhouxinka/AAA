package com.example.utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {
    //发送get请求
    public static String doGet(String url, Map<String,String> params){
        System.out.println("HttpClientUtil.doGet的请求参数是："+params.toString());
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if(params!=null){
                for(String key:params.keySet()){

                    uriBuilder.addParameter(key,params.get(key));
                }
            }
            URI uri = uriBuilder.build();
            HttpGet httpGet = new HttpGet(uri);
            response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() == 200){
                resultString = EntityUtils.toString(response.getEntity(),"utf-8");
                //String result = new ObjectMapper().writeValueAsString(resultString);/
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(response!=null){
                try {
                    response.close();
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultString;
    }
    // 发送post请求，并且参数是json
    // Content-Type: application/json
    public static String doPost(String url, String json){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        HttpPost httpPost = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        httpPost.setEntity(stringEntity);
        try {
            response = httpClient.execute(httpPost);
            if(response.getStatusLine().getStatusCode() == 200){
                resultString = EntityUtils.toString(response.getEntity(),"utf-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(response!=null){
                try {
                    response.close();
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultString;
    }
    // 发送post请求，并且参数是表单数据
    // Content-Type: application/x-www-form-urlencoded;charset=utf-8
    public static String doPost2(String url, Map<String,String> params){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        HttpPost httpPost = new HttpPost(url);
        try {
            if(params!=null){
                List<NameValuePair> list = new ArrayList<>();
                for(String key:params.keySet()){
                    //表单数据是键值对，封装在BasicNameValuePair里面，加入集合
                    list.add(new BasicNameValuePair(key,params.get(key)));
                }
                //发送表单数据就要用这种Entity即：UrlEncodedFormEntity
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"utf-8");
                httpPost.setEntity(entity);
            }
            response = httpClient.execute(httpPost);
            if(response.getStatusLine().getStatusCode() == 200){
                resultString = EntityUtils.toString(response.getEntity(),"utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(response!=null){
                try {
                    response.close();
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultString;
    }
}
