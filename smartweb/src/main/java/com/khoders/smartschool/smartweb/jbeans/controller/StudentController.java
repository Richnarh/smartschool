/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.smartweb.jbeans.controller;

import com.khoders.resource.jpa.CrudApi;
import com.khoders.resource.utilities.CollectionList;
import com.khoders.resource.utilities.FormView;
import com.khoders.resource.utilities.Msg;
import com.khoders.resource.utilities.SystemUtils;
import com.khoders.smartschool.entities.Student;
import com.khoders.smartschool.smartweb.services.StudentService;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author richard
 */
@Named(value = "studentController")
@SessionScoped
public class StudentController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private StudentService studentService;
    
    private FormView pageView = FormView.listForm();
    private Student student = new Student();
    private List<Student> studentList = new LinkedList<>();

    private String optionText;

    @PostConstruct
    private void init()
    {
        studentList = studentService.studentList();
    }
    
    public void initStudent(){
        clearStudent();
        pageView.restToCreateView();
    }

    public void saveStudent()
    {
        try
        {
            if (crudApi.save(student) != null)
            {
                studentList = CollectionList.washList(studentList, student);
                Msg.info(Msg.SUCCESS_MESSAGE);
            }
            closePage();
        } catch (Exception e)
        {
        }
    }

    public void editStudent(Student student)
    {
        this.student = student;
        optionText = "Update";
        pageView.restToCreateView();
    }

    public void deleteStudent(Student student)
    {
        try
        {
            if (crudApi.delete(student))
            {
                studentList.remove(student);
                Msg.info(Msg.SUCCESS_MESSAGE);
            }
        } catch (Exception e)
        {
        }
    }

    public void clearStudent()
    {
        student.genRefNo();
        student = new Student();
        optionText = "Save Changes";
        SystemUtils.resetJsfUI();
    }
    
    public void closePage(){
        clearStudent();
        pageView.restToListView();
    }
 
    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    public List<Student> getStudentList()
    {
        return studentList;
    }

    public String getOptionText()
    {
        return optionText;
    }

    public FormView getPageView()
    {
        return pageView;
    }

    public void setPageView(FormView pageView)
    {
        this.pageView = pageView;
    }
    
}
