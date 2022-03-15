package com.khoders.smartschool.entities;

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

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }
    
}
