/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.smartadmin.jbeans.controller;

import com.khoders.resource.jpa.CrudApi;
import com.khoders.resource.utilities.CollectionList;
import com.khoders.resource.utilities.Msg;
import com.khoders.resource.utilities.SystemUtils;
import com.khoders.smartschool.entities.School;
import com.khoders.smartschool.smartadmin.services.AppService;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author richa
 */
@Named(value = "schoolController")
@SessionScoped
public class SchoolController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private AppService appService;
    
    private School school = new School();
    private List<School> schoolList = new LinkedList<>();
    private String optionText;
    
    @PostConstruct
    private void init()
    {
        clearSchool();
       schoolList =  appService.schoolList();
    }
    
    public void saveSchool()
    {
        try
        {
            school.genRefNo();
          if(crudApi.save(school) != null)
          {
              schoolList = CollectionList.washList(schoolList, school);
              Msg.setMsg(Msg.SUCCESS_MESSAGE);
          }
          clearSchool();
        } catch (Exception e)
        {
           e.printStackTrace();
        }
    }
    
    public void editSchool(School school)
    {
        this.school = school;
        optionText = "Update";
    }
    
    public void deleteSchool(School school)
    {
        try
        {
            if(crudApi.delete(school))
            {
                schoolList.remove(school);
                Msg.setMsg(Msg.SUCCESS_MESSAGE);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void clearSchool()
    {
        school = new School();
        school.genRefNo();
        optionText = "Save Changes";
        SystemUtils.resetJsfUI();
    }

    public School getSchool()
    {
        return school;
    }

    public void setSchool(School school)
    {
        this.school = school;
    }

    public List<School> getSchoolList()
    {
        return schoolList;
    }

    public String getOptionText()
    {
        return optionText;
    }
    
}
