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
import com.khoders.smartschool.entities.FeesType;
import com.khoders.smartschool.smartadmin.services.ConfigService;
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
@Named(value = "feesTypeController")
@SessionScoped
public class FeesTypeController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private ConfigService configService;
    
    private FeesType feesType = new FeesType();
    private List<FeesType> feesTypeList = new LinkedList<>();
    
    private String optionText;
    
    @PostConstruct
    private void init(){
        clearFeesType();
        feesTypeList = configService.getFeesTypeList();
    }
    
    public void saveFeesType(){
        try
        {
            if(crudApi.save(feesType) != null)
            {
                feesTypeList = CollectionList.washList(feesTypeList, feesType);
                Msg.success("Fees type Saved");
            }
            clearFeesType();
        } catch (Exception e)
        {
        }
    }
    
    public void editFeesType(FeesType feesType){
        this.feesType = feesType;
        optionText = "Update";
    }
    
    public void deleteFeesType(FeesType feesType){
        try
        {
            if(crudApi.delete(feesType)){
                feesTypeList.remove(feesType);
                Msg.success(Msg.SUCCESS_MESSAGE);
            }
        } catch (Exception e)
        {
        }
    }

    public void clearFeesType()
    {
        feesType = new FeesType();
        optionText = "Save Changes";
        SystemUtils.resetJsfUI();
    }

    public FeesType getFeesType()
    {
        return feesType;
    }

    public void setFeesType(FeesType feesType)
    {
        this.feesType = feesType;
    }

    public List<FeesType> getFeesTypeList()
    {
        return feesTypeList;
    }

    public String getOptionText()
    {
        return optionText;
    }
    
}
