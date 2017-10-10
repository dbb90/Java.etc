/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tradewar.dao;

 

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FloorMAuditDaoFileImpl implements FloorMAuditDao{

   public static final String AUDITFILE = "flooringAudit.txt";
   @Override

   public void writeAuditEntry(String entry) throws TradeWarPersistenceException {
       PrintWriter out;
       try {
           out = new PrintWriter(new FileWriter(AUDITFILE , true));
       } catch (IOException e) {
           throw new TradeWarPersistenceException("Could not persist audit data!");
       }

       LocalDateTime timeStamp = LocalDateTime.now();
       DateTimeFormatter format = DateTimeFormatter.ofPattern("E MMM-dd-yyy  HH:mm:ss");
       String formattedDateTime = timeStamp.format(format);

       out.println(formattedDateTime + ": " + entry);

       out.flush();
       out.close();
   }

   

}