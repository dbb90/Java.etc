/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tradewar.service;

import com.sg.tradewar.dao.TradeWarPersistenceException;
import com.sg.tradewar.dao.IndexDao;
import com.sg.tradewar.dto.Card;
import java.util.List;

public class FloorMServiceLayerImpl implements FloorMServiceLayer {

    private IndexDao oDao;


    public FloorMServiceLayerImpl(IndexDao indexDao) {

        this.oDao = indexDao;
    }

    @Override

    public Card addCard(Card card) {
        return oDao.addCard(card);
    }

    @Override
    public List<Card> getCardsByType(String type) {
        return oDao.getCardsByType(type);
    }

    @Override
    public Card getCard(int cardNum) {
        return oDao.getCardByNumber(cardNum);
    }
    
  
    @Override
    public void readAllData() throws TradeWarPersistenceException {

        oDao.readData();
    }

    @Override
    public List<Card> getAllCards() {
        return oDao.getAllCards();
    }}

//    @Override
//    public void writeAllData() throws TradeWarPersistenceException {
//        oDao.writeOData();
//    }
//
//    @Override
//    public Card calcOrderNum(Card orderToAdd) {
//        List<Card> orderList = oDao.getAllOrders();
//        int orderNumMax = 0;
//        for (Card currentOrder : orderList) {
//            if (currentOrder.getOrderNum() > orderNumMax) {
//                orderNumMax = currentOrder.getOrderNum();
//            }
//        }
//        int orderNumQueued = orderNumMax + 1;
//        orderToAdd.setOrderNum(orderNumQueued);
//        return orderToAdd;
//    }
//
//    @Override
//    public Card calcCosts(Card order) throws InvalidTaxRateException, InvalidProductException {
//
//       List<Spell> productList = pDao.getAllProducts();
//       List<TaxRate> taxStatelist = tDao.getAllTaxRates();
//
//       for (Spell product : productList) {
//
//           if (product.getProductType().equalsIgnoreCase(order.getProductType())){
//               BigDecimal materialSqFootCost = product.getMaterialSqFtCost();
//               materialSqFootCost = materialSqFootCost.setScale(2 , HALF_UP);
//               order.setCostSqFt(materialSqFootCost);
//               BigDecimal laborSqFootCost = product.getLaborSqFtCost();
//
//               laborSqFootCost = laborSqFootCost.setScale(2, HALF_UP);
//
//               order.setLaborCostSqFt(laborSqFootCost);
//               BigDecimal matCost = order.getCostSqFt().multiply(order.getArea());
//
//               matCost = matCost.setScale(2 , HALF_UP);
//
//               order.setMatCost(matCost);
//
//               
//
//               BigDecimal labCost = order.getLaborCostSqFt().multiply(order.getArea());
//               labCost = labCost.setScale(2 , HALF_UP);
//
//               order.setLabCost(labCost);
//
//           }
//       }
//
//       for (TaxRate taxState : taxStatelist) {
//           if (taxState.getTaxStateName().equalsIgnoreCase(order.getState())){
//               order.setTaxRate(taxState.getTax());
//
//           }
//
//       }
//
//       BigDecimal tempTotal = order.getLabCost().add(order.getMatCost());
//       tempTotal = tempTotal.setScale(2 , HALF_UP);
//       BigDecimal taxRate = order.getTaxRate().divide(new BigDecimal("100"));
//       BigDecimal tTax = tempTotal.multiply(taxRate);
//       tTax = tTax.setScale(2 , HALF_UP);
//       order.settTax(tTax);
//
//       BigDecimal tCost = order.gettTax().add(tempTotal);
//       tCost = tCost.setScale(2 , HALF_UP);
//       order.settCost(tCost);
//       return order;
//   }
//
//    @Override
//    public Card deleteOrder(Card order, String date, int orderNum) {
//        List<Card> ordersByDate = this.getOrdersByDate(date);
//        Card orderToDelete = new Card();
//        for (Card currentOrder : ordersByDate) {
//            if (currentOrder.getOrderNum() == orderNum) {
//                orderToDelete = oDao.deleteOrder(order);
//            }
//        }
//        return orderToDelete;
//    }
//
//    @Override
//
//    public List<TaxRate> getAllTaxRates() {
//        List<TaxRate> states = tDao.getAllTaxRates();
//        return states;
//    }
//
//    @Override
//    public List<Spell> getAllProducts() {
//        List<Spell> products = pDao.getAllProducts();
//        return products;
//
//    }
//


//
//    @Override
//   public void readConfig() throws TradeWarPersistenceException {
//       cDao.readConfig();
//   }
//
// 
//
//   @Override
//   public String getConfig() {
//       return cDao.getConfig();
//   }
//    
//    
//    
//    
//}
