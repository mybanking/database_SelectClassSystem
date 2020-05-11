package com.example.demo.mapper;

import com.example.demo.bean.Pickproject;
import com.example.demo.bean.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Project_map {
    @Select("select * from Project")
    List<Project> get_project();

    @Delete("delete from Project where project_id=#{projectId}")
    int delete_project(Project p);

    @Insert("insert into Project values(#{projectId},#{projectName},#{projectType},#{projectTime},#{studentNum},#{teacherId})")
    int insert_project(Project p);

    @Update("update Project set project_type = #{projectType} where project_id=#{projetId}")
    int update_project(Project p);

    @Update("update Project set project_time = #{projectTime} where project_id=#{projetId}")
    int update_time(Project p);

    @Update("update Project set student_num = #{studentNum} where project_id=#{projetId}")
    int update_num(Project p);

    @Update("update Project set project_name = #{ProjectName} where project_id=#{projetId}")
    int update_name(Project p);

    @Update("update Project set teacher_id = #{teacherId} where project_id=#{projetId}")
    int upate_teacher(Project p);

    @Select("select * from pickproject where stuId = #{stuId}")
    List<Pickproject> personal_project(@Param("stuId")String stuId);

    @Select("select * from pickproject")
    List<Pickproject> all_the_project();


}

