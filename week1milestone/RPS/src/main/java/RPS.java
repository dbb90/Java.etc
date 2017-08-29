/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbb09
 */
import java.util.Scanner
import java.util.Random
import java.util.

public class RPS {

    public static void main(String[] args) {
        String userPick;
        String npcPick;
        String roundCountString;
        int computerInt;
        String response;

        Scanner scan = new Scanner(System.in);
        Random generator = new Random();
            
        
        System.out.println("Welcome to Rock Paper Scissors!  If you don't know how to play... go outside and ask someone, ya shut in!");
        System.out.println("So, how many rounds would you like to play (1-10)?");
        roundCountString = scan.next();
        int roundCount = Integer.valueOf(roundCountString);
        if ( roundCount > 10 ) {
            System.out.print("That's too many rounds, buddy!");
        }else if ( roundCount < 1 ) {
            System.out.print("You need to play at least one round, friend!");
        }else {
            
    }
    }

}
