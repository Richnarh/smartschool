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
import com.khoders.smartschool.entities.ExamsParameter;
import com.khoders.smartschool.entities.setup.UserAccount;
import com.khoders.smartschool.smartadmin.services.AppService;
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
@Named(value = "examsParamController")
@SessionScoped
public class ExamsParamController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private ConfigService configService;
    @Inject private AppService appService;
    
    private ExamsParameter examsParameter = new ExamsParameter();
    private List<ExamsParameter> examsParameterList = new LinkedList<>();
    
    private String optionText;
    
    @PostConstruct
    private void init(){
        clearExamsParameter();
        examsParameterList = configService.getExamsParameterList();
    }
    
    public void saveExamsParameter(){
        try
        {
            if(crudApi.save(examsParameter) != null)
            {
                examsParameterList = CollectionList.washList(examsParameterList, examsParameter);
                Msg.info("Fees type Saved");
            }
            clearExamsParameter();
        } catch (Exception e)
        {
        }
    }
    
    public void editExamsParameter(ExamsParameter examsParameter){
        this.examsParameter = examsParameter;
        optionText = "Update";
    }
    
    public void deleteExamsParameter(ExamsParameter examsParameter){
        try
        {
            if(crudApi.delete(examsParameter)){
                examsParameterList.remove(examsParameter);
                Msg.info(Msg.SUCCESS_MESSAGE);
            }
        } catch (Exception e)
        {
        }
    }
    
    public void applyExamsParams(ExamsParameter examsParameter)
    {
        List<UserAccount> staffList = appService.staffList();
        staffList.forEach(staff -> {
            staff.setExamsParameter(examsParameter);
            crudApi.save(staff);
        });
        
        Msg.info("Parameters applied successfully!");
    }

    public void clearExamsParameter()
    {
        examsParameter = new ExamsParameter();
        optionText = "Save Changes";
        SystemUtils.resetJsfUI();
    }

    public ExamsParameter getExamsParameter()
    {
        return examsParameter;
    }

    public void setExamsParameter(ExamsParameter examsParameter)
    {
        this.examsParameter = examsParameter;
    }

    public List<ExamsParameter> getExamsParameterList()
    {
        return examsParameterList;
    }

    public String getOptionText()
    {
        return optionText;
    }
    
}
