package com.example.demo.mapper;

import com.example.demo.bean.Teacher;
import com.example.demo.util.student.return_select_course;
import com.example.demo.util.teacher.return_today_course;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Teacher_mapper {

    @Select("select * from teacher where tId = #{tId} and mypassword = #{mypassword}")
    Teacher findbyTeacher(@Param("tId") String tId, @Param("mypassword") String mypassword);

    @Select("select courseNum,course.courseName,time,classroomId from course\n" +
            "left join teacher on teacher.teacherName = course.teacherName\n" +
            "left join take on take.takeId = teacher.tId\n" +
            "where teacher.tId = #{id} and time = #{weekdata};")
    List<return_today_course> load_today(String id, String weekdata);

    @Select("select courseNum,courseName,academyName,type,time,weekdata from course\n" +
            "left join teacher on teacher.teacherName = course.courseName\n" +
            "where tId = #{id} and year = #{year};")
    List<return_select_course> select_my_data(String id,String year);

    @Insert("insert into course(teacherName,courseNum,courseName,courseId,courseOrder,type,weekdata,time,courseMemberNum,semster,year) " +
            "values('#{teacherName}','#{courseNum}','#{courseName}','#{courseId}','#{courseOrder}','#{type}','#{weekdata}','#{time}','#{courseMemberNum}','#{semster}','#{year}');")
    int insert_selected_course(String teacherName,
                               String courseNum,
                               String courseName,
                               String courseId,
                               String courseOrder,
                               String type,
                               String weekdata,
                               String time,
                               String courseMemberNum,
                               String semster, String year);

    @Select("select teacherName from teacher where tId = #{id}")
    String teacherName(String id);

    @Select("select courseNum,courseName,academyName,type,time,weekdata from course\n" +
            "left join teacher on teacher.teacherName = course.courseName\n" +
            "where tId = #{id} and year != #{year};")
    List<return_select_course> select_history_data(String id, String year);
}
