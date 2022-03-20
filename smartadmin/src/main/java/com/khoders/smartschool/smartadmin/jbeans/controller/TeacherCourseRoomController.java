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
    private UserAccount selectedUserAccount = null;

    private String optionText;

    @PostConstruct
    private void init()
    {
        clearTeacherSubject();
        teacherSubjectList = appService.teacherSubjectList();
    }
    
    public void selectedAccount(){
        selectedUserAccount = teacherSubject.getUserAccount();
        System.out.println("selected -- ");
    }
    
    public void saveTeacherSubject()
    {
        try
        {
            if (crudApi.save(teacherSubject) != null)
            {
                teacherSubjectList = CollectionList.washList(teacherSubjectList, teacherSubject);
                Msg.success(Msg.SUCCESS_MESSAGE);
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
                Msg.success(Msg.SUCCESS_MESSAGE);
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

    public UserAccount getSelectedUserAccount()
    {
        return selectedUserAccount;
    }

    public void setSelectedUserAccount(UserAccount selectedUserAccount)
    {
        this.selectedUserAccount = selectedUserAccount;
    }
    
}
