package com.khoders.smartschool.entities;

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
public class UserAccountRecord extends RefNo implements Serializable
{
    @JoinColumn(name = "user_account", referencedColumnName = "id")
    @ManyToOne
    private UserAccount userAccount;
    
    @JoinColumn(name = "academic_term", referencedColumnName = "id")
    @ManyToOne
    private AcademicTerm academicTerm;
    
    public UserAccount getUserAccount()
    {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount)
    {
        this.userAccount = userAccount;
    }

    public AcademicTerm getAcademicTerm()
    {
        return academicTerm;
    }

    public void setAcademicTerm(AcademicTerm academicTerm)
    {
        this.academicTerm = academicTerm;
    }
    
}
