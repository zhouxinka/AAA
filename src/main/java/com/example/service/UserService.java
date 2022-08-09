package com.example.service;

import com.example.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface UserService {
    void addUser(User user, HttpServletRequest request);
    void deleteUser(User user);
    List<User> findAllUser(User user);
    List<User> findAllUser_2(Map<String, Integer> map);
    User getUserById(Integer id);
    User getUserByName(String name);
}
