/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tradewar.service;

import com.sg.tradewar.dao.TradeWarPersistenceException;
import com.sg.tradewar.dto.Card;
import java.util.List;

public interface FloorMServiceLayer {

    Card addCard(Card card);

    Card getCard(int cardNum);


    List<Card> getCardsByType(String type);

    List<Card> getAllCards();

    void readAllData() throws TradeWarPersistenceException;
//
//    void writeAllData() throws TradeWarPersistenceException;
//
//    Card calcCosts(Card order) throws InvalidTaxRateException, InvalidProductException;
//
//    Card deleteOrder(Card order, String date, int orderNum);
//
//    List<TaxRate> getAllTaxRates();
//
//    List<Spell> getAllProducts();
//
//    void readConfig() throws TradeWarPersistenceException;
//
//    String getConfig();

}
