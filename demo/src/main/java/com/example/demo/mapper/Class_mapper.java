package com.example.demo.mapper;

import com.example.demo.util.student.return_date;
import com.example.demo.util.student.return_student_course;
import com.example.demo.util.student.return_select_course;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Class_mapper {

    @Select("select time,year from course order by year desc;")//提取time,year
    List<return_date> gettime();

    @Select("select courseName,teacher.teacherName,course.`year`,semster,weekdata,time,building,classroom.classroomId,startTime,endTime from course \n" +
            "left join teacher on teacher.teacherName = course.teacherName\n" +
            "left join take on take.takeId = teacher.tId\n" +
            "left join classroom on classroom.classroomId = take.classroomId")//提取全部课程
    List<return_student_course> getmyClass();

    @Select("select courseName,teacher.teacherName,course.`year`,semster,weekdata,time,building,classroom.classroomId,startTime,endTime from course \n" +
            "left join teacher on teacher.teacherName = course.teacherName\n" +
            "left join take on take.takeId = teacher.tId\n" +
            "left join classroom on classroom.classroomId = take.classroomId\n" +
            "where course.year = #{year} and semster = #{semster};")//提取指定的全部课程
    List<return_student_course> getregularClass(String year, String semster);

    @Select("select courseNum,courseName,teacher.teacherName,teacher.academyName,type,time,courseMemberNum,capacity,information from course \n" +
            "left join teacher on teacher.teacherName = course.teacherName\n" +
            "left join academy on academy.academyName = teacher.academyName where limitGrade = #{limitgrade} and type =#{type};\n")
    List<return_select_course> get_select_course(String limitgrade,String type);

    @Select("select grade from student where stuId = #{id}")
    String return_limit_grade(String id);

    @Select("select course.courseNum,courseName,teacher.teacherName,teacher.academyName,type,time,capacity,courseMemberNum,information from course \n" +
            "left join teacher on teacher.teacherName = course.teacherName\n" +
            "left join academy on academy.academyName = teacher.academyName \n" +
            "left join sc on sc.courseNum = course.courseNum\n" +
            "where stuId =#{id};")
    List<return_select_course> get_selected_course(String id);

    @Select("INSERT INTO `sc` VALUES (#{id}, #{courseNum}, #{year}, #{semster},null, null, null, null);")
    List<return_select_course> refresh_inserted_course(String id, String courseNum, String year, String semster);
}
