package com.khoders.smartschool.entities;

import com.khoders.smartschool.entities.setup.StaffAccount;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "teacher_subject")
public class TeacherSubject extends UserAccountRecord
{
   @JoinColumn(name = "courses", referencedColumnName = "id")
   @ManyToOne
   private Course course;
   
   @JoinColumn(name = "staff_account", referencedColumnName = "id")
   @ManyToOne
   private StaffAccount staffAccount;

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }

    public StaffAccount getStaffAccount() {
        return staffAccount;
    }

    public void setStaffAccount(StaffAccount staffAccount) {
        this.staffAccount = staffAccount;
    }
   
}
