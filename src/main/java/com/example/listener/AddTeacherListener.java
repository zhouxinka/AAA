package com.example.listener;

import com.example.entity.Teacher;
import com.example.event.AddTeacherEvent;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;
import java.util.Map;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 08 16 13:11
 */
@Component
public class AddTeacherListener implements ApplicationListener<AddTeacherEvent> {
    @Autowired
    private TeacherService teacherServiceImpl;
    @Override
    public void onApplicationEvent(AddTeacherEvent event) {
        System.out.println("###########AddTeacherListener.onApplicationEvent###########");
        Map<String, Object> map = event.getMap();
        teacherServiceImpl.addTeacherToSearch(map);
    }
}
