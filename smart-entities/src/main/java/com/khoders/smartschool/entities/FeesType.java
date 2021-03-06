/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "fees_type")
public class FeesType extends UserAccountRecord implements Serializable{
    
    @Column(name = "fees_type_name")
    private String feesTypeName;

    public String getFeesTypeName()
    {
        return feesTypeName;
    }

    public void setFeesTypeName(String feesTypeName)
    {
        this.feesTypeName = feesTypeName;
    }

    @Override
    public String toString()
    {
        return feesTypeName;
    }
    
}
