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
import com.khoders.smartschool.entities.AcademicTerm;
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
@Named(value = "academicTermController")
@SessionScoped
public class AcademicTermController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private ConfigService configService;
    
    private AcademicTerm academicTerm = new AcademicTerm();
    private List<AcademicTerm> academicTermList = new LinkedList<>();
    
    private String optionText;
    
    @PostConstruct
    private void init(){
        clearAcademicTerm();
        academicTermList = configService.getAcademicTermList();
    }
    
    public void saveAcademicTerm(){
        try
        {
            if(crudApi.save(academicTerm) != null)
            {
                academicTermList = CollectionList.washList(academicTermList, academicTerm);
                Msg.info("Fees type Saved");
            }
            clearAcademicTerm();
        } catch (Exception e)
        {
        }
    }
    
    public void editAcademicTerm(AcademicTerm academicTerm){
        this.academicTerm = academicTerm;
        optionText = "Update";
    }
    
    public void deleteAcademicTerm(AcademicTerm academicTerm){
        try
        {
            if(crudApi.delete(academicTerm)){
                academicTermList.remove(academicTerm);
                Msg.info(Msg.SUCCESS_MESSAGE);
            }
        } catch (Exception e)
        {
        }
    }

    public void clearAcademicTerm()
    {
        academicTerm = new AcademicTerm();
        optionText = "Save Changes";
        SystemUtils.resetJsfUI();
    }

    public AcademicTerm getAcademicTerm()
    {
        return academicTerm;
    }

    public void setAcademicTerm(AcademicTerm academicTerm)
    {
        this.academicTerm = academicTerm;
    }

    public List<AcademicTerm> getAcademicTermList()
    {
        return academicTermList;
    }

    public String getOptionText()
    {
        return optionText;
    }
    
}
