/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.dao;

import com.sg.floorm.dto.Product;
import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import java.util.ArrayList;
import java.util.List;


public class FloorMProductDaoStubImpl implements FloorMProductDao {
    
    Product stubProduct;
    List<Product> products = new ArrayList<>();
    
    public FloorMProductDaoStubImpl() { 
        
        String productType = "Argesium";
        BigDecimal materialCost = new BigDecimal("2.00");
        materialCost = materialCost.setScale(2, HALF_UP);
        
        BigDecimal laborCost = new BigDecimal("2.00");
        laborCost = laborCost.setScale(2, HALF_UP);
        
        stubProduct = new Product(productType , materialCost , laborCost);
        products.add(stubProduct);
    }
    
    @Override
    public Product addProduct(Product product) {
        if (!product.equals(stubProduct)) {
            return product;
        }else {
            return null;
        }
    }

    @Override
    public Product removeProduct(Product product) {
        if(product.equals(stubProduct)) {
            return stubProduct;
        } else {
            return null;
        }
    }

    @Override
    public Product editProduct(Product oldProduct, Product newProduct) {
        return newProduct;
    }

    @Override
    public Product getProduct(String productType) {
        if (productType.equals(stubProduct.getProductType())){
            return stubProduct;
        } else {
            return null;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> stubProducts = new ArrayList<>();
        stubProducts.add(stubProduct);
        return stubProducts;
    }

    @Override
    public void readPData() throws FloorMPersistenceException {

    }
    
}
