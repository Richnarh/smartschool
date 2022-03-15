/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.smartadmin.commons;

import com.khoders.smartschool.entities.AcademicLevel;
import com.khoders.smartschool.entities.ClassRoom;
import com.khoders.smartschool.entities.FeesType;
import com.khoders.smartschool.entities.Student;
import com.khoders.smartschool.smartadmin.services.ConfigService;
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
    @Inject private ConfigService configService;
    
    private List<Student> studentList = new LinkedList<>();
    private List<AcademicLevel> academicLevelList = new LinkedList<>();
    private List<ClassRoom> classRoomList = new LinkedList<>();
    private List<FeesType> feesTypeList = new LinkedList<>();
    
    @PostConstruct
    public void init(){
       studentList = configService.studentList();
       academicLevelList = configService.getAcademicLevelList();
       classRoomList = configService.getClassRoomList();
       feesTypeList = configService.getFeesTypeList();
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
    
}
