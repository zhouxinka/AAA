package com.example.service;

import com.example.entity.Encrypt;
import com.example.entity.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    List<Teacher> findAllTeacher();
    Teacher getTeacherById(int id);
    List<Map<String,Object>> getTeacherByAge(int age);
    void addTeacher(Teacher teacher);
    Teacher getTeacherByPhone(Encrypt phone);
}
