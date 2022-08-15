package com.example.controller;

import cn.hutool.crypto.SecureUtil;
import com.example.entity.Encrypt;
import com.example.entity.Teacher;
import com.example.service.TeacherService;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * @author zhoupeng
 * @create time 2021-05-07-16:23
 */
@Controller
@RequestMapping("${adminPath}")
//@Scope("prototype")
public class TeacherController extends BaseController {

    private static final byte[] KEYS = "12345678abcdefgh".getBytes(StandardCharsets.UTF_8);

    static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object arg0, JsonGenerator arg1, SerializerProvider arg2)
                    throws IOException, JsonProcessingException {
                arg1.writeString("");
            }
        });
    }
    @Autowired
    private TeacherService teacherServiceImpl;

    @RequestMapping(value="/teacherInfo")
    public String teacherInfo(Model model){
        //Teacher teacher = teacherServiceImpl.getTeacherById(1);
        //System.out.println(teacher.toString());
        //System.out.println("===================================");
        List<Teacher> list = teacherServiceImpl.findAllTeacher();
        for (Teacher teacher : list) {
            System.out.println(teacher.toString());
        }
        model.addAttribute("list",list);
        return "teacherInfo";
    }
    @RequestMapping(value="/getTeacherByPhone/{phone}")
    @ResponseBody
    public Teacher getTeacherByPhone(@PathVariable(value = "phone") String phone){
        Teacher teacherByPhone = teacherServiceImpl.getTeacherByPhone(new Encrypt(phone));
        return teacherByPhone;
    }
    @RequestMapping(value="/getTeacherByAge/{age}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getTeacherByAge(@PathVariable(value = "age") Integer age) throws JsonProcessingException {
        List<Map<String, Object>> teacherList = teacherServiceImpl.getTeacherByAge(age);
        //将phone字段解码
        for(Map<String, Object> map:teacherList){
            String phone = (String) map.get("phone");
            String newPhone = SecureUtil.aes(KEYS).decryptStr(phone);
            map.put("phone",newPhone);
        }
        return mapper.writeValueAsString(teacherList);
    }
    @RequestMapping(value="/addTeacher")
    public String addTeacher(){
        Teacher teacher = new Teacher();
        teacher.setName("blincon");
        teacher.setAge(45);
        teacher.setGender("female");
        teacher.setPhone(new Encrypt("13916274799"));
        teacherServiceImpl.addTeacher(teacher);
        //重定向到a/userInfo请求
        return "redirect:/a/teacherInfo";
    }
    /**
     * @ModelAttribute修是的方法会先于@RequestMapping修饰的方法执行，并且拿到请求里面的参数
     * @param model
     * @param string
     */
    @ModelAttribute
    public void testModelAttribute1(Model model,String string){
        model.addAttribute("test","it is a test...");
        System.out.println("string=========>:"+string);
    }
    @RequestMapping(value="/test")
    public void testModelAttribute2(Model model,RedirectAttributes redirectAttributes){
        String test = (String)model.getAttribute("test");
        System.out.println("model.getAttribute(\"test\"):"+test);
    }
}
