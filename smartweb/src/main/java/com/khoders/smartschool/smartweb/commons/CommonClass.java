/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.smartweb.commons;

import com.khoders.resource.enums.Gender;
import com.khoders.smartschool.enums.StudentStatus;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author richa
 */
@Named(value = "commonClass")
@SessionScoped
public class CommonClass implements Serializable
{
    public List<Gender> genderList(){
        return Arrays.asList(Gender.values());
    }
    public List<StudentStatus> StudentStatusList(){
        return Arrays.asList(StudentStatus.values());
    }
}
