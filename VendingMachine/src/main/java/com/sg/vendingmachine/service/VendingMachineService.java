/*
 	 * To change this license header, choose License Headers in Project Properties.
 	 * To change this template file, choose Tools | Templates
 	 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VMPersistenceException;
import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.dto.Change;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author dbb09
 */
public interface VendingMachineService {

//    void createProduct(Product product) throws 
//            VMPersistenceException,
//            VendingMachineDataValidationException,
//            VendingMachineDuplicateException;

    List<Product> getAllProducts() throws VMPersistenceException;

    BigDecimal processPurchase(BigDecimal cashInserted, Product product)
            throws NotEnoughMoneyException, 
            VMPersistenceException,
            ProductNotStockedException;
    
    //process change is being moved to the service layer from the view
    void processChange(BigDecimal change) throws VMPersistenceException;
    
    void checkInv(Product product) throws ProductNotStockedException;

    List<Product> getProductsInStock() throws VMPersistenceException;

    void updateInv(String productName, Product product) throws VMPersistenceException;
}
