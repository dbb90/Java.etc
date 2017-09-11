/*
 	 * To change this license header, choose License Headers in Project Properties.
 	 * To change this template file, choose Tools | Templates
 	 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import java.math.BigDecimal;

import java.util.List;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Slot;

/**
 *
 * @author dbb09
 */
public interface VendingMachineDao {

    public void loadInventoryFile() throws InventoryFileException;

    public void saveInventoryFile() throws InventoryFileException;

    public Change getChange();

    public void makeChange(BigDecimal money);

    public void zeroChange();

    public Slot getSlot(int slotNumber);

    public List<Slot> getAllSlots();

    public void fillSlot(Slot slot);

    public void removeSlot(int slotNumber);

    public void updateSlot(Slot slot);
}
