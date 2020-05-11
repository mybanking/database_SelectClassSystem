package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface Teacher_service {
    JSONObject load_today(String id, String weekdata);

    JSONObject select_my_data(String id, String year);

    JSONObject insert_selected_course(String id,
                                      String courseName,
                                      String courseNum,
                                      String courseId,
                                      String courseOrder,
                                      String type,
                                      String weekdata,
                                      String time,
                                      String courseMemberNum,
                                      String semster, String year);

    JSONObject select_history_data(String id, String format);
}
