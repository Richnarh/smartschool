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
import com.khoders.smartschool.entities.AcademicLevel;
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
@Named(value = "academicLevelController")
@SessionScoped
public class AcademicLevelController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private ConfigService configService;
    
    private AcademicLevel academicLevel = new AcademicLevel();
    private List<AcademicLevel> academicLevelList = new LinkedList<>();
    
    private String optionText;
    
    @PostConstruct
    private void init(){
        clearAcademicLevel();
        academicLevelList = configService.getAcademicLevelList();
    }
    
    public void saveAcademicLevel(){
        try
        {
            if(crudApi.save(academicLevel) != null)
            {
                academicLevelList = CollectionList.washList(academicLevelList, academicLevel);
                Msg.success("Academic Level Saved");
            }
            clearAcademicLevel();
        } catch (Exception e)
        {
        }
    }
    
    public void editAcademicLevel(AcademicLevel academicLevel){
        this.academicLevel = academicLevel;
        optionText = "Update";
    }
    
    public void deleteAcademicLevel(AcademicLevel academicLevel){
        try
        {
            if(crudApi.delete(academicLevel)){
                academicLevelList.remove(academicLevel);
                Msg.success(Msg.SUCCESS_MESSAGE);
            }
        } catch (Exception e)
        {
        }
    }

    public void clearAcademicLevel()
    {
        academicLevel = new AcademicLevel();
        optionText = "Save Changes";
        SystemUtils.resetJsfUI();
    }

    public AcademicLevel getAcademicLevel()
    {
        return academicLevel;
    }

    public void setAcademicLevel(AcademicLevel academicLevel)
    {
        this.academicLevel = academicLevel;
    }

    public List<AcademicLevel> getAcademicLevelList()
    {
        return academicLevelList;
    }

    public String getOptionText()
    {
        return optionText;
    }
    
}
