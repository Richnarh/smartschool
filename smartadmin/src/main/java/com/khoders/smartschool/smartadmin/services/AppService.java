/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.smartschool.smartadmin.services;

import com.khoders.resource.jpa.CrudApi;
import com.khoders.smartschool.entities.School;
import com.khoders.smartschool.entities.SchoolSubject;
import com.khoders.smartschool.entities.TeacherSubject;
import com.khoders.smartschool.entities.setup.UserAccount;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author richa
 */
@Stateless
public class AppService
{
    @Inject private CrudApi crudApi;
    public List<TeacherSubject> teacherSubjectList(){
        return crudApi.getEm().createQuery("SELECT e FROM TeacherSubject e ORDER BY e.createdDate ASC", TeacherSubject.class).getResultList(); 
    }
    public List<UserAccount> staffList(){
        return crudApi.getEm().createQuery("SELECT e FROM UserAccount e ORDER BY e.createdDate ASC", UserAccount.class).getResultList(); 
    }
    public List<SchoolSubject> schoolSubjectList(TeacherSubject teacherSubject){
        return crudApi.getEm().createQuery("SELECT e FROM SchoolSubject e WHERE e.teacherSubject=?1 ORDER BY e.createdDate ASC", SchoolSubject.class).setParameter(1, teacherSubject).getResultList(); 
    }
    public List<School> schoolList()
    {
        CriteriaBuilder builder = crudApi.getEm().getCriteriaBuilder();
        CriteriaQuery<School> criteriaQuery = builder.createQuery(School.class);
        Root<School> root = criteriaQuery.from(School.class);
        criteriaQuery.select(root);
        
        TypedQuery<School> typedQuery = crudApi.getEm().createQuery(criteriaQuery);
        return typedQuery.getResultList();
        
//        return crudApi.getEm().createQuery("SELECT e FROM School e ORDER BY e.createdDate ASC", School.class).getResultList(); 
    }
}
