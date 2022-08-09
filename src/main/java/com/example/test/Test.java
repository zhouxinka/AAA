package com.example.test;

import com.example.entity.Sample;
import com.example.entity.Teacher;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.serviceImpl.TeacherServiceImpl;
import com.example.utils.DataSourceUtils;
import com.example.utils.HttpClientUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.DynamicTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoupeng
 * @create time 2021-04-14-10:08
 */
public class Test {
    //@Autowired
    private TeacherServiceImpl teacherServiceImpl;

    public void test(){
        FileSystemXmlApplicationContext ac=new FileSystemXmlApplicationContext("/web/WEB-INF/applicationContext.xml");
        Sample sample = (Sample) ac.getBean("sample1");
        System.out.println(sample.toString());
        UserService userServiceImpl =  ac.getBean(UserService.class);
        User userById = userServiceImpl.getUserById(1);
        System.out.println(userById);
    }

    /**
     * 测试使用sqlSession进行操作数据库
     * 使用sqlSession的话,
     * 那么就要在mybatis-config.xml里面配置<environments></environments>
     * 和<mappers></mappers>
     */

    public void testSqlSession(){
        SqlSession sqlSession = null;
        try{
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            Teacher teacher = sqlSession.selectOne("com.example.dao.TeacherDao.getTeacherById", 3);
            System.out.println("teacher="+teacher.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 测试使用自定义的DataSource操作数据库
     */
    //@org.junit.Test
    public void testDataSource(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DataSourceUtils.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement("select gender from user where name = ?");
            preparedStatement.setString(1,"admin");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("gender="+resultSet.getString("gender"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试使用httpClient发送的get请求
     */
    //@org.junit.Test
    public void testHttpClientWithGet(){
        String url = "http://localhost:8080/springdemo0414/a/testHttpClientWithGet";
        Map<String,String> params = new HashMap<>();
        params.put("name","刘能");
        params.put("age","54");
        String result = HttpClientUtil.doGet(url, params);
        System.out.println("测试使用HttpClient发送get请求的返回值是："+result);
    }
    /**
     * 测试使用httpClient发送的post请求
     * 发送的参数是json
     */
    //@org.junit.Test
    public void testHttpClientWithPost(){
        String url = "http://localhost:8080/springdemo0414/a/testHttpClientWithPost";
        String params = "{\"id\":\"1\",\"name\":\"列侬\"}";
        String result = HttpClientUtil.doPost(url, params);
        System.out.println("测试使用HttpClient发送Post请求的返回值是："+result);
    }
    /**
     * 测试使用httpClient发送的post请求
     * 发送的参数是表单数据
     */
    //@org.junit.Test
    public void testHttpClientWithPost2(){
        String url = "http://localhost:8080/springdemo0414/a/testHttpClientWithPost2";
        Map<String,String> params = new HashMap<String,String>();
        params.put("username","刘能");
        params.put("password","123456");
        String result = HttpClientUtil.doPost2(url, params);
        System.out.println("测试使用HttpClient发送Post2请求的返回值是："+result);
    }
}
