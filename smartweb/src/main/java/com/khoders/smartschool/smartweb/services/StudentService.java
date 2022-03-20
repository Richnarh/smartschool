/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.smartweb.services;

import com.khoders.resource.jpa.CrudApi;
import com.khoders.smartschool.entities.Fees;
import com.khoders.smartschool.entities.FeesPayment;
import com.khoders.smartschool.entities.Student;
import com.khoders.smartschool.entities.StudentClassRoom;
import com.khoders.smartschool.smartweb.listener.AppSession;
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
public class StudentService
{
    @Inject private CrudApi crudApi;
    @Inject private AppSession appSession;
    
    public List<Student> studentList(){
        return crudApi.getEm().createQuery("SELECT e FROM Student e ORDER BY e.createdDate ASC", Student.class).getResultList(); 
    }
    
    public List<StudentClassRoom> studentClassRoomList(){
        return crudApi.getEm().createQuery("SELECT e FROM StudentClassRoom e WHERE e.userAccount=?1 ORDER BY e.createdDate ASC", StudentClassRoom.class).setParameter(1, appSession.getCurrentUser()).getResultList(); 
    }
    
    public List<Fees> feesList(){
        return crudApi.getEm().createQuery("SELECT e FROM Fees e ORDER BY e.createdDate ASC", Fees.class).getResultList(); 
    }
    
    public List<FeesPayment> getFeesPayments(Fees fees)
    {
        try
        {
           TypedQuery<FeesPayment> typedQuery = crudApi.getEm().createQuery("SELECT e FROM FeesPayment e WHERE e.fees=?1", FeesPayment.class);
                            typedQuery.setParameter(1, fees);
                            
                            return  typedQuery.getResultList();
           
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
