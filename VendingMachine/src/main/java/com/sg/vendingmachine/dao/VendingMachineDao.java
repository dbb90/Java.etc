/*
 	 * To change this license header, choose License Headers in Project Properties.
 	 * To change this template file, choose Tools | Templates
 	 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Product;
import java.util.List;

/**
 *
 * @author dbb09
 */
public interface VendingMachineDao {

    Product addProduct(String productName, Product product) throws VMPersistenceException;

    List<Product> getAllProducts() throws VMPersistenceException;

    Product getProduct(String productName) throws VMPersistenceException;

    void editProduct(String productName, Product product) throws VMPersistenceException;

    Product removeProduct(String productName) throws VMPersistenceException;

    //add load/save dedicated methods.  Passthru on initial app, service layer, for initialize load
}
