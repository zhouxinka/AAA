package com.example.messageQueue;

/**
 * 测试类
 *
 * @author zhoupeng
 * @create time 2021-04-27-10:31
 */
public class Main {
    public static void main(String[] args) {
        ConsumeData consumeData = new ConsumeData();
        consumeData.setType("1");
        consumeData.setSdcId("Sample");
        consumeData.setDataset("1");
        consumeData.setSampleId("001");
        consumeData.setParamlistid("bc提取");
        consumeData.setAlias("pla-210427-00001-A1");
        consumeData.setNotes(Main.class.getSimpleName());
        try {
            DataConsumeUtil.consumeQueue.put(consumeData);
            Thread.sleep(5000);
            DataConsumeUtil.init();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
