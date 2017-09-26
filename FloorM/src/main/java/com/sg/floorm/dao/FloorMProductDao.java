/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.dao;

import com.sg.floorm.dto.Product;
import java.util.List;

public interface FloorMProductDao {

    Product addProduct(Product product);
    Product removeProduct(Product product);
    Product editProduct(Product oldProduct, Product newProduct);
    Product getProduct(String productType);
    List<Product> getAllProducts();
    void readPData() throws FloorMPersistenceException;
}