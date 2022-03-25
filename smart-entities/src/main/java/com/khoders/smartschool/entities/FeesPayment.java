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
@Table(name = "fees_payment")
public class FeesPayment extends UserAccountRecord implements Serializable
{
    @JoinColumn(name = "fees", referencedColumnName = "id")
    @ManyToOne
    private Fees fees;
    
    @Column(name = "amount_paid")
    private double amountPaid;
    
    @Column(name = "amount_remaining")
    private double amountRemaining;

    public Fees getFees()
    {
        return fees;
    }

    public void setFees(Fees fees)
    {
        this.fees = fees;
    }

    public double getAmountPaid()
    {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid)
    {
        this.amountPaid = amountPaid;
    }

    public double getAmountRemaining()
    {
        return amountRemaining;
    }

    public void setAmountRemaining(double amountRemaining)
    {
        this.amountRemaining = amountRemaining;
    }
    
    
}
