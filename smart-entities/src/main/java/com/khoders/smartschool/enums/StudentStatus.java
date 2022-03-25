/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.enums;

import com.khoders.resource.utilities.MsgResolver;

/**
 *
 * @author richa
 */
public enum StudentStatus implements MsgResolver
{
    FRESHER("FRESHER", "Fresher"),
    CONTINUING("CONTINUING", "Continuing"),
    ALUMNI("ALUMNI", "Alumni"),
    DROP_OUT("DROP_OUT", "Drop Out");
    
    private final String code;
    private final String label;
    
    private StudentStatus(String code, String label){
        this.code = code;
        this.label = label;
    }

    @Override
    public String getCode()
    {
      return code;  
    }

    @Override
    public String getLabel()
    {
        return label;
    }

    @Override
    public String toString()
    {
        return label;
    }
    
    
}
