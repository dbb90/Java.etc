/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.dao;

 

import com.sg.floorm.dto.Config;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FloorMConfigDaoFileImpl implements FloorMConfigDao{

 

   private Config config;

   public FloorMConfigDaoFileImpl () {
   }
   
   @Override
   public String getConfig() {
       return config.getType();
   }
   

   @Override
   public void readConfig() throws FloorMPersistenceException {
       Scanner scan;
       
       try {
           scan = new Scanner(new BufferedReader(new FileReader("Config.txt")));
       } catch (FileNotFoundException e) {
           throw new FloorMPersistenceException("Can't read Config!");
       }
       String configType;
       while (scan.hasNextLine()) {
           configType = scan.nextLine();
           if (configType.contains("::x")) {
               continue;
           }
           config = new Config(configType);
           
       }
       scan.close();
   }
}