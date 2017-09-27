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
        for (Order currentOrder : orderList) {
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
        List<Product> products = pDao.getAllProducts();

        List<TaxRate> states = tDao.getAllTaxRates();

        products.stream()
                .filter((product) -> (product.getProductType()
                .toUpperCase()
                .equals(order.getProductType())))
                .map((product) -> {
                    BigDecimal materialSqFtCost = product.getMaterialSqFtCost();

                    materialSqFtCost = materialSqFtCost.setScale(2, HALF_UP);
                    order.setCostSqFt(materialSqFtCost);

                    BigDecimal laborSqFtCost = product.getLaborSqFtCost();
                    return laborSqFtCost;
                })
                .map((laborSqFtCost) -> laborSqFtCost.setScale(2, HALF_UP)).map((laborSqFtCost) -> {
            order.setLaborCostSqFt(laborSqFtCost);
            return laborSqFtCost;
        })
                .map((matCost) -> order.getCostSqFt()
                .multiply(order.getArea()))
                .map((matCost) -> matCost.setScale(2, HALF_UP))
                .map((matCost) -> {
                    order.setMatCost(matCost);
                    return matCost;
                })
                .map((labCost) -> order.getLaborCostSqFt()
                .multiply(order.getArea()))
                .map((labCost) -> labCost.setScale(2, HALF_UP))
                .forEachOrdered((labCost) -> {
                    order.setLabCost(labCost);
                });

        states.stream()
                .filter((state) -> (state.getTaxStateName().equalsIgnoreCase(order.getState())))
                .forEachOrdered((state) -> {
                    order.setTaxRate(state.getTax());
                });

        BigDecimal tempTotal = order.getLabCost().add(order.getMatCost());
        tempTotal = tempTotal.setScale(2, HALF_UP);
        BigDecimal taxRate = order.getTaxRate().divide(new BigDecimal("100"));
        BigDecimal tTax = tempTotal.multiply(taxRate);
        tTax = tTax.setScale(2, HALF_UP);
        order.settTax(tTax);
        BigDecimal tCost = order.gettTax().add(tempTotal);
        tCost = tCost.setScale(2, HALF_UP);
        order.settCost(tCost);
        return order;
    }

    @Override
    public Order deleteOrder(Order order, String date, int orderNum) {
        List<Order> ordersByDate = this.getOrdersByDate(date);
        Order orderToDelete = new Order();
        for (Order currentOrder : ordersByDate) {
            if (currentOrder.getOrderNum() == orderNum) {
                orderToDelete = oDao.deleteOrder(order);
            }
        }
        return orderToDelete;
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
