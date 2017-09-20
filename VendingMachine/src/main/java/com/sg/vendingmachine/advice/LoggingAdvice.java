/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.advice;
import com.sg.vendingmachine.dao.VMPersistenceException;
import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author dbb09
 */
public class LoggingAdvice {
    VendingMachineAuditDao auditDao;
    
    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }

    public void createAuditEntry(JoinPoint jp, Exception exception) {

        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        auditEntry += " |Exception thrown: " + exception.getClass().getSimpleName();
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VMPersistenceException e) {
            System.err.println("ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}