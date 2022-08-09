package com.example.utils;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 数据库工具类
 *
 * @author zhoupeng
 * @create time 2021-04-29-10:22
 */
public class DataSourceUtils {
    private static DataSource dataSource;
    static{
        Properties properties=new Properties();
        try {
            properties.load(DataSourceUtils.class.getResourceAsStream("/lims.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}
