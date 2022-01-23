
package com.khoders.smartschool.entities;

import com.khoders.resource.enums.Gender;
import java.time.LocalDate;
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
@Table(name = "student")
public class Student extends UserAccountRecord
{
   @Column(name = "admitted_date")
   private LocalDate admittedDate = LocalDate.now();
   
   @Column(name = "first_name")
   private String firstName;
   
   @Column(name = "middle_name")
   private String middleName;
   
   @Column(name = "other_name")
   private String otherName;
   
   @Column(name = "gender")
   @Enumerated(EnumType.STRING)
   private Gender gender;
   
   @JoinColumn(name = "acadamic_level", referencedColumnName = "id")
   @ManyToOne
   private AcademicLevel academicLevel;
   
   @Column(name = "emergency_contact")
   private String emergencyContact;
   
   @Column(name = "guardian_name")
   private String guardianName;
   
   @Column(name = "guardian_contact")
   private String guardianContact;

   @Column(name = "house_address")
   private String houseAddress;

   @Column(name = "full_name")
   private String fullName = firstName +" "+middleName +" "+otherName;

    public LocalDate getAdmittedDate()
    {
        return admittedDate;
    }

    public void setAdmittedDate(LocalDate admittedDate)
    {
        this.admittedDate = admittedDate;
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

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public AcademicLevel getAcademicLevel()
    {
        return academicLevel;
    }

    public void setAcademicLevel(AcademicLevel academicLevel)
    {
        this.academicLevel = academicLevel;
    }
    
    public String getEmergencyContact()
    {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact)
    {
        this.emergencyContact = emergencyContact;
    }

    public String getGuardianName()
    {
        return guardianName;
    }

    public void setGuardianName(String guardianName)
    {
        this.guardianName = guardianName;
    }

    public String getHouseAddress()
    {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress)
    {
        this.houseAddress = houseAddress;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    { 
        this.fullName = fullName;
    }

    public String getGuardianContact()
    {
        return guardianContact;
    }

    public void setGuardianContact(String guardianContact)
    {
        this.guardianContact = guardianContact;
    }

}
