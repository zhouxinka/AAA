package com.example.utils;

import com.example.entity.ConsumeData;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhoupeng
 * @create time 2021-05-06-15:25
 */
public class DataConsumeUtil {
    //利用ThreadPoolExecutor来创建一个线程池
    private final static ExecutorService pool = new ThreadPoolExecutor(5, 200,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024),
            new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build(),
            new ThreadPoolExecutor.AbortPolicy());
    public static LinkedBlockingQueue<ConsumeData> consumeQueue = new LinkedBlockingQueue();
    public volatile static boolean isRunning = true;


    public static void init(){
        System.out.println("启动DataConsumeUtil.init方法");
        pool.submit(new Runnable() {
            public void run() {
                while (isRunning) {
                    try {
                        //从队列中取出元素，如果没有取到那就阻塞，直到取到为止
                        ConsumeData pm = consumeQueue.take();
                        String result = consumeQueue(pm);
                        if ("success".equals(result)) {
                            System.out.println("consumeQueue方法执行结果：" + result);
                        } else {
                            System.out.println("consumeQueue方法执行结果：" + result);
                        }
                    } catch (Exception e) {
                        System.out.println("DataConsumeUtil.init方法失败:" + e);
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private static String consumeQueue(ConsumeData consumeData){
        String result = "success";
        System.out.println("DataConsumeUtil.consumeQueue当前大小：【"+ DataConsumeUtil.consumeQueue.size()+"】，当前消费样本为【"+consumeData.toString()+"】");
        return result;
    }
}
