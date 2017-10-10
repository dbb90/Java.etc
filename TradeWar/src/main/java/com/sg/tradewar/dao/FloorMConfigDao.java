/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tradewar.dao;

public interface FloorMConfigDao {
   String getConfig();
   void readConfig() throws TradeWarPersistenceException;
}