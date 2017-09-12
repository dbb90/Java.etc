/*
 	 * To change this license header, choose License Headers in Project Properties.
 	 * To change this template file, choose Tools | Templates
 	 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VMPersistenceException;
import com.sg.vendingmachine.dto.Products;
import com.sg.vendingmachine.service.NotEnoughMoneyException;
import com.sg.vendingmachine.service.noProductStockedException;
import com.sg.vendingmachine.service.VendingMachineService;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author dbb09
 */
public class VendingMachineController {

    private VendingMachineService service;
    private VendingMachineView view;

    public VendingMachineController(VendingMachineService service, VendingMachineView view) {

        this.service = service;
        this.view = view;

    }

    public void run() {

        boolean errorTrue = true;
        boolean run = true;

        view.displayIntroBanner();

        do {

            try {

                int userChoice = displayProductOptions();
                if (!(quitChoice(userChoice))) {
                    Products product = processUserChoice(userChoice);

                    do {

                        try {

                            purchaseProduct(product);
                            errorTrue = false;
                        } catch (NotEnoughMoneyException e) {

                            view.displayErrorMessage(e.getMessage());
                            errorTrue = true;

                        } catch (NumberFormatException e) {

                            view.displayErrorMessage("ERROR: Unknown currency format!");
                            errorTrue = true;

                        }

                    } while (errorTrue);

                } else {

                    run = false;
                    view.displayExitBanner();

                }

            } catch (VMPersistenceException
                    | noProductStockedException e) {

                view.displayErrorMessage(e.getMessage());

            }
        } while (run);

    }

    private boolean quitChoice(int userChoice) throws VMPersistenceException {
        return userChoice == 0;
    }


//    private void addFirst() throws
//            WrongCashFormatException, 
//            NumberFormatException {
//        BigDecimal userBalance = new BigDecimal(view.getCashInput());
//       service.addFunds(userBalance);
//    }
    private int displayProductOptions() throws
            VMPersistenceException,
            noProductStockedException {

        List<Products> products = service.getProductsInStock();
        view.displayChoicePrompt();

        return view.displayProducts(products);
    }

    private void purchaseProduct(Products product) throws
            VMPersistenceException,
            NotEnoughMoneyException,
            noProductStockedException,
            NumberFormatException {

        BigDecimal userBalance = new BigDecimal(view.getCashInput());

        BigDecimal change = service.processPurchase(userBalance, product);

        view.displaySuccessBanner();
        view.displayChange(change);
        view.displayRemainingProductInv(product);

        service.updateInv(product.getProductName(), product);
    }

    private Products processUserChoice(int userChoice) throws
            VMPersistenceException,
            noProductStockedException {
        userChoice--;
        List<Products> products = service.getProductsInStock();
        Products product = view.displayUserProductChoice(userChoice, products);
        service.checkInv(product);

        return product;

    }


        
    }
}
