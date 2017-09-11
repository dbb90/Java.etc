/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

/**
 *
 * @author dbb09
 */
public class SlotValidationException extends Exception {

    public SlotValidationException(String message) {
        super(message);
    }

    public SlotValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
