/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import java.math.BigDecimal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Slot;

/**
 *
 * @author dbb09
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private final String INVENTORY_FILE = "inventory.txt";
    private final String DELIMITER = "::";

    private Change change = new Change();

    private Map<Integer, Slot> slots = new HashMap<>();

    @Override
    public Change getChange() {
        return this.change;
    }

    @Override
    public void makeChange(BigDecimal money) {
        double currentMoney = money.doubleValue();
        int quarters = (int) (currentMoney / 25);
        currentMoney %= 25;
        int dimes = (int) (currentMoney / 10);
        currentMoney %= 10;
        int nickels = (int) (currentMoney / 5);
        int pennies = (int) (currentMoney % 5);

        change.setQuarters(quarters);
        change.setDimes(dimes);
        change.setNickels(nickels);
        change.setPennies(pennies);
    }

    @Override
    public void zeroChange() {
        change.setQuarters(0);
        change.setDimes(0);
        change.setNickels(0);
        change.setPennies(0);
    }

    @Override
    public Slot getSlot(int slotNumber) {
        return slots.get(slotNumber);
    }

    @Override
    public List<Slot> getAllSlots() {
        return new ArrayList<>(slots.values());
    }

    @Override
    public void fillSlot(Slot slot) {
        slots.put(slot.getSlotNumber(), slot);
    }

    @Override
    public void removeSlot(int slotNumber) {
        slots.remove(slotNumber);
    }

    @Override
    public void updateSlot(Slot slot) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadInventoryFile() throws InventoryFileException {
        String currentLine;
        String[] currentTokens;
        Scanner reader;

        try {
            reader = new Scanner(new BufferedReader(new FileReader(
                    INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new InventoryFileException("Could not load inventory file.");
        }

        while (reader.hasNextLine()) {
            currentLine = reader.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            // build slot
            int slotNumber = Integer.parseInt(currentTokens[0]);
            Slot currentSlot = new Slot(slotNumber);

            currentSlot.setProduct(currentTokens[1]);

            BigDecimal price = new BigDecimal(currentTokens[2]);
            currentSlot.setPrice(price);

            int quantity = Integer.parseInt(currentTokens[3]);
            currentSlot.setQuantity(quantity);

            // add slot to map
            slots.put(currentSlot.getSlotNumber(), currentSlot);
        }
        reader.close();
    }

    @Override
    public void saveInventoryFile() throws InventoryFileException {
        PrintWriter writer;
        List<Slot> slotList;

        try {
            writer = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new InventoryFileException("Could not save data.");
        }

        // write a delimited line for each slot in the file
        slotList = this.getAllSlots();
        for (Slot currentSlot : slotList) {
            writer.println(currentSlot.getSlotNumber() + DELIMITER
                    + currentSlot.getProduct() + DELIMITER
                    + currentSlot.getPrice() + DELIMITER
                    + currentSlot.getQuantity());
            writer.flush();
        }
        writer.close();
    }
}
