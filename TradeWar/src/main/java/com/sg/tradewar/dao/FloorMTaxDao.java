/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tradewar.dao;

import com.sg.tradewar.dto.TaxRate;
import java.util.List;

public interface FloorMTaxDao {

    TaxRate addTaxRate(TaxRate taxRate);
    TaxRate removeTaxRate(TaxRate taxRate);
    TaxRate editTaxRate(TaxRate taxRateOld, TaxRate taxRateNew);
    TaxRate getTaxRate(String name);
    
    List<TaxRate> getAllTaxRates();
   
    void readTData() throws TradeWarPersistenceException;

}
