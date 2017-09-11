/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author dbb09
 */
public interface UserIo {

    void print(String message);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);

    String readString(String prompt);

    boolean readYesNo(String prompt);

    LocalDate readLocalDate(DateTimeFormatter formatter, String prompt);

    BigDecimal readBigDecimal(String prompt);
}
