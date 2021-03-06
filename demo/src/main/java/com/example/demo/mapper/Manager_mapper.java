package com.example.demo.mapper;

import org.apache.catalina.Manager;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface Manager_mapper {
    @Select("select * from Student where managerId=#{stuId} and code = #{code}")
    Manager findBymanid(@Param("managerId") String managerId, @Param("code") String code);
}
