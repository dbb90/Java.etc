/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tradewar.advice;

 

import com.sg.tradewar.dao.FloorMAuditDao;
import com.sg.tradewar.dao.TradeWarPersistenceException;
import org.aspectj.lang.JoinPoint;

public class LoggingAdvice {
 
   private FloorMAuditDao auditDao;
 
   public LoggingAdvice(FloorMAuditDao auditDao) {
       this.auditDao = auditDao;
   }
 
   public void createAuditEntry(JoinPoint jp) {
       Object[] args = jp.getArgs();
       String auditEntry = jp.getSignature().getName() + ": ";
       for (Object currentArg : args) {
           auditEntry += currentArg;
       }
       try {
           auditDao.writeAuditEntry(auditEntry);
       } catch (TradeWarPersistenceException e) {
           System.err.println("Could not persist audit data");
       }
   }
}