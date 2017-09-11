/*
 	 * To change this license header, choose License Headers in Project Properties.
 	 * To change this template file, choose Tools | Templates
 	 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

/**
 *
 * @author dbb09
 */
public class InventoryFileException extends Exception {

    public InventoryFileException(String message) {
        super(message);
    }

    public InventoryFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
