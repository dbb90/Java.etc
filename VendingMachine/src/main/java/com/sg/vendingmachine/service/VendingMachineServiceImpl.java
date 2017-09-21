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
import com.sg.vendingmachine.ui.VendingMachineView;
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
    private VendingMachineView view;
    private BigDecimal userCash = new BigDecimal("0.00");

    public VendingMachineServiceImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public List<Product> getAllProducts() throws VMPersistenceException {
        return dao.getAllProducts();
    }

    @Override
    public void updateInv(String productName, Product product) throws VMPersistenceException {
        dao.editProduct(productName, product);
    }

    @Override
    public Product processUserChoice(int userChoice) throws VMPersistenceException, ProductNotStockedException, ArrayOOBException {
        userChoice--;
        List<Product> product = getProductsInStock();
        checkInv(product.get(userChoice));
        return product.get(userChoice);
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

    @Override
    public void checkInv(Product product) throws ProductNotStockedException, ArrayOOBException {
        validateProductInv(product);
    }

    @Override
    public List<Product> getProductsInStock() throws VMPersistenceException {
        List<Product> products = getAllProducts();
        List<Product> productsInStock = new ArrayList<>();

        for (Product product : products) {
            if (product.getNumberOfProducts() > 0) {
                productsInStock.add(product);
            }
        }

        return productsInStock;
    }

    @Override
    public Change changeifier(Product productWanted, BigDecimal cashInserted) throws VMPersistenceException {

        BigDecimal changeInDollars = this.calculateChange(cashInserted, productWanted.getProductPrice());

        changeInDollars = changeInDollars.setScale(2, HALF_UP);
        BigDecimal factor = new BigDecimal(100);
        factor = factor.setScale(2, HALF_UP);
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
        if (product.getNumberOfProducts() == 0) {
            throw new ProductNotStockedException("Out of Stock.");
        }
    }
}
