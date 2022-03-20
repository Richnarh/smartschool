/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.smartadmin.services;

import com.khoders.resource.jpa.CrudApi;
import com.khoders.smartschool.entities.AcademicLevel;
import com.khoders.smartschool.entities.ClassRoom;
import com.khoders.smartschool.entities.Course;
import com.khoders.smartschool.entities.FeesType;
import com.khoders.smartschool.entities.Student;
import com.khoders.smartschool.entities.setup.UserAccount;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author richa
 */
@Stateless
public class ConfigService
{
    @Inject private CrudApi crudApi;
    
    public List<FeesType> getFeesTypeList(){
        return crudApi.getEm().createQuery("SELECT e FROM FeesType e ORDER BY e.createdDate ASC", FeesType.class).getResultList(); 
    }
    public List<AcademicLevel> getAcademicLevelList(){
        return crudApi.getEm().createQuery("SELECT e FROM AcademicLevel e ORDER BY e.createdDate ASC", AcademicLevel.class).getResultList();
    }
    public List<ClassRoom> getClassRoomList(){
        return crudApi.getEm().createQuery("SELECT e FROM ClassRoom e ORDER BY e.createdDate ASC", ClassRoom.class).getResultList();
    }
    public List<Course> courseList(){
        return crudApi.getEm().createQuery("SELECT e FROM Course e ORDER BY e.createdDate ASC", Course.class).getResultList(); 
    }
    public List<Student> studentList(){
        return crudApi.getEm().createQuery("SELECT e FROM Student e ORDER BY e.createdDate ASC", Student.class).getResultList(); 
    }
    public List<UserAccount> userAccountList(){
        return crudApi.getEm().createQuery("SELECT e FROM UserAccount e ORDER BY e.createdDate ASC", UserAccount.class).getResultList(); 
    }
}
