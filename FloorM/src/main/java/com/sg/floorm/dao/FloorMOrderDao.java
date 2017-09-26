/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.dao;

import com.sg.floorm.dto.Order;
import java.util.List;
import java.util.Set;

public interface FloorMOrderDao {

    Order addOrder(Order order);
    Order deleteOrder(Order order);
    Order editOrder(Order oldOrder, Order newOrder);
    Order getOrderByNumber(int orderNum);
    List<Order> getOrdersByDate(String date);
    List<Order> getAllOrders();
    Set<Integer> getAllOrderNums();
    void readOData() throws FloorMPersistenceException;
    void writeOData() throws FloorMPersistenceException;
}
