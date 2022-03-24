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
import com.khoders.smartschool.entities.StudentClass;
import com.khoders.smartschool.entities.StudentClassRoom;
import com.khoders.smartschool.smartweb.listener.AppSession;
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
    @Inject private AppSession appSession;
    
    private FormView pageView = FormView.listForm();
    private StudentClassRoom studentClassRoom = new StudentClassRoom();
    private List<StudentClassRoom> studentClassRoomList = new LinkedList<>();
    private ClassRoom selectedClassRoom = null;
    
    private StudentClass studentClass = new StudentClass();
    private List<StudentClass> studentClassList = new LinkedList<>();

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
                Msg.info(Msg.SUCCESS_MESSAGE);
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
        selectedClassRoom = studentClassRoom.getClassRoom();
        optionText = "Update";
    }

    public void deleteStudentClassRoom(StudentClassRoom studentClassRoom)
    {
        try
        {
            if (crudApi.delete(studentClassRoom))
            {
                studentClassRoomList.remove(studentClassRoom);
                Msg.info(Msg.SUCCESS_MESSAGE);
            }
        } catch (Exception e)
        {
           e.printStackTrace();
        }
    }
    
    public void manageStudentClass(StudentClassRoom studentClassRoom)
    {
       studentClassList = studentService.studentClassList(studentClassRoom);
    }
    
    public void saveStudentClass()
    {
        try
        {
            if(crudApi.save(studentClass) != null)
            {
                studentClassList = CollectionList.washList(studentClassList, studentClass);
                Msg.info(Msg.SUCCESS_MESSAGE);
            }
            clearStudentClass();
        } catch (Exception e)
        {
           e.printStackTrace();
        }
    }
    
    public void editStudentClass(StudentClass studentClass)
    {
        this.studentClass = studentClass; 
    }
    
    public void deleteStudentClass(StudentClass studentClass)
    {
        try
        {
           if(crudApi.save(studentClass))
           {
              studentClassList.remove(studentClass);
              Msg.info(Msg.DELETE_MESSAGE);
           }
        } catch (Exception e)
        {
          e.printStackTrace();
        }
    }
    
    public void clearStudentClass()
    {
      studentClass = new StudentClass();
      optionText = "Update";
      SystemUtils.resetJsfUI();
    }

    public void clearStudentClassRoom()
    {
        studentClassRoom = new StudentClassRoom();
        studentClassRoom.setUserAccount(appSession.getCurrentUser());
        optionText = "Save Changes";
        SystemUtils.resetJsfUI();
    }
    
    public void closePage()
    {
       clearStudentClass(); 
       clearStudentClassRoom();
       
       pageView.restToListView();
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

    public StudentClass getStudentClass()
    {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass)
    {
        this.studentClass = studentClass;
    }

    public List<StudentClass> getStudentClassList()
    {
        return studentClassList;
    }
    
}
