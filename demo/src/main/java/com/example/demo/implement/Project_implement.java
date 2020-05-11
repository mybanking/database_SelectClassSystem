package com.example.demo.implement;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Classroom;
import com.example.demo.bean.Pickproject;
import com.example.demo.bean.Project;
import com.example.demo.bean.Take;
import com.example.demo.mapper.Classroom_map;
import com.example.demo.mapper.Project_map;
import com.example.demo.mapper.Take_map;
import com.example.demo.service.Classroom_service;
import com.example.demo.service.Project_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Project_implement implements Project_service {
    @Autowired
    Project_map project_map;

    @Override
    public JSONObject create_project(String projectId,String projectName,String type,String teacherId,long studentNum)
    {
        JSONObject result = new JSONObject();
        Project p = new Project();
        p.setProjectId(projectId);
        p.setProjectName(projectName);
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
        String today = dateFormat.format( now );
        p.setProjectTime(today);
        p.setProjectType(type);
        p.setStudentNum(studentNum);
        p.setTeacherId(teacherId);
        project_map.insert_project(p);
        result.put("check","true");
        return result;
    }

    @Override
    public JSONObject personal_project(String StuId)
    {
        JSONObject result = new JSONObject();
        List<Pickproject> a = project_map.personal_project(StuId);
        result.put("data",a);
        return result;
    }

    @Override
    public JSONObject all_the_project()
    {
        JSONObject result = new JSONObject();
        List<Pickproject> a = project_map.all_the_project();
        result.put("data",a);
        return result;
    }
}
