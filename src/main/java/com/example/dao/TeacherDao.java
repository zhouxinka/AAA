package com.example.dao;

import com.example.annotations.MybatisDao;
import com.example.entity.Encrypt;
import com.example.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@MybatisDao
public interface TeacherDao {
    List<Teacher> findAllTeacher();
    Teacher getTeacherById(int id);
    List<Map<String,Object>> getTeacherByAge(int age);
    void addTeacher(Teacher teacher);
    Teacher getTeacherByPhone(@Param("phone") Encrypt phone);
}
