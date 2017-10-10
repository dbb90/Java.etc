/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tradewar.dto;

/**
 *
 * @author dbb09
 */
public class Config {
   
   private String type;

   
   public Config (String type) {
       this.type = type;
   }

 
   public String getType() {
       return type;
   }

 
   public void setType(String type) {
       this.type = type;
   }
}