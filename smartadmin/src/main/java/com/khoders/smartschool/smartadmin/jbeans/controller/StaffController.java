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
 * @author richa
 */
@Named(value = "staffController")
@SessionScoped
public class StaffController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private AppService appService;
    
    private UserAccount staff = new UserAccount();
    private FormView pageView = FormView.listForm();
    private List<UserAccount> staffList = new LinkedList<>();
    
    private String optionText;
    
    @PostConstruct
    private void init()
    {
        clearStaff();
        staffList = appService.staffList();
    }
    
    public void initStaff()
    {
       pageView.restToCreateView();
       clearStaff();
    }
    
    public void saveStaff(){
        try
        {
            if(crudApi.save(staff) != null)
            {
               staffList = CollectionList.washList(staffList, staff);
               Msg.setMsg("Staff created successfully!");
            }
            closePage();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void editStaff(UserAccount staff)
    {
        this.staff = staff;
        pageView.restToCreateView();
        optionText = "Update";
    }
    
    public void deleteStaff(UserAccount staff)
    {
        try
        {
            if(crudApi.delete(staff)){
                staffList.remove(staff);
                Msg.setMsg("Staff deleted successfully!");
            }
        } catch (Exception e)
        {
           e.printStackTrace();
        }
    }

    public void clearStaff()
    {
       staff = new UserAccount();
       optionText = "Save Changes";
        SystemUtils.resetJsfUI();
    }
    
    public void closePage(){
        clearStaff();
        pageView.restToListView();
    }

    public List<UserAccount> getStaffList()
    {
        return staffList;
    }

    public String getOptionText()
    {
        return optionText;
    }

    public UserAccount getStaff()
    {
        return staff;
    }

    public void setStaff(UserAccount staff)
    {
        this.staff = staff;
    }

    public FormView getPageView()
    {
        return pageView;
    }

    public void setPageView(FormView pageView)
    {
        this.pageView = pageView;
    }
    
}
