package com.example.demo.service;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Classroom;
import com.example.demo.bean.Take;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
@Service
public interface Project_service {
    JSONObject create_project(String projectId,String projectName,String type,String teacherId,long studentNum);

    JSONObject personal_project(String StuId);

    JSONObject all_the_project();
}
