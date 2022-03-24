/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.smartadmin.commons;

import com.khoders.resource.enums.AccessLevel;
import com.khoders.resource.enums.Title;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.inject.Named;

/**
 *
 * @author richa
 */
@Named(value = "commonOption")
public class CommonOption implements Serializable
{
    public List<Title> getTitleList(){
        return Arrays.asList(Title.values());
    }
    public List<AccessLevel> getAccessLevelList(){
        return Arrays.asList(AccessLevel.values());
    }
}
