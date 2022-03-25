/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "school_subject")
public class SchoolSubject extends UserAccountRecord{
   @JoinColumn(name = "teacher_subject", referencedColumnName = "id")
   @ManyToOne
   private TeacherSubject teacherSubject;
   
   @JoinColumn(name = "courses", referencedColumnName = "id")
   @ManyToOne
   private Course course;

    public TeacherSubject getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(TeacherSubject teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
