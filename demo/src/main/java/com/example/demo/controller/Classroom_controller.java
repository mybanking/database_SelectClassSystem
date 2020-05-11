package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Take;
import com.example.demo.mapper.Take_map;
import com.example.demo.service.Classroom_service;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class Classroom_controller {

    @Autowired
    Classroom_service service;
    @Autowired
    Take_map take;
   @RequestMapping("/load_Classroom")//测试（成功）
    public JSONObject load_classroom(@Param("id")String id,
                                     @Param("type")String type){
        return service.load_classroom(id,type);
    }
    @RequestMapping("/applyClassroom")//有问题没有反值
    public JSONObject apply_classroom(Take t){
        return service.apply_classroom(t);
    }


    @RequestMapping("/load_selected_classroom")//测试（成功）
    public JSONObject load_selected_classroom(@Param("id") String id,
                                              @Param("type") String type)
    {
        return service.selected_classroom(id,type);
    }

    @RequestMapping("/search_selected_classroom")//测试（成功）
    public JSONObject search_selected_classroom(@Param("id")String id,
                                                @Param("type") String type,
                                                @Param("year") String year,
                                                @Param("week") String week,
                                                @Param("building") String building,
                                                @Param("classroomid") String classroomid)
    {
        return service.search_selected_classroom(id,type,year,week,building,classroomid);
    }

    @RequestMapping("/search_classroom")//测试（成功）
    public JSONObject serach_classroom(@Param("id")String id,
                                       @Param("type") String type,
                                       @Param("year") String year,
                                       @Param("week") String week,
                                       @Param("building") String building,
                                       @Param("classroomid") String classroomid)
    {
        return service.search_specclassroom(id,type,year,week,building,classroomid);
    }

    @RequestMapping("/cancel_apply")//测试（成功）：说明没有此申请
    public JSONObject cancel_apply(@Param("id")String id,
                                   @Param("classroomId")String classroomId,
                                   @Param("takeDate")String takeDate,
                                   @Param("starttime")String starttime,
                                   @Param("endtime")String endtime,
                                   @Param("week")String week,
                                   @Param("day")String day)
    {
        return service.cancel_apply(id,classroomId,takeDate,starttime,endtime,week,day);
    }

}
