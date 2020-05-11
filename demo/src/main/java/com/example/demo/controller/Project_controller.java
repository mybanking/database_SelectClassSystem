package com.example.demo.controller;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Take;
import com.example.demo.mapper.Take_map;
import com.example.demo.service.Classroom_service;
import com.example.demo.service.Project_service;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class Project_controller {
    @Autowired
    Project_service service;

    @RequestMapping("/create_project")//可以的（成功）
    public JSONObject load_classroom(@Param("projectId") String projectId,@Param("projectName") String projectName,@Param("type") String type,@Param("teacherId") String teacherId,@Param("studentNum") long studentNum){
        return service.create_project(projectId,projectName,type,teacherId,studentNum);
    }

    @RequestMapping("/personal_project")//测试（成功） 可能目前还没有该数据
    public JSONObject load_classroom(@Param("stuId") String stuId){
        return service.personal_project(stuId);
    }

    @RequestMapping("/all_the_project")
    public JSONObject load_classroom(){
        return service.all_the_project();
    }

}
