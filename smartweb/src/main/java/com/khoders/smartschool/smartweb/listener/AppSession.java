package com.khoders.smartschool.smartweb.listener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.khoders.smartschool.entities.AcademicTerm;
import com.khoders.smartschool.entities.setup.UserAccount;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author khoders
 */
@Named(value = "appSession")
@SessionScoped
public class AppSession implements Serializable{
    private UserAccount currentUser;
    private AcademicTerm currentTerm;
    
    public void login(UserAccount userAccount)
    {
        this.currentUser = userAccount;
    }
    public void initAcademicTerm(AcademicTerm currentTerm)
    {
        this.currentTerm=currentTerm;
    }
    
    public void logout()
    {
        this.currentUser = null;
    }

    public UserAccount getCurrentUser()
    {
        return currentUser;
    }

    public void setCurrentUser(UserAccount currentUser)
    {
        this.currentUser = currentUser;
    }

    public AcademicTerm getCurrentTerm()
    {
        return currentTerm;
    }

    public void setCurrentTerm(AcademicTerm currentTerm)
    {
        this.currentTerm = currentTerm;
    }
    
}
