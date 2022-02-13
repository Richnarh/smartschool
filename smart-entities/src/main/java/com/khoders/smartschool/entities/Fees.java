/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "fees")
public class Fees extends UserAccountRecord implements Serializable
{
    @JoinColumn(name = "fees_type", referencedColumnName = "id")
    @ManyToOne
    private FeesType feesType;
    
    @JoinColumn(name = "student", referencedColumnName = "id")
    @ManyToOne
    private Student student;

    @Column(name = "fees_amount")
    private double feesAmount;
    
    @Column(name = "amount_remaining")
    private double amountRemaining;

    public FeesType getFeesType() {
        return feesType;
    }

    public void setFeesType(FeesType feesType) {
        this.feesType = feesType;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getFeesAmount() {
        return feesAmount;
    }

    public void setFeesAmount(double feesAmount) {
        this.feesAmount = feesAmount;
    }

    public double getAmountRemaining() {
        return amountRemaining;
    }

    public void setAmountRemaining(double amountRemaining) {
        this.amountRemaining = amountRemaining;
    }
    
}
