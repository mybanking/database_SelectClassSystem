package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.Load_class_service;
import com.example.demo.service.Teacher_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//真正写的时候整合一起改，否则自己很难调
@RestController
public class Teacher_controller {

    @Autowired
    private Teacher_service service;


    @RequestMapping("/teacher/today/schedule")//查询老师当天要选的课（成功）
    public JSONObject LOAD_TODAY(@RequestParam("id") String id) throws ParseException {
        return service.load_today(id,getWeek());

    }

    @RequestMapping("/teacher/select/course")//加载老师要选的课(成功）
    public JSONObject select_data(@RequestParam("id") String id){
        SimpleDateFormat sim=new SimpleDateFormat("yyyy");
        System.out.println(sim.format(new Date()));
        return service.select_my_data(id,sim.format(new Date()));
    }

    @RequestMapping("/teacher/selected/course")//老师要选的课
    public JSONObject selected_data(@RequestParam("id") String id){
        SimpleDateFormat sim=new SimpleDateFormat("yyyy");
        return service.select_history_data(id,sim.format(new Date()));
    }


    @RequestMapping("/teacher/insert/course")//将选的课插入到数据库中（成功）
    public JSONObject insert_selected_course(@RequestParam("id") String id,
                                           @RequestParam("courseName") String courseName,
                                           @RequestParam("academyName") String academyName,
                                           @RequestParam("courseNum") String courseNum,
                                           @RequestParam("type") String type,
                                           @RequestParam("courseTime") String courseTime,
                                             @RequestParam("courseMemberNum") String courseMemberNum,
                                             @RequestParam("semster") String semster){

        SimpleDateFormat sim=new SimpleDateFormat("yyyy");

        String str_courseTime[] = courseTime.split(" ");
        System.out.println(str_courseTime[0]);
        String str_courseNum[] = courseNum.split("-");
        System.out.println(str_courseNum[0]);
        return service.insert_selected_course(  courseNum,
                                                courseName,
                                                str_courseNum[0],
                                                str_courseNum[1],
                                                type,
                                                str_courseTime[0],
                                                str_courseTime[1],
                                                sim.format(new Date()),
                                                courseMemberNum,
                                                semster,
                                                sim.format(new Date())
                                                 );
    }

    private String getWeek() {
        String week = "";
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        int weekday = c.get(Calendar.DAY_OF_WEEK);
        if (weekday == 1) {
            week = "7";
        } else if (weekday == 2) {
            week = "1";
        } else if (weekday == 3) {
            week = "2";
        } else if (weekday == 4) {
            week = "3";
        } else if (weekday == 5) {
            week = "4";
        } else if (weekday == 6) {
            week = "5";
        } else if (weekday == 7) {
            week = "6";
        }
        return week;
    }

}
