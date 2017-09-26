/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.dao;

import com.sg.floorm.dto.TaxRate;
import java.util.List;

public interface FloorMTaxDao {

    TaxRate addTaxRate(TaxRate state);
    TaxRate removeTaxRate(TaxRate state);
    TaxRate editState(TaxRate oldState, TaxRate newState);
    TaxRate getTaxRate(String name);
    
    List<TaxRate> getAllTaxRates();
   
    void readTData() throws FloorMPersistenceException;

}
