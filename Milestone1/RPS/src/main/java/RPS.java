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
import java.util.Random;


public class RPS {
    public static void main(String[] args) throws InterruptedException {
        int numRounds, npcPick, userPick, numTies = 0, numWins = 0, numLosses = 0;
        String ruleRefresher;
        String playAgain = "y";
        Random rand = new Random();
        Scanner userInput = new Scanner(System.in);
        do {
            System.out.println("Let's play Rock, Paper, Scissors! Do you need a refresher on the rules? Y/N");
            ruleRefresher = userInput.nextLine();
            if (ruleRefresher.equalsIgnoreCase("Y")) {
                System.out.println("Looks like someone's been living under a rock!");
                System.out.println("Okay, the rules are simple.  First, you'll select rock, paper, and scissors!");
                System.out.println("Then your opponent will do the same!");
                System.out.println("Rock smashes scissors, paper covers rock, and scissors cut paper!");
                System.out.println("Choose correctly to beat your opponent.  It's that simple!");
                Thread.sleep(3000);
               
                
            } else {
                System.out.println("Alright, great!  Let's play!");
            }
            System.out.print( "\n" );
            do {
                    System.out.println("Please select number of rounds between 1 and 10: ");
                    while (!userInput.hasNextInt()) {
                            System.out.println("*KLAXON SOUNDS* Please select a valid number of rounds. ");
                        userInput.next();
                    } 
                     numRounds = userInput.nextInt();
            } while ((numRounds <= 0) || (numRounds > 10));
           
      
            for (int i = 0; i < numRounds; i++) {
                
                do {
                    System.out.println("Enter a number between 1 and 3!");
                    System.out.println("1 = Rock");
                System.out.println("2 = Paper");
                System.out.println("3 = Scissors");
                    while (!userInput.hasNextInt()) {
                        System.out.println("that's not a number!");
                        userInput.next();
                    }
                    userPick = userInput.nextInt();
                } while ((userPick <= 0) || (userPick > 3));
                    npcPick = rand.nextInt(3) + 1;
                    Thread.sleep(500);
                    if (npcPick == userPick) {
                        numTies++;
                        System.out.println("It's a tie!");
                
                } else if (userPick == 3) {
                    if (npcPick == 2) {
                        numWins++;
                        System.out.println("Your opponent picked paper!");
                        System.out.println("You won!");
                    } else {
                        numLosses++;
                        System.out.println("Your opponent picked rock!");
                        System.out.println("You lost!");
                    }
                } else if (userPick == 2) {
                    if (npcPick == 1) {
                        numWins++;
                        System.out.println("Your opponent picked rock!");
                        System.out.println("You won!");
                    } else {
                        numLosses++;
                        System.out.println("Your opponent picked scissors!");
                        System.out.println("You lost!");
                    }
                } else if (userPick == 1) {
                    if (npcPick == 3) {
                        numWins++;
                        System.out.println("Your opponent picked scissors!");
                        System.out.println("You won!");
                    } else {
                        numLosses++;
                        System.out.println("Your opponent picked paper!");
                        System.out.println("You lost!");
                    }
                } else {
                    numLosses++;
                    System.out.print("You lost!  Try choosing a valid input!");
                }
            System.out.print( "\n" );
            }

            System.out.println("You won " + numWins + " times!");
            System.out.println("You lost " + numLosses + " times!");
            System.out.println("You tied " + numTies + " times!");

            if (numWins == numLosses) {
                System.out.println("You tied the series!");
            } else if (numWins > numLosses) {
                System.out.println("You won the series!  Well done!");
            } else {
                System.out.println("Your opponent won the series!  Bummer!");
            }
            System.out.println("Go again? Y/N: ");
            userInput.nextLine();
            playAgain = userInput.nextLine();
        } while (playAgain.equalsIgnoreCase("Y"));
        System.out.println("See ya!");
    }
}