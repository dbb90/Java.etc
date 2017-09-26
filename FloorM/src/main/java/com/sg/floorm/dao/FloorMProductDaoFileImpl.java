/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.dao;

import com.sg.floorm.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FloorMProductDaoFileImpl implements FloorMProductDao {

    private final List<Product> products = new ArrayList<>();

    @Override
    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product getProduct(String productType) {
        Iterator<Product> iterated = products.iterator();
        while (iterated.hasNext()) {
            Product currentProduct = iterated.next();
            if (!currentProduct.getProductType().equals(productType)) {
            } else {
                return currentProduct;
            }
        }
        return null;
    }

    @Override
    public Product removeProduct(Product product) {
        products.remove(product);
        return product;
    }

    @Override
    public Product editProduct(Product oldProduct, Product newProduct) {
        products.remove(oldProduct);
        products.add(newProduct);
        return newProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        for (Product product : this.products) {
            products.add(product);
        }
        return products;
    }

    public void readPData() throws FloorMPersistenceException {
        Scanner scan;
        try {
            scan = new Scanner(new BufferedReader(new FileReader(".\\Data\\Products.txt")));
        } catch (FileNotFoundException e) {
            throw new FloorMPersistenceException("ERROR: Could not read products from file!");
        }
        products.clear();
        String currentLine;
        String[] currentTokens;
        while (scan.hasNextLine()) {
            currentLine = scan.nextLine();
            currentTokens = currentLine.split(",");
            int i = 0;
            for (String currentString : currentTokens) {
                currentTokens[i] = currentString.trim();
                i++;
            }
            BigDecimal materialCost = new BigDecimal(currentTokens[1]);
            BigDecimal laborCost = new BigDecimal(currentTokens[2]);
            Product newProduct = new Product(currentTokens[0], materialCost, laborCost);
            products.add(newProduct);
        }
    }
}
