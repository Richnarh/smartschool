/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.smartweb.jbeans.controller;

import com.khoders.resource.jpa.CrudApi;
import com.khoders.resource.utilities.CollectionList;
import com.khoders.resource.utilities.FormView;
import com.khoders.resource.utilities.Msg;
import com.khoders.resource.utilities.SystemUtils;
import com.khoders.smartschool.entities.Fees;
import com.khoders.smartschool.entities.FeesPayment;
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
    
    private FormView pageView = FormView.listForm();

    private Fees fees = new Fees();
    private FeesPayment feesPayment = new FeesPayment();
    private List<Fees> feesList = new LinkedList<>();
    private List<FeesPayment> feesPaymentList = new LinkedList<>();

    private String optionText;
    private double feesRemaining=0.0;

    @PostConstruct
    private void init()
    {
        clearFees();
        feesList = studentService.feesList();
        
        System.out.println("feesList => "+feesList.size());
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
    
    public void manageFees(Fees fees){
        this.fees = fees;
        pageView.restToCreateView();
        feesPaymentList = studentService.getFeesPayments(fees);
        
        double paid = 0.0;
        
        for (FeesPayment items : feesPaymentList) 
        {
            paid += items.getAmountPaid();
        }
        
        if(paid == 0.0)
        {
           feesRemaining = 0.0; 
        }
        else
        {
          feesRemaining = fees.getFeesAmount() - paid;  
        }
        
    }
    
    public void editFeesPayment(FeesPayment feesPayment){
        this.feesPayment = feesPayment;
    }
    
    public void savePayment(){
        try
        {
            if(feesPayment.getAmountRemaining() == 0.0)
            {
                System.out.println("here 1");
                feesPayment.setAmountRemaining(this.fees.getFeesAmount() - feesPayment.getAmountPaid());
            }
            else
            {
                System.out.println("here 2");
              feesPayment.setAmountRemaining(feesPayment.getAmountRemaining() - feesPayment.getAmountPaid());
            }
            feesPayment.setFees(this.fees); 
            if (crudApi.save(feesPayment) != null)
            {
                System.out.println("feesPayment -> " + feesPayment.getAmountPaid());
                feesPaymentList = CollectionList.washList(feesPaymentList, feesPayment);
                Msg.setMsg("Payment added!");
            }
            clearFeesPayment();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void deleteFeesPayment(FeesPayment feesPayment){
        try
        {
            if(crudApi.delete(feesPayment))
            {
                feesPaymentList.remove(feesPayment);
                Msg.setMsg("Fees payment deleted!");
            }
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
    public void clearFeesPayment()
    {
        feesPayment = new FeesPayment();
        feesPayment.setUserAccount(appSession.getCurrentUser());
        SystemUtils.resetJsfUI();
    }
    
    public void closePage(){
        clearFeesPayment();
        pageView.restToListView();
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

    public List<FeesPayment> getFeesPaymentList()
    {
        return feesPaymentList;
    }

    public FeesPayment getFeesPayment()
    {
        return feesPayment;
    }

    public void setFeesPayment(FeesPayment feesPayment)
    {
        this.feesPayment = feesPayment;
    }

    public FormView getPageView()
    {
        return pageView;
    }

    public void setPageView(FormView pageView)
    {
        this.pageView = pageView;
    }

    public double getFeesRemaining()
    {
        return feesRemaining;
    }

}
