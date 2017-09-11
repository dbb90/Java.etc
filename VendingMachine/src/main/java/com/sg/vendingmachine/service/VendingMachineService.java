/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import java.util.List;

import com.sg.vendingmachine.dao.InventoryFileException;
import com.sg.vendingmachine.dto.Slot;

/**
 *
 * @author dbb09
 */
public interface VendingMachineService {

    public void loadInventory() throws InventoryFileException;

    public void saveInventory() throws InventoryFileException;

    public List<Slot> getAllSlots();

    public void stockSlot(Slot slot);
}
