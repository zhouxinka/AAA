package com.example.serviceImpl;

import com.example.dao.TeacherDao;
import com.example.entity.Encrypt;
import com.example.entity.Teacher;
import com.example.event.AddTeacherEvent;
import com.example.service.TeacherService;
import com.example.utils.EncodePhoneUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhoupeng
 * @create time 2021-04-14-15:10
 */
@Service
public class TeacherServiceImpl extends Exception implements TeacherService {
    @Resource
    private TeacherDao teacherDao;
    @Autowired
    private ApplicationContext applicationContext;

    public List<Teacher> findAllTeacher(Map<String,Object> map) {
        return teacherDao.findAllTeacher_2(map);
    }
    public List<Teacher> findAllTeacherNoPage(Map<String,Object> map) {
        return teacherDao.findAllTeacherNoPage(map);
    }
    public Teacher getTeacherById(int id) {
        return teacherDao.getTeacherById(id);
    }

    public List<Map<String, Object>> getTeacherByAge(int age) {
        List<Map<String, Object>> teacherList = teacherDao.getTeacherByAge(age);
        //将phone字段解码
        for(Map<String, Object> map:teacherList){
            String phone = (String) map.get("phone");
            String newPhone = EncodePhoneUtil.decrypt(phone);
            map.put("phone",newPhone);
        }
        return teacherList;
    }
    public Map<String,Object> getParamsForAddTeacherToSearch(Teacher teacher){
        Map<String,Object> map = new HashMap<>();
        map.put("teacher_id",teacher.getId());
        String phone = teacher.getPhone().getValue();
        String newPhone = EncodePhoneUtil.encrypt(phone);
        map.put("phone",newPhone);
        List<String> list = EncodePhoneUtil.splitAndEncrypt(phone);
        map.put("index_1",list.get(0));
        map.put("index_2",list.get(1));
        map.put("index_3",list.get(2));
        map.put("index_4",list.get(3));
        map.put("index_5",list.get(4));
        map.put("index_6",list.get(5));
        map.put("index_7",list.get(6));
        map.put("index_8",list.get(7));
        map.put("index_9",list.get(8));
        return map;
    }
    @Override
    public void addTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName("woody");
        teacher.setAge(31);
        teacher.setGender("male");
        teacher.setPhone(new Encrypt("15255429942"));
        teacherDao.addTeacher(teacher);
        Map<String, Object> map = getParamsForAddTeacherToSearch(teacher);
        //发布事件
        applicationContext.publishEvent(new AddTeacherEvent(this,map));
    }
    @Override
    public void addTeacherToSearch(Map<String,Object> map) {
        teacherDao.addTeacherToSearch(map);
    }

    @Override
    public Teacher getTeacherByPhone(Encrypt phone) {
        return teacherDao.getTeacherByPhone(phone);
    }
}
