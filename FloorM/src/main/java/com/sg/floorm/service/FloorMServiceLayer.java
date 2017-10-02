/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.service;

import com.sg.floorm.dao.FloorMPersistenceException;
import com.sg.floorm.dto.Order;
import com.sg.floorm.dto.Product;
import com.sg.floorm.dto.TaxRate;
import java.util.List;


public interface FloorMServiceLayer {

    Order addOrder(Order order);
    Order getOrder(int orderNum);
    Order calcOrderNum(Order orderToAdd);
    List<Order> getOrdersByDate(String date);
    void readAllData() throws FloorMPersistenceException;
    void writeAllData() throws FloorMPersistenceException;
    Order calcCosts(Order order) throws InvalidTaxRateException, InvalidProductException;
    Order deleteOrder(Order order, String date, int orderNum);
    List<TaxRate> getAllTaxRates();
    List<Product> getAllProducts();
    List<Order> getAllOrders();
    void readConfig() throws FloorMPersistenceException;
    String getConfig();

}
