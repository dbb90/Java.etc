/*
 	 * To change this license header, choose License Headers in Project Properties.
 	 * To change this template file, choose Tools | Templates
 	 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VMPersistenceException;
import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Product;
import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dbb09
 */
public class VendingMachineServiceImpl implements VendingMachineService {

    private VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;
    private BigDecimal userCash = new BigDecimal("0.00");

    public VendingMachineServiceImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

 // TODO: "Unless you are planning on having your application CRUD - you could skip create as part of your service layer."
    @Override
    public void createProduct(Product product) throws
            VMPersistenceException,
            VendingMachineDataValidationException,
            VendingMachineDuplicateException {

        if (dao.getProduct(product.getProductName()) != null) {
            throw new VendingMachineDuplicateException("Duplicate product!");

        }

        dao.addProduct(product.getProductName(), product);}

    @Override
    public List<Product> getAllProducts() throws VMPersistenceException {
        return dao.getAllProducts();
    }

    @Override
    public void updateInv(String productName, Product product) throws VMPersistenceException {
        dao.editProduct(productName, product);
    }

   @Override
   public BigDecimal processPurchase(BigDecimal cashInserted, Product product) throws

           NotEnoughMoneyException,
           VMPersistenceException,
           ProductNotStockedException {

       this.userCash = cashInserted;
       validateCash(product);
       this.userCash = this.userCash.subtract(product.getProductPrice());
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       return this.userCash;

   }
//        private BigDecimal processChange(BigDecimal bigDecimal) {
//       
//    }



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
    public void checkInv(Product product) throws ProductNotStockedException {
        validateProductInv(product);
    }

    @Override
    public List<Product> getProductsInStock() throws VMPersistenceException {
        List<Product> products = getAllProducts();
        List<Product> productsInStock = new ArrayList<>();

        for (Product product : products) {
            if (product.getNumOfProductsStocked() > 0) {
                productsInStock.add(product);
            }
        }

        return productsInStock;
    }
// range?  not specific # ^^

    @Override
    public void processChange(BigDecimal change) throws VMPersistenceException {
        
    }
    
        
//Fix change routing here!!:
       
@Override
public Change changeifier(Product productWanted, BigDecimal cashInserted) throws VMPersistenceException{
   
BigDecimal changeInDollars = this.calculateChange(cashInserted, productWanted.getProductPrice());

       changeInDollars = changeInDollars.setScale(2 , HALF_UP);
       BigDecimal factor = new BigDecimal(100);
       factor = factor.setScale(2 , HALF_UP);
       BigDecimal pennies = cashInserted.multiply(factor).setScale(2, HALF_UP);
        int changeInPennies = pennies.intValue();

       Change change = new Change(changeInPennies);

       return change;
         
      
        
    }
private BigDecimal calculateChange(BigDecimal userMoney, BigDecimal itemCost) {

       return userMoney.subtract(itemCost);

   }

private void validateCash(Product product) throws NotEnoughMoneyException {
        if (product.getProductPrice().compareTo(userCash) == 1) {
            throw new NotEnoughMoneyException("Not enough cash inserted. Please"
                    + "put more money in the machine and try again.");
        }
    }

    private void validateProductInv(Product product) throws ProductNotStockedException {
        if (product.getNumOfProductsStocked() == 0) {
            throw new ProductNotStockedException("Out of Stock.");
        }}}
    
