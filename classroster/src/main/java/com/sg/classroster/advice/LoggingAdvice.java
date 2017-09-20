/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.advice;

import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author dbb09
 */
public class LoggingAdvice {
 
    ClassRosterAuditDao auditDao;
 
    public LoggingAdvice(ClassRosterAuditDao auditDao) {
        this.auditDao = auditDao;
    }
    
   //At the top of the class there is a class level variable of type ClassRosterAuditDao 
    //that holds a reference to the Audit Dao.  The constructor has an argument of type
    //ClassRosterAuditDao.  The Spring framework will use the constructor to pass in an
    //instance of the Audit Dao when it instantiates the LoggingAdvice class for us.
 
    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (ClassRosterPersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}