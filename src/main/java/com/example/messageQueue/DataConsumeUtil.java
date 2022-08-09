package com.example.messageQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zhoupeng
 * @create time 2021-04-27-10:19
 */
public class DataConsumeUtil {
    private static ExecutorService consumeExecutorService = Executors.newSingleThreadExecutor();
    static LinkedBlockingQueue<ConsumeData> consumeQueue = new LinkedBlockingQueue<ConsumeData>();
    public volatile static boolean isRunning = true;
    private static int DELAYSECONDS = 10;

    public static void init(){
        System.out.println("启动DataConsumeUtil.init方法");
        consumeExecutorService.execute(new Runnable() {
            public void run() {
                while(isRunning){
                    System.out.println(Thread.currentThread().getName());
                    try {
                        System.out.println(consumeQueue.size());
                        ConsumeData pm = consumeQueue.take();
                        System.out.println(consumeQueue.size());
                        String result = consumeQueue(pm);
                        if("success".equals(result)){
                            System.out.println("consumeQueue方法执行结果："+result);
                        }else{
                            System.out.println("consumeQueue方法执行结果："+result);
                        }
                    } catch (Exception e) {
                        System.out.println("DataConsumeUtil.init方法失败:"+e);
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    static String consumeQueue(ConsumeData consumeData){
        String result = "success";
        try{
            String type = consumeData.getType();
            String sampleId = consumeData.getSampleId();
            String alias = consumeData.getAlias();
            String sdcId = consumeData.getSdcId();
            String producttype = consumeData.getProductType();
            String sampletype = consumeData.getSampleType();
            String paramlistid = consumeData.getParamlistid();
            String dataset = consumeData.getDataset();

            String copySign = consumeData.getCopySign();
            System.out.println("DataConsumeUtil.consumeQueue当前大小：【"+ DataConsumeUtil.consumeQueue.size()+"】，当前消费样本为【"+consumeData.toString()+"】");

        }catch(Exception e){
            e.printStackTrace();
            result = "fail:"+e.getMessage();
        }
        return result;
    }
}
