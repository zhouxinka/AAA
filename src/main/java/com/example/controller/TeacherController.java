package com.example.controller;

import cn.hutool.crypto.SecureUtil;
import com.example.entity.Encrypt;
import com.example.entity.Teacher;
import com.example.entity.User;
import com.example.service.TeacherService;
import com.example.utils.EncodePhoneUtil;
import com.example.utils.Global;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
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
    public String teacherInfo(){
        return "teacherInfo";
    }

    @RequestMapping(value="/findTeacher",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String findTeacher(HttpServletRequest request) throws JsonProcessingException {
        System.out.println("###############TeacherController findTeacher###############");
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        System.out.println("draw:"+draw);
        System.out.println("start:"+start);
        System.out.println("length:"+length);
        System.out.println("name:"+name);
        System.out.println("phone:"+phone);
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        if(phone==null){
            map.put("phone",null);
        }else{
            map.put("phone",new Encrypt(phone));
        }

        map.put("start",Integer.parseInt(start));
        map.put("length",Integer.parseInt(length));
        List<Teacher> list = teacherServiceImpl.findAllTeacher(map);
        List<Teacher> allTeacherNoPage = teacherServiceImpl.findAllTeacherNoPage(map);
        String data = new ObjectMapper().writeValueAsString(list);
        System.out.println("data:"+data);
        String result = "{\"data\":" + data + ",\"length\":"+list.size()+",\"draw\":"+draw+",\"recordsTotal\":"+allTeacherNoPage.size()+",\"recordsFiltered\":"+allTeacherNoPage.size()+"}";
        return result;
    }

    @RequestMapping(value="/getTeacherByPhone/{phone}")
    @ResponseBody
    public Teacher getTeacherByPhone(@PathVariable(value = "phone") String phone){
        return teacherServiceImpl.getTeacherByPhone(new Encrypt(phone));
    }

    @RequestMapping(value="/getTeacherByAge/{age}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getTeacherByAge(@PathVariable(value = "age") Integer age) throws JsonProcessingException {
        return mapper.writeValueAsString(teacherServiceImpl.getTeacherByAge(age));
    }
    @RequestMapping(value="/addTeacher")
    public String addTeacher(){
        teacherServiceImpl.addTeacher();
        return "redirect:"+ Global.getAdminPath()+"/teacherInfo";
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
