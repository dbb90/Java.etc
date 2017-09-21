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
public class ArrayOOBException extends Exception {

    public ArrayOOBException(String message) {

        super(message);

    }

    public ArrayOOBException(String message,
            Throwable cause) {

        super(message, cause);

    }

}
