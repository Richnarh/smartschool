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
@Table(name = "exams_report")
public class ExamsReport extends UserAccountRecord implements Serializable
{
    @JoinColumn(name = "terminal_report", referencedColumnName = "id")
    @ManyToOne
    private TerminalReport terminalReport;
    
    @JoinColumn(name = "subject", referencedColumnName = "id")
    @ManyToOne
    private Course subject;
    
    @Column(name = "class_score")
    private double classScore;
    
    @Column(name = "exams_score")
    private double examsScore;
    
    @Column(name = "total_score")
    private double totalScore;
    
    @Column(name = "raw_class_score")
    private double rawClassScore;
    
    @Column(name = "raw_exams_score")
    private double rawExamsScore;
    
    @Column(name = "raw_total_score")
    private double rawTotalScore;
    
    @Column(name = "grade")
    private String grade;
    
    @Column(name = "position_in_subject")
    private String positionInSubject;
    
    @Column(name = "remarks")
    private String remarks;

    public TerminalReport getTerminalReport() {
        return terminalReport;
    }

    public void setTerminalReport(TerminalReport terminalReport) {
        this.terminalReport = terminalReport;
    }

    public Course getSubject() {
        return subject;
    }

    public void setSubject(Course subject) {
        this.subject = subject;
    }

    public double getClassScore() {
        return classScore;
    }

    public void setClassScore(double classScore) {
        this.classScore = classScore;
    }

    public double getExamsScore() {
        return examsScore;
    }

    public void setExamsScore(double examsScore) {
        this.examsScore = examsScore;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPositionInSubject() {
        return positionInSubject;
    }

    public void setPositionInSubject(String positionInSubject) {
        this.positionInSubject = positionInSubject;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public double getRawClassScore()
    {
        return rawClassScore;
    }

    public void setRawClassScore(double rawClassScore)
    {
        this.rawClassScore = rawClassScore;
    }

    public double getRawExamsScore()
    {
        return rawExamsScore;
    }

    public void setRawExamsScore(double rawExamsScore)
    {
        this.rawExamsScore = rawExamsScore;
    }

    public double getRawTotalScore()
    {
        return rawTotalScore;
    }

    public void setRawTotalScore(double rawTotalScore)
    {
        this.rawTotalScore = rawTotalScore;
    }
        
}
