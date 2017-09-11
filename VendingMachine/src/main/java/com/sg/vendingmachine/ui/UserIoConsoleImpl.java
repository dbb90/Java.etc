/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.Scanner;

/**
 *
 * @author dbb09
 */
public class UserIoConsoleImpl implements UserIo {

    private Scanner scan = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        double n;
        String input;

        System.out.print(prompt);
        input = scan.nextLine();
        n = Double.parseDouble(input);

        return n;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double n;
        String input;

        while (true) {
            System.out.print(prompt);
            input = scan.nextLine();

            try {
                n = Double.parseDouble(input);
                if ((n >= min) && (n <= max)) {
                    break;
                }
            } catch (NumberFormatException e) {

            }

            System.out.println("Invalid. Retry:");
        }

        return n;
    }

    @Override
    public float readFloat(String prompt) {
        float n;
        String input;

        System.out.print(prompt);
        input = scan.nextLine();
        n = Float.parseFloat(input);
        return n;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float n;
        String input;

        while (true) {
            System.out.print(prompt);
            input = scan.nextLine();
            n = Float.parseFloat(input);

            if ((n >= min) && (n <= max)) {
                break;
            }
            System.out.println("Invalid.");
        }

        return n;
    }

    @Override
    public int readInt(String prompt) {
        boolean valid;
        int n = -1;
        String input;

        // get input
        do {
            System.out.print(prompt);
            input = scan.nextLine();

            // parse as integer
            try {
                n = Integer.parseInt(input);
                valid = true;
            } catch (NumberFormatException e) {
                valid = false;
            }

            if (!valid) {
                System.out.println("Invalid.");
            }
        } while (!valid);

        return n;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        boolean valid;
        int n = -1;
        String input;

        // get input
        do {
            System.out.print(prompt);
            input = scan.nextLine();

            // parse as integer
            try {
                n = Integer.parseInt(input);

                // range test
                valid = ((n >= min) && (n <= max));
            } catch (NumberFormatException e) {
                valid = false;
            }

            if (!valid) {
                System.out.println("Invalid.");
            }
        } while (!valid);

        return n;
    }

    @Override
    public long readLong(String prompt) {
        long n;
        String input;

        System.out.print(prompt);
        input = scan.nextLine();
        n = Long.parseLong(input);

        return n;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long n;
        String input;

        while (true) {
            System.out.print(prompt);
            input = scan.nextLine();
            n = Long.parseLong(input);

            if ((n >= min) && (n <= max)) {
                break;
            }
            System.out.println("Invalid.");
        }

        return n;
    }

    @Override
    public String readString(String prompt) {
        String input;

        System.out.print(prompt);
        input = scan.nextLine();
        return input;
    }

    @Override
    public boolean readYesNo(String prompt) {
        String input;

        while (true) {
            System.out.print(prompt);
            input = scan.nextLine();
            if (input.toLowerCase().startsWith("y")) {
                return true;
            } else if (input.toLowerCase().startsWith("n")) {
                return false;
            } else {
                System.out.println("Invalid.");
            }
        }
    }

    @Override
    public LocalDate readLocalDate(DateTimeFormatter formatter, String prompt) {
        boolean valid;
        String input;
        LocalDate date = null;

        do {
            System.out.print(prompt);
            input = scan.nextLine();
            try {
                date = LocalDate.parse(input, formatter);
                valid = true;
            } catch (DateTimeParseException e) {
                valid = false;
                System.out.println("Invalid.");
            }

        } while (!valid);
        return date;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        boolean valid;
        String input;
        BigDecimal bigdecimal = null;

        do {
            System.out.print(prompt);
            input = scan.nextLine();
            try {
                bigdecimal = new BigDecimal(input);
                valid = true;
            } catch (Exception e) {
                valid = false;
                System.out.println("Invalid.");
            }
        } while (!valid);
        return bigdecimal;
    }
}
