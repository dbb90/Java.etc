/*
 	 * To change this license header, choose License Headers in Project Properties.
 	 * To change this template file, choose Tools | Templates
 	 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VMPersistenceException;
import com.sg.vendingmachine.dto.Products;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author dbb09
 */
public interface VendingMachineService {

    void createProduct(Products product) throws 
            VMPersistenceException,
            VendingMachineDataValidationException,
            VendingMachineDuplicateException;

    List<Products> getAllProducts() throws VMPersistenceException;

    BigDecimal processPurchase(BigDecimal cashInserted, Products product)
            throws NotEnoughMoneyException, 
            VMPersistenceException,
            noProductStockedException;
    
    void checkInv(Products product) throws noProductStockedException;

    List<Products> getProductsInStock() throws VMPersistenceException;

    void updateInv(String productName, Products product) throws VMPersistenceException;
}
