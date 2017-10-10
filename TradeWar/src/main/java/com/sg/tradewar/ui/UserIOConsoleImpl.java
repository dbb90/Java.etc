/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tradewar.ui;

import java.math.BigDecimal;
import java.util.Scanner;

 

public class UserIOConsoleImpl implements UserIO {

   static Scanner sc = new Scanner(System.in);

 

   @Override
   public void printLine(String message) {
       System.out.println(message);
   }

   

   @Override
   public void print(String message) {
       System.out.print(message);
   }

 

   @Override
   public double readDouble(String prompt) {

       printLine(prompt);
       double num = 0;
       boolean invalidEntry = true;
       while (invalidEntry) {

           try {
               num = Double.parseDouble(sc.nextLine());
               invalidEntry = false;
           } catch (NumberFormatException e) {
               printLine("Invalid entry!");
               printLine(prompt);
           }
       }
       return num;

   }

 

   @Override

   public double readDouble(String prompt, double min, double max) {

       double returnValue = readDouble(prompt);
       while (returnValue < min || returnValue > max) {
           printLine("Please input number between " + min + " and " + max);
           returnValue = Double.parseDouble(sc.nextLine());
       }

       return returnValue;

   }

 

   @Override

   public float readFloat(String prompt) {

       printLine(prompt);
       float num = 0;
       boolean isInvalid = true;
       while (isInvalid) {

           try {
               num = Float.parseFloat(sc.nextLine());
               isInvalid = false;
           } catch (NumberFormatException e) {
               printLine("Invalid entry!");
               printLine(prompt);
           }
       }

       return num;

 

   }

 

   @Override

   public float readFloat(String prompt, float min, float max) {
       float returnValue = readFloat(prompt);
       while (returnValue < min || returnValue > max) {
           printLine("Please input number between " + min + " and " + max);
           returnValue = Float.parseFloat(sc.nextLine());
       }

       return returnValue;

   }

 

   @Override

   public int readInt(String prompt) {

       printLine(prompt);
       int num = 0;
       boolean invalidEntry;
       invalidEntry = true;
       while (invalidEntry) {
           try {
               num = Integer.parseInt(sc.nextLine());
               invalidEntry = false;
           } catch (NumberFormatException e) {
               printLine("Invalid entry!");
               printLine(prompt);
           }
       }

       return num;

 

   }

 

   @Override

   public int readInt(String prompt, int min, int max) {

       int returnValue = readInt(prompt);
       while (returnValue < min || returnValue > max) {
           printLine("Please input number between " + min + " and " + max);
           returnValue = Integer.parseInt(sc.nextLine());
       }

       return returnValue;

   }

   

   @Override

   public int readInt(String prompt, int min){

       int returnValue = readInt(prompt);
       while (returnValue < min){
           printLine("Please input number greater than " + min);
           returnValue = Integer.parseInt(sc.nextLine());

       }
       return returnValue;
   }

 

   @Override

   public long readLong(String prompt) {

       printLine(prompt);
       long num = 0;
       boolean invalidEntry;
       invalidEntry = true;
       while (invalidEntry) {

           try {
               num = Long.parseLong(sc.nextLine());
               invalidEntry = false;
           } catch (NumberFormatException e) {
               printLine("Invalid entry!");
               printLine(prompt);
           }
       }

       return num;

 

   }

 

   @Override

   public long readLong(String prompt, long min, long max) {
       long returnValue = readLong(prompt);
       while (returnValue < min || returnValue > max) {
           printLine("Please input number between " + min + " and " + max);
           returnValue = Long.parseLong(sc.nextLine());
       }
       return returnValue;
   }

 

   @Override

   public String readString(String prompt) {
       printLine(prompt);
       return sc.nextLine();
   }

 

  

 
    @Override
    public BigDecimal readBigDecimal(String prompt) {
        System.out.println(prompt);
        BigDecimal myBigDecimal = new BigDecimal(0);
        boolean isInvalid = true;

        while (isInvalid) {
            try {
                myBigDecimal = new BigDecimal(sc.nextLine());
                isInvalid = false;
            } catch (NumberFormatException e) {
                System.out.println("invalid entry!");
                System.out.println(prompt);
            }
        }
        return myBigDecimal;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt, BigDecimal min) {
        BigDecimal myBigDecimal = readBigDecimal(prompt);
        while ((myBigDecimal.compareTo(min) == 0)) {
            System.out.println("Please give me a number above" + min);
            myBigDecimal = readBigDecimal(prompt);
        }

        return myBigDecimal;
    }

 

}