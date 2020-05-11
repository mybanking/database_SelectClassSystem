package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.Load_grade_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class grade_controller {
    @Autowired
    private Load_grade_service service;

    @RequestMapping("/student/grade")//查找学生全部成绩（成功）
    public JSONObject load_home_time(@RequestParam("id") String id,
                                     @RequestParam("type") String type){
        return service.load_grade(id, type);
    }

    @RequestMapping("/student/search/grade")//查找改年的分数（成功）
    public JSONObject search_grade(@RequestParam("id") String id,
                                   @RequestParam("type") String type,
                                   @RequestParam("year") String year,
                                   @RequestParam("semster") String semster){
        return service.search_grade(id,year);
    }

    @RequestMapping("/student/totalCredit")//查询对应学分（成功）
    public JSONObject load_totalCredit(@RequestParam("id") String id,
                                       @RequestParam("type") String year){
        return service.load_totalCredit(id,year);
    }



}
