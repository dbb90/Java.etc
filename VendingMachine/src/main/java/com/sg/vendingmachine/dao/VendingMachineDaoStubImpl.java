/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
	package com.sg.vendingmachine.dao;
 	
 	import com.sg.vendingmachine.dto.Product;
 	import java.math.BigDecimal;
 	import java.util.ArrayList;
 	import java.util.List;
 	
 	/**
 	 *
 	 * @author dbb09
 	 */
 	public class VendingMachineDaoStubImpl implements VendingMachineDao {
 	    
 	    private Product product;
 	    private List<Product> listMaster = new ArrayList<>();
 	    
 	    public VendingMachineDaoStubImpl () {
 	        this.product = new Product("Dr Pepper");
 	        product.setProductPrice(new BigDecimal("2.00"));
 	        product.setNumberOfProducts(100);
 	        
 	        this.listMaster.add(product);
 	    }
 	    @Override
 	    public Product addProduct(String productName, Product product) throws VMPersistenceException {
 	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 	    }
 	
 	    @Override
 	    public List<Product> getAllProducts() throws VMPersistenceException {
 	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 	    }
 	
 	    @Override
 	    public Product getProduct(String productName) throws VMPersistenceException {
 	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 	    }
 	
 	    @Override
 	    public Product removeProduct(String productName) throws VMPersistenceException {
 	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 	    }
 	
 	    @Override
 	    public void editProduct(String productName, Product product) throws VMPersistenceException {
 	        listMaster.remove(productName);
 	        listMaster.add(product);
 	    }
 	
 	
 	}