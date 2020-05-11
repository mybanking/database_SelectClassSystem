package com.example.demo.bean;

public class Project {

  private String projectId;
  private String projectName;
  private String projectType;
  private String projectTime;
  private long studentNum;
  private String teacherId;


  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }


  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }


  public String getProjectType() {
    return projectType;
  }

  public void setProjectType(String projectType) {
    this.projectType = projectType;
  }


  public String getProjectTime() {
    return projectTime;
  }

  public void setProjectTime(String projectTime) {
    this.projectTime = projectTime;
  }


  public long getStudentNum() {
    return studentNum;
  }

  public void setStudentNum(long studentNum) {
    this.studentNum = studentNum;
  }


  public String getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
  }

}
