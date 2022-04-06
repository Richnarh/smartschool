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
@Table(name = "exams_parameters")
public class ExamsParameter extends UserAccountRecord implements Serializable
{
    @Column(name = "overall_class_mrk")
    private double overAllClassMrk;
    
    @Column(name = "overall_class_mrk_percentage")
    private double overallClassMrkPercentage;
    
    @Column(name = "overall_exams_mrk")
    private double overallExamsMrk;
    
    @Column(name = "exams_mrk_percentage")
    private double overallExamsMrkPercentage;

    public double getOverAllClassMrk()
    {
        return overAllClassMrk;
    }

    public void setOverAllClassMrk(double overAllClassMrk)
    {
        this.overAllClassMrk = overAllClassMrk;
    }

    public double getOverallExamsMrk()
    {
        return overallExamsMrk;
    }

    public void setOverallExamsMrk(double overallExamsMrk)
    {
        this.overallExamsMrk = overallExamsMrk;
    }

    public double getOverallClassMrkPercentage()
    {
        return overallClassMrkPercentage;
    }

    public void setOverallClassMrkPercentage(double overallClassMrkPercentage)
    {
        this.overallClassMrkPercentage = overallClassMrkPercentage;
    }

    public double getOverallExamsMrkPercentage()
    {
        return overallExamsMrkPercentage;
    }

    public void setOverallExamsMrkPercentage(double overallExamsMrkPercentage)
    {
        this.overallExamsMrkPercentage = overallExamsMrkPercentage;
    }
    
}
