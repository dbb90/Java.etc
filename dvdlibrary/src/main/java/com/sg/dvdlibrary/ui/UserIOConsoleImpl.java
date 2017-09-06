

/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */

package com.sg.dvdlibrary.ui;

 

import java.util.Scanner;

 

/**

 *

 * @author dbb09-

 */

public class UserIOConsoleImpl implements UserIO{

   

   static Scanner sc = new Scanner(System.in);

 

   @Override

   public void print(String message) {

       System.out.println(message);

   }

 

   @Override

   public double readDouble(String prompt) {

       print(prompt);

       double num = 0;

       boolean isInvalid = true;

       while (isInvalid){

           try{

               num = Double.parseDouble(sc.nextLine());

               isInvalid = false;

           }catch (NumberFormatException e){

               print("You can't do that!");

               print(prompt);

           }

       }

       return num;

   }

 

   @Override

   public double readDouble(String prompt, double min, double max) {

       double returnValue = readDouble(prompt);

       while (returnValue < min || returnValue > max) {

           print("Please input number between " + min + " and " + max);

           returnValue = Double.parseDouble(sc.nextLine());

       }

       return returnValue;

   }

 

   @Override

   public float readFloat(String prompt) {

       print(prompt);

       float num = 0;

       boolean isInvalid = true;

       while (isInvalid){

           try{

               num = Float.parseFloat(sc.nextLine());

               isInvalid = false;

           }catch (NumberFormatException e){

               print("You can't do that!");

               print(prompt);

           }

       }

       return num;

   

   }

 

   @Override

   public float readFloat(String prompt, float min, float max) {

       float returnValue = readFloat(prompt);

       while (returnValue < min || returnValue > max) {

           print("Please input number between " + min + " and " + max);

           returnValue = Float.parseFloat(sc.nextLine());

       }

       return returnValue;

   }

 

   @Override

   public int readInt(String prompt) {

       print(prompt);

       int num = 0;

       boolean isInvalid = true;

       while (isInvalid){

           try{

               num = Integer.parseInt(sc.nextLine());

               isInvalid = false;

           }catch (NumberFormatException e){

               print("You can't do that!");

               print(prompt);

           }

       }

       return num;

   

}

 

   @Override

   public int readInt(String prompt, int min, int max) {

       int returnValue = readInt(prompt);

       while (returnValue < min || returnValue > max) {

           print("Please input a number between " + min + " and " + max);

           returnValue = Integer.parseInt(sc.nextLine());

       }

       return returnValue;

   }

 

   @Override

   public long readLong(String prompt) {

       print(prompt);

       long num = 0;

       boolean isInvalid = true;

       while (isInvalid){

           try{

               num = Long.parseLong(sc.nextLine());

               isInvalid = false;

           }catch (NumberFormatException e){

               print("You can't do that!");

               print(prompt);

           }

       }

       return num;

   

   }

 

   @Override

   public long readLong(String prompt, long min, long max) {

       long returnValue = readLong(prompt);

       while (returnValue < min || returnValue > max) {

           print("Please input a number between " + min + " and " + max);

           returnValue = Long.parseLong(sc.nextLine());

       }

       return returnValue;

   }

 

   @Override

   public String readString(String prompt) {

       print(prompt);

       return sc.nextLine();

   }

}