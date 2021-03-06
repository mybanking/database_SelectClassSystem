package com.example.demo.implement;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Student;
import com.example.demo.bean.Teacher;
import com.example.demo.mapper.Manager_mapper;
import com.example.demo.mapper.Student_mapper;
import com.example.demo.mapper.Teacher_mapper;
import com.example.demo.service.Login_user_service;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_implement implements Login_user_service {
    @Autowired
    private Student_mapper mapper_stu;

    @Autowired
    private Teacher_mapper mapper_tea;

    @Autowired
    private Manager_mapper mapper_man;



    @Override
    public JSONObject log_my_stu(String username, String password, String person) {
        System.out.println(username);
        Student stu = mapper_stu.findByStuid(username,password);
        JSONObject res = new JSONObject();
        if (stu==null) {
            res.put("check","false");
           // res.put("message", "此学生不存在");
            return res;
        }else{
            res.put("check","true");
            return res;
        }
    }

    @Override
    public JSONObject log_my_tea(String username, String password, String person) {
        Teacher tea = mapper_tea.findbyTeacher(username,password);
        JSONObject res = new JSONObject();
        if (tea==null) {
            res.put("check","false");
          //  res.put("message", "此老师不存在");
            return res;
        }else{
            res.put("check","true");
            return res;
        }
    }

    @Override
    public JSONObject log_my_manager(String username, String password, String person) {
        Manager manager = mapper_man.findBymanid(username,password);
        JSONObject res = new JSONObject();
        if(manager == null){
            res.put("check","false");
         //   res.put("message","此管理员不存在");
            return res;
        }else{
            res.put("check","true");
            return res;
        }

    }
}








