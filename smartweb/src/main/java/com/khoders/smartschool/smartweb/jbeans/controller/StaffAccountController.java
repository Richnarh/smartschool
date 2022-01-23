
package com.khoders.smartschool.smartweb.jbeans.controller;

import com.khoders.resource.jpa.CrudApi;
import com.khoders.resource.utilities.FormView;
import com.khoders.smartschool.entities.setup.StaffAccount;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author richa
 */
@Named(value = "staffAccountController")
@SessionScoped
public class StaffAccountController implements Serializable{
    @Inject private CrudApi crudApi;
    private FormView pageView = FormView.listForm();
    
    private StaffAccount staffAccount = new StaffAccount();
    private List<StaffAccount> staffAccountList = new LinkedList<>();
    
    private String optionText;
    
    @PostConstruct
    private void init()
    {
        
    }
    
    public void initStaff(){
        
    }
    
    public void saveStaffAccount(){
        
    }
    
    public void editStaffAccount(StaffAccount staffAccount){
        
    }
    
    public void deleteStaffAccount(StaffAccount staffAccount){
        
    }

    public List<StaffAccount> getStaffAccountList() {
        return staffAccountList;
    }

    public FormView getPageView() {
        return pageView;
    }

    public void setPageView(FormView pageView) {
        this.pageView = pageView;
    }

    public StaffAccount getStaffAccount() {
        return staffAccount;
    }

    public void setStaffAccount(StaffAccount staffAccount) {
        this.staffAccount = staffAccount;
    }

    public String getOptionText() {
        return optionText;
    }
    
    
}
