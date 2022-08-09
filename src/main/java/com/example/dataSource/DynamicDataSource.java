package com.example.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author zhoupeng
 * @create time 2021-04-15-10:52
 * 动态数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> threadLocal=new ThreadLocal<>();

    private static final String DATASOURCE_ONE = "dataSource1";
    private static final String DATASOURCE_TWO = "dataSource2";
    private static final String DATASOURCE_THREE = "dataSource3";

    public static void setDatasourceOne(){
        threadLocal.set(DATASOURCE_ONE);
    }

    public static void setDatasourceTwo(){
        threadLocal.set(DATASOURCE_TWO);
    }

    public static void setDatasourceThree(){
        threadLocal.set(DATASOURCE_THREE);
    }

    public static String getCurrentLookupKey(){
        return threadLocal.get();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getCurrentLookupKey();
    }
}
