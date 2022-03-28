/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.smartweb.commons;

import com.khoders.smartschool.entities.AcademicLevel;
import com.khoders.smartschool.entities.AcademicTerm;
import com.khoders.smartschool.entities.ClassRoom;
import com.khoders.smartschool.entities.Course;
import com.khoders.smartschool.entities.FeesType;
import com.khoders.smartschool.entities.Student;
import com.khoders.smartschool.smartweb.services.ConfigService;
import com.khoders.smartschool.smartweb.services.StudentService;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author richa
 */
@Named(value = "userCommons")
public class UserCommons implements Serializable
{
    @Inject private StudentService studentService;
    @Inject private ConfigService configService;
    
    private List<Student> studentList = new LinkedList<>();
    private List<AcademicLevel> academicLevelList = new LinkedList<>();
    private List<ClassRoom> classRoomList = new LinkedList<>();
    private List<FeesType> feesTypeList = new LinkedList<>();
    private List<AcademicTerm> academicTermList = new LinkedList<>();
    private List<Course> courseList = new LinkedList<>();
    
    @PostConstruct
    public void init(){
       studentList = studentService.studentList();
       academicLevelList = configService.getAcademicLevelList();
       academicTermList = configService.getAcademicTermList();
       classRoomList = configService.getClassRoomList();
       feesTypeList = configService.getFeesTypeList();
       courseList = configService.getCourseList();
    }

    public List<Student> getStudentList()
    {
        return studentList;
    }

    public List<AcademicLevel> getAcademicLevelList()
    {
        return academicLevelList;
    }

    public List<ClassRoom> getClassRoomList()
    {
        return classRoomList;
    }

    public List<FeesType> getFeesTypeList()
    {
        return feesTypeList;
    }

    public List<AcademicTerm> getAcademicTermList()
    {
        return academicTermList;
    }

    public List<Course> getCourseList()
    {
        return courseList;
    }
    
}
