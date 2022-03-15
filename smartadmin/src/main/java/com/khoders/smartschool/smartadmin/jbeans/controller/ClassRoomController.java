/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.smartadmin.jbeans.controller;

import com.khoders.resource.jpa.CrudApi;
import com.khoders.resource.utilities.CollectionList;
import com.khoders.resource.utilities.Msg;
import com.khoders.resource.utilities.SystemUtils;
import com.khoders.smartschool.entities.ClassRoom;
import com.khoders.smartschool.smartadmin.services.ConfigService;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author richa
 */
@Named(value = "classRoomController")
@SessionScoped
public class ClassRoomController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private ConfigService configService;

    private ClassRoom classRoom = new ClassRoom();
    private List<ClassRoom> classRoomList = new LinkedList<>();

    private String optionText;

    @PostConstruct
    private void init()
    {
        clearClassRoom();
        classRoomList = configService.getClassRoomList();
    }

    public void saveClassRoom()
    {
        try
        {
            if (crudApi.save(classRoom) != null)
            {
                classRoomList = CollectionList.washList(classRoomList, classRoom);
                Msg.success(Msg.SUCCESS_MESSAGE);
            }
            clearClassRoom();
        } catch (Exception e)
        {
        }
    }

    public void editClassRoom(ClassRoom classRoom)
    {
        this.classRoom = classRoom;
        optionText = "Update";
    }

    public void deleteClassRoom(ClassRoom classRoom)
    {
        try
        {
            if (crudApi.delete(classRoom))
            {
                classRoomList.remove(classRoom);
                Msg.success(Msg.SUCCESS_MESSAGE);
            }
        } catch (Exception e)
        {
        }
    }

    public void clearClassRoom()
    {
        classRoom = new ClassRoom();
        optionText = "Save Changes";
        SystemUtils.resetJsfUI();
    }

    public ClassRoom getClassRoom()
    {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom)
    {
        this.classRoom = classRoom;
    }

    public List<ClassRoom> getClassRoomList()
    {
        return classRoomList;
    }

    public String getOptionText()
    {
        return optionText;
    }
    
}
