/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import java.util.List;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.InventoryFileException;
import com.sg.vendingmachine.dto.Slot;

/**
 *
 * @author dbb09
 */
public class VendingMachineServiceFileImpl implements VendingMachineService {

    VendingMachineDao dao;
    double balance = 0;

    public VendingMachineServiceFileImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    @Override
    public void loadInventory() throws InventoryFileException {
        dao.loadInventoryFile();
    }

    @Override
    public void saveInventory() throws InventoryFileException {
        dao.saveInventoryFile();
    }

    @Override
    public List<Slot> getAllSlots() {
        return dao.getAllSlots();
    }

    @Override
    public void stockSlot(Slot slot) {
        dao.fillSlot(slot);
    }
}
