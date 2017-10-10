/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tradewar.dao;

import com.sg.tradewar.dto.Card;
import java.util.List;
import java.util.Set;

public interface IndexDao {

    Card addCard(Card card);
    Card deleteCard(Card card);
    Card getCardByNumber(int cardNum);
    List<Card> getCardsByType(String type);
    List<Card> getAllCards();
    Set<Integer> getAllCardNums();
    void readData() throws TradeWarPersistenceException;
//    void writeData() throws TradeWarPersistenceException;
}
