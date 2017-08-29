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
public class DogGenetics {
    public static void main(String[] args) {
        String dogName;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int perc1, perc2, perc3, perc4, perc5;
        int percRemaining;
        System.out.println("What is your dogs name? ");
        dogName = sc.nextLine();
        System.out.println("Well then, I have this highly reliable report on " + dogName + 
                "'s prestigious background right here!");
        System.out.println("\n");
        perc1 = rand.nextInt(100) + 1;
        percRemaining = 100 - perc1;
        perc2 = rand.nextInt(percRemaining) + 1;
        percRemaining -= perc2;
        perc3 = rand.nextInt(percRemaining) + 1;
        percRemaining -= perc3;
        perc4 = rand.nextInt(percRemaining) + 1;
        percRemaining -= perc4;
        perc5 = percRemaining;
        System.out.println("In addition to being an 100% good boy, " + dogName + " is: ");
        System.out.println(perc1 + "% Cairn Terrier");
        System.out.println(perc2 + "% German Shepherd");
        System.out.println(perc3 + "% Pit Bull");
        System.out.println(perc4 + "% Chocolate Lab");
        System.out.println(perc5 + "% Poodle");
        System.out.println("\n");
        System.out.println("Wow, he's QUITE the dog!");
    }
}