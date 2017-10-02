/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.dao;

import com.sg.floorm.dto.Order;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FloorMOrderDaoStubImpl implements FloorMOrderDao {
    
    private Order stubOrder;
    Map<Integer , Order> orders = new HashMap<>();
    
    public FloorMOrderDaoStubImpl() { 
        int orderNum = 1;
        stubOrder = new Order(orderNum);
        stubOrder.setOrderDate("20170101");
        stubOrder.setClient("David");
        stubOrder.setTaxState("KY");
        stubOrder.setTaxRate(new BigDecimal("1.10"));
        stubOrder.setProductType("Argesium");
        stubOrder.setArea(new BigDecimal("10.00"));
        stubOrder.setCostSqFt(new BigDecimal("1.00"));
        stubOrder.setLaborCostSqFt(new BigDecimal("2.00"));
        stubOrder.setMatCost(new BigDecimal("300.00"));
        stubOrder.setLabCost(new BigDecimal("400.00"));
        stubOrder.settTax(new BigDecimal("30.00"));
        stubOrder.settCost(new BigDecimal("600.00"));
    }
    
    @Override
    public Order addOrder(Order order) {
        if (!order.equals(stubOrder)) {
            return stubOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order deleteOrder(Order order) {
        if (order.equals(stubOrder)) {
            return stubOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order editOrder(Order oldOrder, Order newOrder) {
        
        if (oldOrder.equals(stubOrder)) {
            return newOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order getOrderByNumber(int orderNum) {
        
        if(orderNum == stubOrder.getOrderNum()) {
            return stubOrder;
        } else {
            return null;
        }
    }

    @Override
    public List<Order> getOrdersByDate(String date) {
        
        List<Order> orderList = new ArrayList(orders.values());
        List<Order> ordersDate = new ArrayList<>();
        for (Order currentOrder : orderList) {
            if(currentOrder.getOrderDate().equals(date)) {
                ordersDate.add(currentOrder);
            }
        }
        return ordersDate;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orderList = new ArrayList(orders.values());
        return orderList;
    }

    @Override
    public Set<Integer> getAllOrderNums() {
        Set<Integer> keys = orders.keySet();
        return keys;
    }

    @Override
    public void readOData() throws FloorMPersistenceException {

    }

    @Override
    public void writeOData() throws FloorMPersistenceException {

    }


}
