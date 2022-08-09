package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 08 09 12:18
 */
@Controller
public class TestController {
    @RequestMapping(value = "/test",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String test(){
        return "{\"name\":\"哈哈\"}";
    }
}
