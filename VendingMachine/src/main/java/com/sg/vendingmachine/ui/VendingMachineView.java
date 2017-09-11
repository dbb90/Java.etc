/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import java.math.BigDecimal;

import java.util.Collections;

import java.util.List;

import com.sg.vendingmachine.dto.Slot;

/**
 *
 * @author dbb09
 */
public class VendingMachineView {

    UserIo io;

    private final String prompt = "> ";
    private final String sepMaj = "================";
    private final String sepMin = "----------------";

    public VendingMachineView(UserIo io) {
        this.io = io;
    }

    public void printInventory(List<Slot> slotList) {
        io.print(sepMin);
        for (Slot slot : slotList) {
            String output = (slot.getSlotNumber() + ": "
                    + slot.getProduct() + " $"
                    + slot.getPrice());
            io.print(output);
        }
    }

    public int mainMenu() {
        int option;

        io.print(sepMin);
        io.print("0. Leave");
        io.print("1. Enter Selection");
        io.print("2. Insert Money");
        io.print("3. Return Money");
        io.print("4. Service");
        io.print(sepMin);
        option = io.readInt(prompt, 0, 4);
        return option;
    }

    public void machineBanner() {
        io.print(sepMaj);
        io.print(""
                + "----VENDING MACHINE----");
    }

    public void inventoryMenu(List<Slot> slotList) {
        io.print(sepMin);
        io.print("Inventory");
        io.print(sepMin);
    }

    public void serviceMenuBanner() {
        io.print(sepMaj);
        io.print("Service");
    }

    public int serviceMenu() {
        int option;

        io.print(sepMin);
        io.print("0. Back");
        io.print("1. Select Slot");
        io.print("2. Stock slot");
        io.print("3. Clear slot");
        io.print(sepMin);
        option = io.readInt(prompt);
        return option;
    }

    public int requestSlotNumber() {
        io.print(sepMin);
        io.print("Enter slot number:");
        int slotNumber = io.readInt(prompt);
        return slotNumber;
    }

    public String requestProduct() {
        io.print(sepMin);
        io.print("Enter product name:");
        String product = io.readString(prompt);
        return product;
    }

    public BigDecimal requestPrice() {
        io.print(sepMin);
        io.print("Enter price:");
        BigDecimal price = io.readBigDecimal(prompt);
        return price;
    }

    public int requestQuantity() {
        io.print(sepMin);
        io.print("Enter quantity:");
        int quantity = io.readInt(prompt);
        return quantity;
    }

    public Slot stockSlot() {
        io.print(sepMin);

        int slotNumber = requestSlotNumber();
        Slot slot = new Slot(slotNumber);

        String product = requestProduct();
        BigDecimal price = requestPrice();
        int quantity = requestQuantity();

        slot.setProduct(product);
        slot.setPrice(price);
        slot.setQuantity(quantity);
        return slot;
    }

    public void stockSuccessBanner() {
        io.print(sepMin);
        io.print("Slot stocked.");
    }

    public int serviceSlotMenu() {
        int option;

        io.print(sepMin);
        io.print("0. Back");
        io.print("1. Restock");
        io.print("2. Set price");
        io.print(sepMin);
        option = io.readInt(prompt, 0, 3);
        return option;
    }

    public void quitMessage() {
        io.print(sepMaj);
        io.print("Quitting...");
    }

    public void errorMessage(String message) {
        io.print(sepMaj);
        io.print("(!)");
        io.print(message);
    }

    private String formatMoney(BigDecimal amount) {
        throw new UnsupportedOperationException();
    }

}
