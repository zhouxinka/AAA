package com.example.dao;

import com.example.annotations.MybatisDao;
import com.example.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@MybatisDao
public interface UserDao extends CrudDao<User>{
    void addUser(User user);

    List<User> findAllUser(User user);
    List<User> findAllUser_2(@Param("map") Map<String, Integer> map);
    User insertUser(User user);

    User getUserByName(String name);


    /**
     * @param id
     * @return
     * @Param的作用是使参数与mapper.xml里面的参数一致
     */
    User getUserById(@Param("i") Integer id);
}
