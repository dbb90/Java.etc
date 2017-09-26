/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.service;

 
public class InvalidTaxRateException extends Exception{
   
   public InvalidTaxRateException(String message) {
       super(message);
   }
   
   public InvalidTaxRateException(String message , Throwable cause) {
       super(message , cause);
   }

}