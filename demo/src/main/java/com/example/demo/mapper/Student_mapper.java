package com.example.demo.mapper;

import com.example.demo.bean.Student;
import org.apache.ibatis.annotations.*;

public interface Student_mapper {
//
//    @Select("select * from Student")
//    List<Student> get_student();

    @Select("select * from Student where stuId=#{stuId} and password = #{password}")
    Student findByStuid(@Param("stuId") String stuId, @Param("password") String password);



}
