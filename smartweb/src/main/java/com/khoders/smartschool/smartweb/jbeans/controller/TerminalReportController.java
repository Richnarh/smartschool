/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.smartweb.jbeans.controller;

import com.khoders.resource.jpa.CrudApi;
import com.khoders.resource.utilities.CollectionList;
import com.khoders.resource.utilities.FormView;
import com.khoders.resource.utilities.Msg;
import com.khoders.resource.utilities.SystemUtils;
import com.khoders.smartschool.entities.ExamsReport;
import com.khoders.smartschool.entities.TerminalReport;
import com.khoders.smartschool.smartweb.listener.AppSession;
import com.khoders.smartschool.smartweb.services.TerminalReportService;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author richa
 */
@Named(value = "terminalReportController")
@SessionScoped
public class TerminalReportController implements Serializable
{
    @Inject private CrudApi crudApi;
    @Inject private AppSession appSession;
    @Inject private TerminalReportService terminalReportService;
    private TerminalReport terminalReport = new TerminalReport();
    private List<TerminalReport> terminalReportList = new LinkedList<>();
    
    private FormView pageView = FormView.listForm();
    
    private ExamsReport examsReport = new ExamsReport();
    private List<ExamsReport> examsReportList = new LinkedList<>();
    
    
    private String optionText;
    
    @PostConstruct
    private void init()
    {
       terminalReportList = terminalReportService.terminalReportList(); 
    }
    
    public void initTerminalReport()
    {
        clearTerminalReport();
        pageView.restToCreateView();
    }
    
    public void saveTerminalReport()
    {
        try
        {
            if(crudApi.save(terminalReport) != null)
            {
                terminalReportList = CollectionList.washList(terminalReportList, terminalReport);
                Msg.setMsg("Terminal report created successfully!");
            }
            closePage();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void editTerminalReport(TerminalReport terminalReport)
    {
       pageView.restToCreateView();
       this.terminalReport = terminalReport;
       optionText = "Update";
    }
    
    public void deleteTerminalReport(TerminalReport terminalReport)
    {
        try
        {
          if(crudApi.delete(terminalReport))
          {
              terminalReportList.remove(terminalReport);
              Msg.setMsg("Report deleted!");
          }
        } catch (Exception e)
        {
          e.printStackTrace();
        }
    }
    
    public void manageExamsReport(TerminalReport terminalReport)
    {
        pageView.restToDetailView();
        this.terminalReport = terminalReport;
        examsReportList = terminalReportService.examsReportList(terminalReport);
        
        clearExamsReport();
    }
    
    public void saveExamsReport()
    {
        try
        {
            0554850594
                    
            double classScore = (examsReport.getRawClassScore())*0.5;
            double examsScore = (examsReport.getRawExamsScore())*0.5;
            double totalScore = classScore + examsScore;
            
            examsReport.setClassScore(classScore);
            examsReport.setExamsScore(examsScore);
            examsReport.setTotalScore(totalScore);
            
            String grade = terminalReportService.gradeChecker(totalScore);
            examsReport.setGrade(grade);
            
            examsReport.setRawTotalScore(examsReport.getRawClassScore() + examsReport.getRawExamsScore());           
            
            if(crudApi.save(examsReport) != null)
            {
                examsReportList = CollectionList.washList(examsReportList, examsReport);
                Msg.setMsg(Msg.SUCCESS_MESSAGE);
            }
            clearExamsReport();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void editExamsReport(ExamsReport examsReport)
    {
        this.examsReport = examsReport;
        optionText = "Update";
    }
    
    public void deleteExamsReport(ExamsReport examsReport)
    {
        try
        {
            if(crudApi.delete(examsReport))
            {
                examsReportList.remove(examsReport);
                Msg.setMsg(Msg.DELETE_MESSAGE);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void clearExamsReport()
    {
        examsReport = new ExamsReport();
        examsReport.genRefNo();
        examsReport.setUserAccount(appSession.getCurrentUser());
        examsReport.setTerminalReport(terminalReport);
        optionText = "Save Changes";
        SystemUtils.resetJsfUI();
    }
    
    public void closePage()
    {
       clearExamsReport(); 
       clearTerminalReport();
       pageView.restToListView();
    }
    
    public void clearTerminalReport()
    {
        terminalReport = new TerminalReport();
        terminalReport.setUserAccount(appSession.getCurrentUser());
        terminalReport.genRefNo();
        optionText = "Save Changes";
        SystemUtils.resetJsfUI();
    }

    public List<TerminalReport> getTerminalReportList()
    {
        return terminalReportList;
    }

    public List<ExamsReport> getExamsReportList()
    {
        return examsReportList;
    }

    public String getOptionText()
    {
        return optionText;
    }

    public TerminalReport getTerminalReport()
    {
        return terminalReport;
    }

    public void setTerminalReport(TerminalReport terminalReport)
    {
        this.terminalReport = terminalReport;
    }

    public FormView getPageView()
    {
        return pageView;
    }

    public void setPageView(FormView pageView)
    {
        this.pageView = pageView;
    }

    public ExamsReport getExamsReport()
    {
        return examsReport;
    }

    public void setExamsReport(ExamsReport examsReport)
    {
        this.examsReport = examsReport;
    }
    
    
}
