/*
 	 * To change this license header, choose License Headers in Project Properties.
 	 * To change this template file, choose Tools | Templates
 	 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Products;
import java.util.List;

/**
 *
 * @author dbb09
 */
public interface VendingMachineDao {

    Products addProduct(String productName, Products product) throws VMPersistenceException;

    List<Products> getAllProducts() throws VMPersistenceException;

    Products getProduct(String productName) throws VMPersistenceException;

    void editProduct(String productName, Products product) throws VMPersistenceException;

    Products removeProduct(String productName) throws VMPersistenceException;

}
