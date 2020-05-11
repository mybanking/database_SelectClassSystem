package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.Login_user_service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class Login_controllor{

    @Autowired
    private Login_user_service service;

    //登录窗口判别身份和进行认证
    @RequestMapping(value = "/login/check", method = RequestMethod.POST)
    public JSONObject login_1(@RequestBody String json){
        System.out.println(json.toString());
        JSONObject wrong_message = new JSONObject();
        JSONObject jsonObject = JSONObject.parseObject(json);

        if(jsonObject.getString("person").equals("student")){
            return service.log_my_stu(jsonObject.getString("name"),jsonObject.getString("psw"),jsonObject.getString("person"));
        }
        else if (jsonObject.getString("person").equals("teacher")){
            return service.log_my_tea(jsonObject.getString("name"),jsonObject.getString("psw"),jsonObject.getString("person"));
        }
        else if(jsonObject.getString("person").equals("manager")){
            return service.log_my_manager(jsonObject.getString("name"),jsonObject.getString("psw"),jsonObject.getString("person"));
        }
        wrong_message.put("message","none of this person");
        return wrong_message;
    }
}
