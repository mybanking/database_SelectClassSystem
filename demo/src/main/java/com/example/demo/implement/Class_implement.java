package com.example.demo.implement;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.Class_mapper;
import com.example.demo.service.Load_class_service;
import com.example.demo.util.student.return_date;
import com.example.demo.util.student.return_student_course;
import com.example.demo.util.student.return_select_course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Class_implement implements Load_class_service {
    @Autowired
    private Class_mapper mapper;

    @Override//加载时间
    public JSONObject load_course_time(String id, String type) {
        List<return_date> date_time = mapper.gettime();
        JSONObject res = new JSONObject();

        if(date_time!=null) {
            res.put("data", date_time);
            return res;
        }
        else{
            res.put("code",404);
            return res;
        }
    }

    @Override//加载课程
    public JSONObject load_course_load(String id, String type) {
        List<return_student_course> get_courses = mapper.getmyClass();
        JSONObject res = new JSONObject();

        if(get_courses!=null){
            res.put("data",get_courses);
            return res;
        }
        else{
            res.put("code",404);
            return res;
        }
    }

    @Override
    public JSONObject search_course(String year, String semster) {
        List<return_student_course> get_courses = mapper.getregularClass(year, semster);
        JSONObject res = new JSONObject();

        if(get_courses!=null){
            res.put("data",get_courses);
            return res;
        }
        else{
            res.put("code",404);
            return res;
        }
    }

    @Override
    public JSONObject load_select_course(String id, String type) {
        String limitgrade = mapper.return_limit_grade(id);
       // System.out.println(limitgrade);
        List<return_select_course> load_select_courses = mapper.get_select_course(limitgrade,type);
        JSONObject res = new JSONObject();

        if(load_select_courses!=null){
            res.put("data",load_select_courses);
            return res;
        }
        else{
            res.put("message","not found");
            return res;
        }
    }

    @Override
    public JSONObject load_selected_course(String id) {;
        List<return_select_course> load_selected_courses = mapper.get_selected_course(id);
        JSONObject res = new JSONObject();
        if(load_selected_courses!=null){
            res.put("data",load_selected_courses);
            return res;
        }
        else{
            res.put("message","no class found");
            return res;
        }
    }

    @Override
    public JSONObject refresh_inserted_course(String id, String courseNum, String year, String semster) {
        List<return_select_course> load_select_courses = mapper.refresh_inserted_course(id,courseNum,year,semster);
        JSONObject res = new JSONObject();
        if(load_select_courses!=null){
            res.put("data","ok");
            return res;
        }
        else{
            return (JSONObject) res.put("check",false);
        }
    }


}
