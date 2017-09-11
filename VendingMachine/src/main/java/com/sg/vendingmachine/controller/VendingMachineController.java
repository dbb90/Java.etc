/*
 	 * To change this license header, choose License Headers in Project Properties.
 	 * To change this template file, choose Tools | Templates
 	 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import java.util.List;

import com.sg.vendingmachine.dao.InventoryFileException;
import com.sg.vendingmachine.dto.Slot;
import com.sg.vendingmachine.service.VendingMachineService;
import com.sg.vendingmachine.ui.VendingMachineView;

/**
 *
 * @author dbb09
 */
public class VendingMachineController {

    VendingMachineService service;
    VendingMachineView view;

    public VendingMachineController(
            VendingMachineService service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        int option;
        boolean run;

        try {
            service.loadInventory();
            List<Slot> slotList = service.getAllSlots();

            run = true;
            while (run) {
                view.machineBanner();
                view.printInventory(slotList);
                option = view.mainMenu();
                switch (option) {

                    case 0:
                        // quit
                        run = false;
                        break;

                    case 1:
                        selectSlot();
                        break;

                    case 2:
                        insertMoney();
                        break;

                    case 3:
                        returnMoney();
                        break;

                    case 4:
                        service();
                        break;

                    default:
                        view.errorMessage("Menu error!");

                }
            }
        } catch (InventoryFileException e) {
            view.errorMessage(e.getMessage());
        }

        // saves
        try {
            service.saveInventory();
        } catch (InventoryFileException e) {
            view.errorMessage(e.getMessage());
        }

        view.quitMessage();
    }

    private void selectSlot() {

    }

    private void insertMoney() {

    }

    private void returnMoney() {

    }

    private void service() {
        int option;
        boolean run;

        run = true;
        while (run) {
            view.serviceMenuBanner();
            option = view.serviceMenu();
            switch (option) {
                case 0:
                    // back
                    run = false;
                    break;
                case 1:
                    // select
                    break;
                case 2:
                    // stock
                    stock();
                    break;
                case 3:
                    // clear
                    break;
                default:
                    view.errorMessage("Menu error!");

            }
        }
    }

    private void stock() {
        Slot slot = view.stockSlot();
        service.stockSlot(slot);
    }
}
