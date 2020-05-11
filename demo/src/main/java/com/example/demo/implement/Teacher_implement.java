package com.example.demo.implement;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.Teacher_mapper;
import com.example.demo.service.Teacher_service;
import com.example.demo.util.student.return_select_course;
import com.example.demo.util.teacher.return_today_course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Teacher_implement implements Teacher_service {
    @Autowired
    Teacher_mapper mapper;

    @Override//加载今天的课程
    public JSONObject load_today(String id, String weekdata) {
        JSONObject res = new JSONObject();
        List<return_today_course> today_courses = mapper.load_today(id, weekdata);
        if (today_courses!=null){
            res.put("data",today_courses);
            return res;
        }
        else{
             res.put("check",false);
             return res;
        }
    }

    @Override//返回老师将要选的课程
    public JSONObject select_my_data(String id, String year) {
        JSONObject res = new JSONObject();
        List<return_select_course> return_teacher_courses = mapper.select_my_data(id, year);
        if(return_teacher_courses!=null){
            res.put("data",return_teacher_courses);
            return res;
        }
        else{
            res.put("check",false);
            return res;
        }
    }



    @Override
    public JSONObject insert_selected_course(String id,
                                             String courseNum,
                                             String courseName,
                                             String courseId,
                                             String courseOrder,
                                             String type,
                                             String weekdata,
                                             String time,
                                             String courseMemberNum,
                                             String semster,
                                             String year) {

        String teacherName = mapper.teacherName(id);
        System.out.println(teacherName);
        mapper.insert_selected_course(teacherName,
                                        courseName,
                                        courseNum,
                                        courseId,
                                        courseOrder,
                                        type,
                                        weekdata,
                                        time,
                                        courseMemberNum,
                                        semster,
                                        year);
        return null;
    }

    @Override
    public JSONObject select_history_data(String id, String year) {
        JSONObject res = new JSONObject();
        List<return_select_course> return_teacher_courses = mapper.select_history_data(id, year);
        if(return_teacher_courses!=null){
            res.put("data",return_teacher_courses);
            return res;
        }
        else{
            res.put("check",false);
            return res;
        }
    }


}
