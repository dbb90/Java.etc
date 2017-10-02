/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.service;

import com.sg.floorm.dao.FloorMConfigDao;
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
    private final FloorMConfigDao cDao;

    public FloorMServiceLayerImpl(FloorMOrderDao orderDao,
            FloorMProductDao productDao, FloorMTaxDao taxDao, FloorMConfigDao configDao) {

        this.oDao = orderDao;
        this.pDao = productDao;
        this.tDao = taxDao;
        this.cDao = configDao;
    }

    @Override

    public Order addOrder(Order order) throws InvalidProductException, InvalidTaxRateException {
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
    public Order calcCosts(Order order) throws InvalidTaxRateException {

       List<Product> productList = pDao.getAllProducts();
       List<TaxRate> taxStatelist = tDao.getAllTaxRates();

       for (Product product : productList) {

           if (product.getProductType().equalsIgnoreCase(order.getProductType())){
               BigDecimal materialSqFootCost = product.getMaterialSqFtCost();
               materialSqFootCost = materialSqFootCost.setScale(2 , HALF_UP);
               order.setCostSqFt(materialSqFootCost);
               BigDecimal laborSqFootCost = product.getLaborSqFtCost();

               laborSqFootCost = laborSqFootCost.setScale(2, HALF_UP);

               order.setLaborCostSqFt(laborSqFootCost);
               BigDecimal matCost = order.getCostSqFt().multiply(order.getArea());

               matCost = matCost.setScale(2 , HALF_UP);

               order.setMatCost(matCost);

               

               BigDecimal labCost = order.getLaborCostSqFt().multiply(order.getArea());
               labCost = labCost.setScale(2 , HALF_UP);

               order.setLabCost(labCost);

           }
       }

       for (TaxRate taxState : taxStatelist) {
           if (taxState.getTaxStateName().equalsIgnoreCase(order.getState())){
               order.setTaxRate(taxState.getTax());

           }

       }

       BigDecimal tempTotal = order.getLabCost().add(order.getMatCost());
       tempTotal = tempTotal.setScale(2 , HALF_UP);
       BigDecimal taxRate = order.getTaxRate().divide(new BigDecimal("100"));
       BigDecimal tTax = tempTotal.multiply(taxRate);
       tTax = tTax.setScale(2 , HALF_UP);
       order.settTax(tTax);

       BigDecimal tCost = order.gettTax().add(tempTotal);
       tCost = tCost.setScale(2 , HALF_UP);
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

    public List<TaxRate> getAllTaxRates() throws InvalidTaxRateException {
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

    @Override
    public Order revertTempOrder(Order orderOrigin, Order orderToEdit) throws InvalidProductException, InvalidTaxRateException {
       return oDao.revertTempOrder(orderOrigin, orderToEdit);
    }

    @Override
   public void readConfig() throws FloorMPersistenceException {
       cDao.readConfig();
   }

 

   @Override
   public String getConfig() {
       return cDao.getConfig();
   }
    
    
    
    
}
