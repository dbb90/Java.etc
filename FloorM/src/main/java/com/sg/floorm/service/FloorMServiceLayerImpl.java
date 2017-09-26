/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.service;

import com.sg.floorm.dao.FloorMOrderDao;
import com.sg.floorm.dao.FloorMPersistenceException;
import com.sg.floorm.dao.FloorMProductDao;
import com.sg.floorm.dao.FloorMTaxDao;
import com.sg.floorm.dto.Order;
import com.sg.floorm.dto.Product;
import com.sg.floorm.dto.TaxRate;
import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import java.util.Iterator;
import java.util.List;


public class FloorMServiceLayerImpl implements FloorMServiceLayer {

    private final FloorMOrderDao oDao;
    private final FloorMProductDao pDao;
    private final FloorMTaxDao tDao;


    public FloorMServiceLayerImpl(FloorMOrderDao orderDao,
            FloorMProductDao productDao, FloorMTaxDao taxDao) {

        this.oDao = orderDao;
        this.pDao = productDao;
        this.tDao = taxDao;
    }

    @Override

    public Order addOrder(Order order) {
        return oDao.addOrder(order);
    }

    @Override
    public List<Order> getOrdersByDate(String date) {
        return oDao.getOrdersByDate(date);
    }

    @Override
    public Order getOrder(int orderNum) {
        return oDao.getOrderByNumber(orderNum);
    }

    @Override
    public void readAllData() throws FloorMPersistenceException {

        oDao.readOData();
        pDao.readPData();
        tDao.readTData();
    }

    @Override
    public void writeAllData() throws FloorMPersistenceException {
        oDao.writeOData();
    }
    
    @Override
    public Order calcOrderNum(Order orderToAdd) {
        List<Order> orderList = oDao.getAllOrders();
        int orderNumMax = 0;
        for (Iterator<Order> it = orderList.iterator(); it.hasNext();) {
            Order currentOrder = it.next();
            if (currentOrder.getOrderNum() > orderNumMax) {
                orderNumMax = currentOrder.getOrderNum();
            }
        }
        int orderNumQueued = orderNumMax + 1;
        orderToAdd.setOrderNum(orderNumQueued);
        return orderToAdd;
    }
    
    @Override
    public Order calcCosts(Order order) {
        List<Product> productList = pDao.getAllProducts();
        List<TaxRate> taxRates = tDao.getAllTaxRates();
        productList.stream().filter((product) -> 
                (product.getProductType().equalsIgnoreCase(order.getProductType()))).map((product) -> 
                
                {
            BigDecimal materialSqFootCost = product.getMaterialSqFtCost();
            materialSqFootCost = materialSqFootCost.setScale(2, HALF_UP);
            order.setCostSqFt(materialSqFootCost);
            BigDecimal laborSqFootCost = product.getLaborSqFtCost();
            return laborSqFootCost;
        }).map((laborSqFootCost) -> 
                laborSqFootCost.setScale(2, HALF_UP)).map((laborSqFootCost) -> 
                {
            order.setLaborCostSqFt(laborSqFootCost);
            return laborSqFootCost;
        }).map((_item) -> order.getCostSqFt().multiply(order.getArea())).map((materialCost) -> 
                materialCost.setScale(2, HALF_UP)).map((materialCost) -> {
            order.setMatCost(materialCost);
            return materialCost;
        }).map((_item) -> order.getLaborCostSqFt().multiply(order.getArea())).map((laborCost) -> 
                laborCost.setScale(2, HALF_UP)).forEachOrdered((laborCost) -> {
            order.setLabCost(laborCost);
        });
        
        taxRates.stream().filter((state) -> 
                (state.getTaxStateName().equalsIgnoreCase(order.getState()))).forEachOrdered((state) -> {
            order.setTaxRate(state.getTax());
        });
        
        BigDecimal tempTotal = order.getLabCost().add(order.getMatCost());
        tempTotal = tempTotal.setScale(2, HALF_UP);
        BigDecimal taxRate = order.getTaxRate().divide(new BigDecimal("100"));
        
        BigDecimal totalTax = tempTotal.multiply(taxRate);
        totalTax = totalTax.setScale(2, HALF_UP);
        order.settTax(totalTax);
        
        BigDecimal totalCost = order.gettTax().add(tempTotal);
        totalCost = totalCost.setScale(2, HALF_UP);
        order.settCost(totalCost);
        
        return order;
    }
    @Override
    public Order deleteOrder(Order order, String date, int orderNum) {
        List<Order> ordersByDate = this.getOrdersByDate(date);
        Order orderToRemove = new Order();
        for (Iterator<Order> it = ordersByDate.iterator(); it.hasNext();) {
            Order currentOrder = it.next();
            if (currentOrder.getOrderNum() == orderNum) {
                orderToRemove = oDao.deleteOrder(order);
            }
        }
        return orderToRemove;
    }

    @Override

    public List<TaxRate> getAllTaxRates() {
        List<TaxRate> states = tDao.getAllTaxRates();
        return states;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = pDao.getAllProducts();
        return products;

    }



    @Override
    public List<Order> getAllOrders() {
        return oDao.getAllOrders();
    }

}
