/*
 	 * To change this license header, choose License Headers in Project Properties.
 	 * To change this template file, choose Tools | Templates
 	 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Products;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

/**
 *
 * @author dbb09
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private Map<String, Products> products = new HashMap<>();
    private static final String PROD_FILE = "products.txt";
    private static final String DELIMITER = "::";

    @Override
    public Products addProduct(String productName, Products product) throws VMPersistenceException {
        loadProductsLibrary();
        Products newProduct = products.put(productName, product);
        writeProductsLibrary();
        return newProduct;
    }

    @Override
    public List<Products> getAllProducts() throws VMPersistenceException {
        loadProductsLibrary();
        return new ArrayList<Products>(products.values());
    }

    @Override
    public Products getProduct(String productName) throws VMPersistenceException {
        loadProductsLibrary();
        return products.get(productName);
    }

    @Override
    public Products removeProduct(String productName) throws VMPersistenceException {
        loadProductsLibrary();
        Products removedProduct = products.remove(productName);
        writeProductsLibrary();
        return removedProduct;
    }

    @Override
    public void editProduct(String oldProductName, Products product) throws VMPersistenceException {
        removeProduct(oldProductName);
        addProduct(product.getProductName(), product);
    }

    private void loadProductsLibrary() throws VMPersistenceException {
        Scanner sc;

        try {
            sc = new Scanner(new BufferedReader(new FileReader(PROD_FILE)));
        } catch (FileNotFoundException e) {

            throw new VMPersistenceException(
                    "Failed to load data.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {

            currentLine = sc.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            Products currentProduct = new Products(currentTokens[0]);

            currentProduct.setProductPrice(new BigDecimal(currentTokens[1]));

            currentProduct.setNumberOfProducts(Integer.parseInt(currentTokens[2]));

            products.put(currentProduct.getProductName(), currentProduct);
        }

        sc.close();

    }

    private void writeProductsLibrary() throws VMPersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(PROD_FILE));
        } catch (IOException e) {
            throw new VMPersistenceException(
                    "Could not save data.", e);
        }

        List<Products> productList = this.getAllProducts();

        for (Products currentProduct : productList) {

            out.println(currentProduct.getProductName() + DELIMITER
                    + currentProduct.getProductPrice() + DELIMITER
                    + currentProduct.getNumOfProductsStocked());

            out.flush();
        }

        out.close();
    }
}
