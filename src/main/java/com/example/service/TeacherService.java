package com.example.service;

import com.example.entity.Encrypt;
import com.example.entity.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    List<Teacher> findAllTeacher(Map<String,Object> map);
    List<Teacher> findAllTeacherNoPage(Map<String,Object> map);
    Teacher getTeacherById(int id);
    List<Map<String,Object>> getTeacherByAge(int age);
    void addTeacher();
    Teacher getTeacherByPhone(Encrypt phone);

    void addTeacherToSearch(Map<String,Object> map);
}
