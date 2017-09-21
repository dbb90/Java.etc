/*
 	 * To change this license header, choose License Headers in Project Properties.
 	 * To change this template file, choose Tools | Templates
 	 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VMPersistenceException;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Product;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author dbb09
 */
public interface VendingMachineService {

    List<Product> getAllProducts() throws VMPersistenceException;

 BigDecimal processPurchase(BigDecimal cashInserted, Product product)
           throws InsufficientFundsException,
           VMPersistenceException,
           ProductNotStockedException;
    
    void checkInv(Product product) throws ProductNotStockedException, ArrayOOBException;

    List<Product> getProductsInStock() throws VMPersistenceException;

    void updateInv(String productName, Product product) throws VMPersistenceException;

   Change changeifier(Product productWanted, BigDecimal userCash) throws VMPersistenceException;

    public Product processUserChoice(int userChoice) throws VMPersistenceException, ProductNotStockedException, ArrayOOBException;
}
