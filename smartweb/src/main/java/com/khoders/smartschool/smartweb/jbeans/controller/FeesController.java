/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.smartweb.jbeans.controller;

import com.khoders.resource.jpa.CrudApi;
import com.khoders.resource.utilities.CollectionList;
import com.khoders.resource.utilities.Msg;
import com.khoders.resource.utilities.SystemUtils;
import com.khoders.smartschool.entities.Fees;
import com.khoders.smartschool.smartweb.listener.AppSession;
import com.khoders.smartschool.smartweb.services.StudentService;
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
@Named(value = "feesController")
@SessionScoped
public class FeesController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private StudentService studentService;
    @Inject private AppSession appSession;

    private Fees fees = new Fees();
    private List<Fees> feesList = new LinkedList<>();

    private String optionText;

    @PostConstruct
    private void init()
    {
        clearFees();
        feesList = studentService.feesList();
    }

    public void saveFees()
    {
        try
        {
            if (crudApi.save(fees) != null)
            {
                feesList = CollectionList.washList(feesList, fees);
                Msg.success(Msg.SUCCESS_MESSAGE);
            }
            clearFees();
        } catch (Exception e)
        {
           e.printStackTrace();
        }
    }

    public void editFees(Fees fees)
    {
        this.fees = fees;
        optionText = "Update";
    }

    public void deleteFees(Fees fees)
    {
        try
        {
            if (crudApi.delete(fees))
            {
                feesList.remove(fees);
                Msg.success(Msg.SUCCESS_MESSAGE);
            }
           
        } catch (Exception e)
        {
           e.printStackTrace();
        }
    }

    public void clearFees()
    {
        fees = new Fees();
        optionText = "Save Changes";
        fees.setUserAccount(appSession.getCurrentUser());
        SystemUtils.resetJsfUI();
    }

    public Fees getFees()
    {
        return fees;
    }

    public void setFees(Fees fees)
    {
        this.fees = fees;
    }

    public List<Fees> getFeesList()
    {
        return feesList;
    }

    public String getOptionText()
    {
        return optionText;
    }
    
}
