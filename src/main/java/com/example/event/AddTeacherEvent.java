package com.example.event;

import com.example.entity.Teacher;
import org.springframework.context.ApplicationEvent;

import java.util.Map;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 08 16 13:10
 */
public class AddTeacherEvent extends ApplicationEvent {
    private Map<String,Object> map;
    public AddTeacherEvent(Object source, Map<String,Object> map) {
        super(source);
        this.map = map;
    }

    public Map<String,Object> getMap() {
        return map;
    }

    public void setMap(Map<String,Object> map) {
        this.map = map;
    }
}
