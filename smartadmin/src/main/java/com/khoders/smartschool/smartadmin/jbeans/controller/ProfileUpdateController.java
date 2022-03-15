/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.smartadmin.jbeans.controller;

import com.khoders.digital.listener.AppSession;
import com.khoders.resource.jpa.CrudApi;
import com.khoders.resource.utilities.Msg;
import com.khoders.resource.utilities.SecurityUtil;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author khoders
 */
@Named(value = "profileUpdateController")
@SessionScoped
public class ProfileUpdateController implements Serializable{
    @Inject private CrudApi crudApi;
    @Inject private AppSession appSession;
    
    private String password;
    private String confirmPassword;
    
    public void updateAccount()
    {
        try 
        {
            if(appSession.getCurrentUser() != null)
            {
                crudApi.save(appSession.getCurrentUser());
                Msg.success(Msg.SUCCESS_MESSAGE);
            }
            else
            {
              Msg.success(Msg.DELETE_MESSAGE);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    
       
    public void updatePassword()
    {
        if(!password.equals(confirmPassword))
        {
            Msg.error(Msg.setMsg("Password do not match"));
            return;
        }
        
        String hashedPassword = SecurityUtil.hashText(password);
        
        if(hashedPassword.equalsIgnoreCase(appSession.getCurrentUser().getPassword()))
        {
            String msg = "This password is same as the old one, please use a new password";
            Msg.error(msg);
            return;
        }
        
        
        appSession.getCurrentUser().setPassword(hashedPassword);
        
        if(crudApi.save(appSession.getCurrentUser()) != null)
        {
           Msg.success(Msg.setMsg("Password Reset successful!"));
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    
}
