/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "student_class")
public class StudentClass extends UserAccountRecord implements Serializable
{
    @JoinColumn(name = "student")
    @ManyToOne
    private Student student;
    
    @JoinColumn(name = "student_class_room")
    @ManyToOne
    private StudentClassRoom studentClassRoom;

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    public StudentClassRoom getStudentClassRoom()
    {
        return studentClassRoom;
    }

    public void setStudentClassRoom(StudentClassRoom studentClassRoom)
    {
        this.studentClassRoom = studentClassRoom;
    }
    
    
}
