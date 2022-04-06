package com.khoders.smartschool.entities.setup;


import com.khoders.resource.enums.AccessLevel;
import com.khoders.resource.enums.Status;
import com.khoders.resource.enums.Title;
import com.khoders.smartschool.entities.AcademicTerm;
import com.khoders.smartschool.entities.ExamsParameter;
import com.khoders.smartschool.entities.RefNo;
import com.khoders.smartschool.entities.School;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author richa
 */
@Entity
@Table(name = "user_account")
public class UserAccount extends RefNo
{
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @JoinColumn(name = "exams_parameters", referencedColumnName = "id")
    @ManyToOne
    private ExamsParameter examsParameter;
    
    @JoinColumn(name = "academic_term", referencedColumnName = "id")
    @ManyToOne
    private AcademicTerm academicTerm;
    
    @JoinColumn(name = "school", referencedColumnName = "id")
    @ManyToOne
    private School school;
    
    @Column(name = "staff_no")
    private String staffNo;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "title")
    @Enumerated(EnumType.STRING)
    private Title title;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "other_name")
    private String otherName;

    @Column(name = "emergency_contact")
    private String emergencyContact;

    @Column(name = "house_address")
    private String houseAddress;
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;
    
    @Column(name = "access_level")
    @Enumerated(EnumType.STRING)
    private AccessLevel accessLevel;
    
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public Title getTitle()
    {
        return title;
    }

    public void setTitle(Title title)
    {
        this.title = title;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public String getOtherName()
    {
        return otherName;
    }

    public void setOtherName(String otherName)
    {
        this.otherName = otherName;
    }

    public String getEmergencyContact()
    {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact)
    {
        this.emergencyContact = emergencyContact;
    }

    public String getHouseAddress()
    {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress)
    {
        this.houseAddress = houseAddress;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public AccessLevel getAccessLevel()
    {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel)
    {
        this.accessLevel = accessLevel;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getStaffNo()
    {
        return staffNo;
    }

    public void setStaffNo(String staffNo)
    {
        this.staffNo = staffNo;
    }

    public ExamsParameter getExamsParameter()
    {
        return examsParameter;
    }

    public void setExamsParameter(ExamsParameter examsParameter)
    {
        this.examsParameter = examsParameter;
    }

    public AcademicTerm getAcademicTerm()
    {
        return academicTerm;
    }

    public void setAcademicTerm(AcademicTerm academicTerm)
    {
        this.academicTerm = academicTerm;
    }

    public School getSchool()
    {
        return school;
    }

    public void setSchool(School school)
    {
        this.school = school;
    }

    @Override
    public String toString()
    {
        return username +" "+staffNo;
    }
}
