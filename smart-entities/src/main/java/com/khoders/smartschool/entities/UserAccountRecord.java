package com.khoders.smartschool.entities;

import com.khoders.smartschool.entities.setup.StaffAccount;
import com.khoders.smartschool.entities.setup.UserAccount;
import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author richa
 */
@MappedSuperclass
public class UserAccountRecord extends ReferenceNo implements Serializable
{
   @JoinColumn(name = "user_account", referencedColumnName = "id")
    @ManyToOne
    private UserAccount userAccount;
    
    @JoinColumn(name = "staff_account", referencedColumnName = "id")
    @ManyToOne
    private StaffAccount staffAccount;  

    public UserAccount getUserAccount()
    {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount)
    {
        this.userAccount = userAccount;
    }

    public StaffAccount getStaffAccount()
    {
        return staffAccount;
    }

    public void setStaffAccount(StaffAccount staffAccount)
    {
        this.staffAccount = staffAccount;
    }
    
    
}
