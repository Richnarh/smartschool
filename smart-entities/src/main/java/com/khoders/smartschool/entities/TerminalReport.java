/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "terminal_report")
public class TerminalReport extends UserAccountRecord implements Serializable{
    @Column(name = "term")
    private String term;
    
    @Column(name = "term_date")
    private LocalDate termDate;
    
    @Column(name = "num_on_roll")
    private int numOnRoll;
    
    @Column(name = "position")
    private String position;
    
    @JoinColumn(name = "acadamic_level", referencedColumnName = "id")
    @ManyToOne
    private AcademicLevel academicLevel;
    
    @Column(name = "possible_attendance")
    private int possibleAttendance;
    
    @Column(name = "attendace_gained")
    private int attendaceGained;
    
    @JoinColumn(name = "promoted_to", referencedColumnName = "id")
    @ManyToOne
    private AcademicLevel promotedTo;
    
    @JoinColumn(name = "to_repeat", referencedColumnName = "id")
    @ManyToOne
    private AcademicLevel toRepeat; 
    
    @Column(name = "reopening")
    private String reopening;
    
    @Column(name = "conduct")
    @Lob
    private String conduct; 
    
    @Column(name = "attitude")
    private String attitude; 
    
    @Column(name = "interest")
    private String interest; 
    
    @Column(name = "class_master_remarks")
    @Lob
    private String classMasterRemarks; 
    
    @Column(name = "head_teacher_remarks")
    @Lob
    private String headTeacherRemarks; 

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public LocalDate getTermDate() {
        return termDate;
    }

    public void setTermDate(LocalDate termDate) {
        this.termDate = termDate;
    }

    public int getNumOnRoll() {
        return numOnRoll;
    }

    public void setNumOnRoll(int numOnRoll) {
        this.numOnRoll = numOnRoll;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public AcademicLevel getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(AcademicLevel academicLevel) {
        this.academicLevel = academicLevel;
    }

    public int getPossibleAttendance() {
        return possibleAttendance;
    }

    public void setPossibleAttendance(int possibleAttendance) {
        this.possibleAttendance = possibleAttendance;
    }

    public int getAttendaceGained() {
        return attendaceGained;
    }

    public void setAttendaceGained(int attendaceGained) {
        this.attendaceGained = attendaceGained;
    }

    public AcademicLevel getPromotedTo() {
        return promotedTo;
    }

    public void setPromotedTo(AcademicLevel promotedTo) {
        this.promotedTo = promotedTo;
    }

    public AcademicLevel getToRepeat() {
        return toRepeat;
    }

    public void setToRepeat(AcademicLevel toRepeat) {
        this.toRepeat = toRepeat;
    }

    public String getReopening() {
        return reopening;
    }

    public void setReopening(String reopening) {
        this.reopening = reopening;
    }

    public String getConduct() {
        return conduct;
    }

    public void setConduct(String conduct) {
        this.conduct = conduct;
    }

    public String getAttitude() {
        return attitude;
    }

    public void setAttitude(String attitude) {
        this.attitude = attitude;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getClassMasterRemarks() {
        return classMasterRemarks;
    }

    public void setClassMasterRemarks(String classMasterRemarks) {
        this.classMasterRemarks = classMasterRemarks;
    }

    public String getHeadTeacherRemarks() {
        return headTeacherRemarks;
    }

    public void setHeadTeacherRemarks(String headTeacherRemarks) {
        this.headTeacherRemarks = headTeacherRemarks;
    }
    
}
  