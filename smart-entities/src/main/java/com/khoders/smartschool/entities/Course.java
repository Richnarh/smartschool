package com.khoders.smartschool.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "courses")
public class Course extends UserAccountRecord
{
   @Column(name = "course_code")
   private String courseCode;
   
   @Column(name = "course_title")
   private String courseTitle;
   
   @JoinColumn(name = "acadamic_level", referencedColumnName = "id")
   @ManyToOne
   private AcademicLevel academicLevel;

    public String getCourseCode()
    {
        return courseCode;
    }

    public void setCourseCode(String courseCode)
    {
        this.courseCode = courseCode;
    }

    public String getCourseTitle()
    {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle)
    {
        this.courseTitle = courseTitle;
    }

    public AcademicLevel getAcademicLevel()
    {
        return academicLevel;
    }

    public void setAcademicLevel(AcademicLevel academicLevel)
    {
        this.academicLevel = academicLevel;
    }
   
   
}
