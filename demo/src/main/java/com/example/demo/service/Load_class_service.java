package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONStreamAware;
import org.springframework.stereotype.Service;

@Service
public interface Load_class_service {
    JSONObject load_course_time(String id, String type);//课程1号功能

    JSONObject load_course_load(String id, String type);//课程2号功能

    JSONObject search_course(String year, String semster);

    JSONObject load_select_course(String id, String type);

    JSONObject load_selected_course(String id);

    JSONObject refresh_inserted_course(String id1, String courseNum, String s, String s1);
}
