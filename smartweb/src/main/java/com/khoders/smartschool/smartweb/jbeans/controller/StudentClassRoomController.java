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
import com.khoders.smartschool.entities.ClassRoom;
import com.khoders.smartschool.entities.StudentClassRoom;
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
@Named(value = "studentClassRoomController")
@SessionScoped
public class StudentClassRoomController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private StudentService studentService;
    
    private FormView pageView = FormView.listForm();
    private StudentClassRoom studentClassRoom = new StudentClassRoom();
    private List<StudentClassRoom> studentClassRoomList = new LinkedList<>();
    private ClassRoom selectedClassRoom = null;

    private String optionText;

    @PostConstruct
    private void init()
    {
        clearStudentClassRoom();
        studentClassRoomList = studentService.studentClassRoomList();
    }
    
    public void selectedClass(){
        selectedClassRoom = studentClassRoom.getClassRoom();
        System.out.println("selected -- ");
    }
    
    public void saveStudentClassRoom()
    {
        try
        {
            if (crudApi.save(studentClassRoom) != null)
            {
                studentClassRoomList = CollectionList.washList(studentClassRoomList, studentClassRoom);
                Msg.success(Msg.SUCCESS_MESSAGE);
            }
            clearStudentClassRoom();
        } catch (Exception e)
        {
          e.printStackTrace();
        }
    }

    public void editStudentClassRoom(StudentClassRoom studentClassRoom)
    {
        this.studentClassRoom = studentClassRoom;
        optionText = "Update";
    }

    public void deleteStudentClassRoom(StudentClassRoom studentClassRoom)
    {
        try
        {
            if (crudApi.delete(studentClassRoom))
            {
                studentClassRoomList.remove(studentClassRoom);
                Msg.success(Msg.SUCCESS_MESSAGE);
            }
        } catch (Exception e)
        {
           e.printStackTrace();
        }
    }

    public void clearStudentClassRoom()
    {
        studentClassRoom = new StudentClassRoom();
        selectedClassRoom = null;
        optionText = "Save Changes";
        SystemUtils.resetJsfUI();
    }
    
    public StudentClassRoom getStudentClassRoom()
    {
        return studentClassRoom;
    }

    public void setStudentClassRoom(StudentClassRoom studentClassRoom)
    {
        this.studentClassRoom = studentClassRoom;
    }

    public List<StudentClassRoom> getStudentClassRoomList()
    {
        return studentClassRoomList;
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

    public ClassRoom getSelectedClassRoom()
    {
        return selectedClassRoom;
    }

    public void setSelectedClassRoom(ClassRoom selectedClassRoom)
    {
        this.selectedClassRoom = selectedClassRoom;
    }
    
}
