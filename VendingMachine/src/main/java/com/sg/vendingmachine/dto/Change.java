/*
 	 * To change this license header, choose License Headers in Project Properties.
 	 * To change this template file, choose Tools | Templates
 	 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author dbb09
 */
public class Change {

    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

    public Change(BigDecimal changeDue) {
        
        BigDecimal changeDueInPennies = changeDue.multiply(new BigDecimal(100));
        
        Integer totalPennies = changeDueInPennies.intValue();
        
        this.quarters = Math.floorDiv(totalPennies, 25);
        int penniesLeft = totalPennies - (this.quarters * 25);
        
        this.dimes = Math.floorDiv(penniesLeft, 10);
        penniesLeft = penniesLeft - (this.dimes * 10);
        
        this.nickels = Math.floorDiv(penniesLeft, 5);
        penniesLeft = penniesLeft - (this.nickels * 5);
        
        this.pennies = penniesLeft;
    }

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public int getPennies() {
        return pennies;
    }

}
