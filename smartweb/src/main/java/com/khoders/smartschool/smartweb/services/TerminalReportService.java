/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.smartweb.services;

import com.khoders.resource.jpa.CrudApi;
import com.khoders.smartschool.entities.ExamsReport;
import com.khoders.smartschool.entities.TerminalReport;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

/**
 *
 * @author richa
 */
@Stateless
public class TerminalReportService
{
    @Inject private CrudApi crudApi;
    
    public List<ExamsReport> examsReportList(TerminalReport terminalReport)
    {
        try
        {
            String qryString = "SELECT e FROM ExamsReport e WHERE e.terminalReport=?1";
            TypedQuery<ExamsReport> typedQuery = crudApi.getEm().createQuery(qryString, ExamsReport.class)
                    .setParameter(1, terminalReport);
            
            return typedQuery.getResultList();
            
        } catch (Exception e)
        {
          e.printStackTrace();
        }
        return Collections.emptyList();
    }
    
    public List<TerminalReport> terminalReportList()
    {
        try
        {
            return crudApi.getEm().createQuery("SELECT e FROM TerminalReport e", TerminalReport.class).getResultList();
        } catch (Exception e)
        {
           e.printStackTrace();
        }
        return Collections.emptyList();
    }
    
    public String gradeChecker(double totalMrks)
    {
        if(totalMrks >= 80 && totalMrks <= 100)
        {
            return "A";   
        }
        else if(totalMrks >= 70 && totalMrks <= 79)
        {
            return "B";
        }
        else if(totalMrks >= 60 && totalMrks <= 69)
        {
            return "C";
        }
        else if(totalMrks >= 50 && totalMrks <= 59)
        {
            return "D";
        }
        else if(totalMrks >= 0 && totalMrks <= 39)
        {
            return "F";
        }
        else
        {
            return "UNKNOWN MARK";
        }
    }
}
