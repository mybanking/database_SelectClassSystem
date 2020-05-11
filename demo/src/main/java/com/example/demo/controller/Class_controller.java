package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.Load_class_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Class_controller {
    @Autowired
    private Load_class_service service;

    @RequestMapping("/student/home/time")//加载选择课程的时间，实现降序排列（成功）
    public JSONObject load_home_time(@RequestParam("id") String id,
                                     @RequestParam("type") String type){
        return service.load_course_time(id,type);
    }

    @RequestMapping("/student/load/course")//加载学生可以选择的全部课程（成功）
    public JSONObject load_course_load(@RequestParam("id") String id,
                                       @RequestParam("type") String type){
        return service.load_course_load(id,type);
    }

    @RequestMapping("/student/search/course")//查询课程，按照指定年份和季度（成功）
    public JSONObject search_course(@RequestParam("id") String id,
                                    @RequestParam("type") String type,
                                    @RequestParam("year") String year,
                                    @RequestParam("semster") String semster){
        return service.search_course(year,semster);
    }

    @RequestMapping("/student/select/course")//选课信息加载，限制了限选年级（成功）
    public JSONObject load_select_course(@RequestParam("id") String id,
                                         @RequestParam("type") String type){
        return service.load_select_course(id,type);
    }

    @RequestMapping("/student/selected/course")//已选课程加载(成功）
    public JSONObject load_selected_course(@RequestParam("id") String id,
                                           @RequestParam("type") String type){
        return service.load_selected_course(id);
    }

    @RequestMapping("/refresh/inserted/information")//刷新已选课程(成功）校验已经插入
    public JSONObject refresh_inserted_information(@RequestParam("id") String id,
                                                   @RequestParam("type") String type,
                                                   @RequestParam("courseNumber") String courseNumber,
                                                   @RequestParam("data") String date){
        //将date划分为学期和学年
        String[] strArr= date.split("/");
        System.out.println(strArr[0]+"/"+strArr[1]);
        return  service.refresh_inserted_course(id,courseNumber,strArr[0],strArr[1]);
    }

    @RequestMapping("/student/refreshed/selected/information")//刷新已选课程(成功）
    public JSONObject refresh_selected_course(@RequestParam("id") String id,
                                              @RequestParam("type") String type,
                                              @RequestParam("courseNumber") String courseNumber,
                                              @RequestParam("data") String date){
        return service.load_selected_course(id);
    }





}
