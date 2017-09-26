/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.dao;

import com.sg.floorm.dto.TaxRate;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FloorMTaxDaoFileImpl implements FloorMTaxDao {
    List<TaxRate> taxes = new ArrayList<>();
    @Override
    public TaxRate addTaxRate(TaxRate taxRate) {
        taxes.add(taxRate);
        return taxRate;
    }

    @Override
    public TaxRate removeTaxRate(TaxRate taxRate) {
        taxes.remove(taxRate);
        return taxRate;
    }
    @Override
    public TaxRate editTaxRate(TaxRate oldTaxRate, TaxRate newTaxRate) {
        taxes.remove(oldTaxRate);
        taxes.add(newTaxRate);
        return newTaxRate;
    }
    @Override
    public TaxRate getTaxRate(String name) {
        Iterator<TaxRate> iterated = taxes.iterator();
        while (iterated.hasNext()) {
            TaxRate currentTaxRate = iterated.next();
            if (currentTaxRate.getClientName().equals(name)) {
                return currentTaxRate;
            }
        }
        return null;
    }
    @Override
    public List<TaxRate> getAllTaxRates() {
        List<TaxRate> listToReturn = new ArrayList<>();
        for (TaxRate tax : taxes) {
            listToReturn.add(tax);
        }
        return listToReturn;
    }
    @Override
    public void readTData() throws FloorMPersistenceException {
        Scanner sc;
        try {
            sc = new Scanner(new BufferedReader(new FileReader("Data\\Taxes.txt")));
        } catch (FileNotFoundException e) {
            throw new FloorMPersistenceException("ERROR: Could not load data from tax file!");
        }
        taxes.clear();
        String currentLine;
        String[] currentTokens;
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(",");
            int i = 0;
            for (String currentString : currentTokens) {
                currentTokens[i] = currentString.trim();
                i++;
            }
            BigDecimal taxRate = new BigDecimal(currentTokens[1]);
            TaxRate newTaxRate = new TaxRate(currentTokens[0], taxRate);
            taxes.add(newTaxRate);
        }
    }
}
