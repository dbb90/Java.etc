/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbb09
 */
import java.util.Scanner;
public class HealthyHearts {
    public static void main(String[] args){
        
        Scanner userInput = new Scanner(System.in);
        int userAge, rateMax;
        String stringUserAge;
       
        System.out.println("To receive your ideal and naximum heart rate, please enter your age: ");
        stringUserAge = userInput.nextLine();
        
        userAge = Integer.parseInt(stringUserAge);
        rateMax = 220 - userAge;
        System.out.println("At your spry young age, " + userAge + ", your maximum heartrate is: " + rateMax);
        System.out.println("...and your target heart rate is between: " + (rateMax * .5) + " and " + (rateMax * .85));
    
    
    }
}