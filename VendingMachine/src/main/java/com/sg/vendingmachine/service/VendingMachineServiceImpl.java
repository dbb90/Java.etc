/*
 	 * To change this license header, choose License Headers in Project Properties.
 	 * To change this template file, choose Tools | Templates
 	 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VMPersistenceException;
import com.sg.vendingmachine.dto.Products;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dbb09
 */
public class VendingMachineServiceImpl implements VendingMachineService {

    
    public VendingMachineServiceImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    private VendingMachineDao dao;
    private BigDecimal userCash = new BigDecimal("0.00");

    
    @Override
    public void createProduct(Products product) throws 
            VMPersistenceException,
            VendingMachineDataValidationException, 
            VendingMachineDuplicateException {
        
        if (dao.getProduct(product.getProductName()) != null) {
            throw new VendingMachineDuplicateException("Duplicate product!");
            
        }

        dao.addProduct(product.getProductName(), product);
    }

    @Override
    public List<Products> getAllProducts() throws VMPersistenceException {
        return dao.getAllProducts();
    }

    @Override
    public void updateInv(String productName, Products product) throws VMPersistenceException {
        dao.editProduct(productName, product);
    }

    @Override
    public BigDecimal processPurchase(BigDecimal cashInserted, Products product) throws 
            NotEnoughMoneyException,
            VMPersistenceException, 
            noProductStockedException {
        this.userCash = cashInserted;

        validateCash(product);

        this.userCash = this.userCash.subtract(product.getProductPrice());
        
        return this.userCash;
    }
    
   // @Override
   // public BigDecimal addCash(BigDecimal cashInserted) throws
   //         WrongCashFormatException {
   //     validateCash(cashInserted);
   //
   //     this.userCash = this.userCash.add(cashInserted);
   // 
   //     return this.userCash;
   // }


    @Override
    public void checkInv(Products product) throws noProductStockedException {
        validateProductInv(product);
    }

    @Override
    public List<Products> getProductsInStock() throws VMPersistenceException {
        List<Products> products = getAllProducts();
        List<Products> productsInStock = new ArrayList<>();

        for (Products product : products) {
            if (product.getNumOfProductsStocked() > 0) {
                productsInStock.add(product);
            }
        }

        return productsInStock;
    }
// range?  not specific # ^^
    
    
    private void validateCash(Products product) throws NotEnoughMoneyException {
        if (product.getProductPrice().compareTo(userCash) == 1) {
            throw new NotEnoughMoneyException("Not enough cash inserted. Please"
                    + "put more money in the machine and try again.");
        }
    }

    private void validateProductInv(Products product) throws noProductStockedException {
        if (product.getNumOfProductsStocked() == 0) {
            throw new noProductStockedException("Out of Stock.");
        }
    }


}
