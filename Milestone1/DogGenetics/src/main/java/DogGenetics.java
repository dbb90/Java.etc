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

    static Random rand = new Random();

    public static void main(String[] args) {
        String dogName;
        Scanner sc = new Scanner(System.in);
        int[] percentages = new int[5];
        System.out.println("What is your dogs name? ");
        dogName = sc.nextLine();
        System.out.println("Well then, I have this highly reliable report on " + dogName
                + "'s prestigious background right here!");
        percentages = randomPercentages();
        System.out.println("\n");
        System.out.println("In addition to being an 100% good boy, " + dogName + " is: ");
        System.out.println(percentages[0] + "% Cairn Terrier");
        System.out.println(percentages[1] + "% German Shepherd");
        System.out.println(percentages[2] + "% Pit Bull");
        System.out.println(percentages[3] + "% Chocolate Lab");
        System.out.println(percentages[4] + "% Poodle");
        System.out.println("\n");
        System.out.println("Wow, he's QUITE the dog!");
    }

    public static int[] randomPercentages() {
        int[] percentages = new int[5];
        int n = 100;
        for (int i = 0; i < 5; i++) {
            if (n == 0) {
                percentages[i] = 0;
            } else {
                percentages[i] = rand.nextInt(n) + 1;
                n = n - percentages[i];
            }
        }
        return percentages;
    }


    }
