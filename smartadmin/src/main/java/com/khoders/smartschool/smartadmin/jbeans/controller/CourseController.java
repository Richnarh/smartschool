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
import com.khoders.smartschool.entities.Course;
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
@Named(value = "courseController")
@SessionScoped
public class CourseController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private ConfigService configService;

    private Course course = new Course();
    private List<Course> courseList = new LinkedList<>();

    private String optionText;

    @PostConstruct
    private void init()
    {
        clearCourse();
        courseList = configService.courseList();
    }

    public void saveCourse()
    {
        try
        {
            course.genRefNo();
            if (crudApi.save(course) != null)
            {
                courseList = CollectionList.washList(courseList, course);
                Msg.info(Msg.SUCCESS_MESSAGE);
            }
            clearCourse();
        } catch (Exception e)
        {
           e.printStackTrace();
        }
    }

    public void editCourse(Course course)
    {
        this.course = course;
        optionText = "Update";
    }

    public void deleteCourse(Course course)
    {
        try
        {
            if (crudApi.delete(course))
            {
                courseList.remove(course);
                Msg.info(Msg.SUCCESS_MESSAGE);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void clearCourse()
    {
        course = new Course();
        optionText = "Save Changes";
        SystemUtils.resetJsfUI();
    }

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }

    public List<Course> getCourseList()
    {
        return courseList;
    }

    public String getOptionText()
    {
        return optionText;
    }
    
}
