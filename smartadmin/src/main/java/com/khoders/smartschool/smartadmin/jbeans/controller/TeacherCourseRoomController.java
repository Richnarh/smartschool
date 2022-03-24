/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.smartadmin.jbeans.controller;

import com.khoders.resource.jpa.CrudApi;
import com.khoders.resource.utilities.CollectionList;
import com.khoders.resource.utilities.FormView;
import com.khoders.resource.utilities.Msg;
import com.khoders.resource.utilities.SystemUtils;
import com.khoders.smartschool.entities.SchoolSubject;
import com.khoders.smartschool.entities.TeacherSubject;
import com.khoders.smartschool.entities.setup.UserAccount;
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
 * @author richard
 */
@Named(value = "teacherCourseRoomController")
@SessionScoped
public class TeacherCourseRoomController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private AppService appService;
    
    private FormView pageView = FormView.listForm();
    private TeacherSubject teacherSubject = new TeacherSubject();
    private List<TeacherSubject> teacherSubjectList = new LinkedList<>();
    private UserAccount selectTeacher = null;
    
    private SchoolSubject schoolSubject = new SchoolSubject();
    private List<SchoolSubject> schoolSubjectList = new LinkedList<>();

    private String optionText;

    @PostConstruct
    private void init()
    {
        clearTeacherSubject();
        teacherSubjectList = appService.teacherSubjectList();
    }
    
    public void selectedStaff(){
        selectTeacher = teacherSubject.getUserAccount();
        System.out.println("selected -- ");
    }
    
    public void saveTeacherSubject()
    {
        try
        {
            if (crudApi.save(teacherSubject) != null)
            {
                teacherSubjectList = CollectionList.washList(teacherSubjectList, teacherSubject);
                Msg.info(Msg.SUCCESS_MESSAGE);
            }
            clearTeacherSubject();
        } catch (Exception e)
        {
          e.printStackTrace();
        }
    }

    public void editTeacherSubject(TeacherSubject teacherSubject)
    {
        this.teacherSubject = teacherSubject;
        optionText = "Update";
    }

    public void deleteTeacherSubject(TeacherSubject teacherSubject)
    {
        try
        {
            if (crudApi.delete(teacherSubject))
            {
                teacherSubjectList.remove(teacherSubject);
                Msg.info(Msg.SUCCESS_MESSAGE);
            }
        } catch (Exception e)
        {
           e.printStackTrace();
        }
    }
    
    public void manageSchoolSubject(TeacherSubject teacherSubject){
        this.teacherSubject = teacherSubject;
        selectTeacher = teacherSubject.getUserAccount();
        pageView.restToCreateView();
        schoolSubjectList = appService.schoolSubjectList(teacherSubject);
    }
    
    public void saveSchoolSubject()
    {
        try
        {
            schoolSubject.setTeacherSubject(teacherSubject);
            if(crudApi.save(schoolSubject) != null)
            {
                schoolSubjectList = CollectionList.washList(schoolSubjectList, schoolSubject);
                Msg.info(Msg.SUCCESS_MESSAGE);
            }
            clearSchoolSubject();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void editSchoolSubject(SchoolSubject schoolSubject)
    {
        this.schoolSubject = schoolSubject;
        optionText = "Update";
        SystemUtils.resetJsfUI();
    }
    
    public void deleteSchoolSubject(SchoolSubject schoolSubject)
    {
        try
        {
            if (crudApi.delete(schoolSubject))
            {
                schoolSubjectList.remove(schoolSubject);
                Msg.info(Msg.DELETE_MESSAGE);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void clearTeacherSubject()
    {
        teacherSubject = new TeacherSubject();
        optionText = "Save Changes";
        SystemUtils.resetJsfUI();
    }
    
    public void clearSchoolSubject()
    {
        schoolSubject = new SchoolSubject();
        optionText = "Save Changes";
        SystemUtils.resetJsfUI();
    }
    
    public void closePage(){
        clearSchoolSubject();
        clearTeacherSubject();
        schoolSubjectList = new LinkedList<>();
        pageView.restToListView();
    }
    
    public TeacherSubject getTeacherSubject()
    {
        return teacherSubject;
    }

    public void setTeacherSubject(TeacherSubject teacherSubject)
    {
        this.teacherSubject = teacherSubject;
    }

    public List<TeacherSubject> getTeacherSubjectList()
    {
        return teacherSubjectList;
    }

    public String getOptionText()
    {
        return optionText;
    }

    public FormView getPageView()
    {
        return pageView;
    }

    public void setPageView(FormView pageView)
    {
        this.pageView = pageView;
    }

    public UserAccount getSelectTeacher() {
        return selectTeacher;
    }

    public void setSelectTeacher(UserAccount selectTeacher) {
        this.selectTeacher = selectTeacher;
    }

    public SchoolSubject getSchoolSubject()
    {
        return schoolSubject;
    }

    public void setSchoolSubject(SchoolSubject schoolSubject)
    {
        this.schoolSubject = schoolSubject;
    }

    public List<SchoolSubject> getSchoolSubjectList()
    {
        return schoolSubjectList;
    }
    
}
