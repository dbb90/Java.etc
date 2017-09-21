/*
 	 * To change this license header, choose License Headers in Project Properties.
 	 * To change this template file, choose Tools | Templates
 	 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VMPersistenceException;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.ArrayOOBException;
import com.sg.vendingmachine.service.NotEnoughMoneyException;
import com.sg.vendingmachine.service.ProductNotStockedException;
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
                if (!quitChoice(userChoice)) {
                    Product product = service.processUserChoice(userChoice);
                    
                    purchaseProduct(product);

                } else {

                    run = false;
                    view.displayExitBanner();

                }

            } catch (VMPersistenceException
                    | ProductNotStockedException | NotEnoughMoneyException | ArrayOOBException e) {

                view.displayErrorMessage(e.getMessage());

            }
        } while (run);

    }

    private boolean quitChoice(int userChoice) throws VMPersistenceException {
        return userChoice == 0;
    }
    
    private int displayProductOptions() throws
            VMPersistenceException,
            ProductNotStockedException {

        List<Product> products = service.getProductsInStock();
        view.displayChoicePrompt();

        return view.displayProducts(products);
    }

     private void purchaseProduct(Product product) throws
           VMPersistenceException,
           NotEnoughMoneyException,
           ProductNotStockedException,
           NumberFormatException {

       
       view.displayUserProductChoice(product);
       BigDecimal userBalance = new BigDecimal(view.getCashInput());
       userBalance = service.processPurchase(userBalance, product);
       Change changeified = service.changeifier(product, userBalance);
       
       view.displaySuccessBanner();
       view.displayChange(changeified);
       view.displayRemainingProductInv(product);
       
       service.updateInv(product.getProductName(), product);
    }



    }


        
    
