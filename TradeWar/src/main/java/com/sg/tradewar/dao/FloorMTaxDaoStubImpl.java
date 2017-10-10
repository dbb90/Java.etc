/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tradewar.dao;

import com.sg.tradewar.dto.TaxRate;
import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import java.util.ArrayList;
import java.util.List;

public class FloorMTaxDaoStubImpl implements FloorMTaxDao {

    TaxRate stubTaxState;
    List<TaxRate> taxStates = new ArrayList<>();

    public FloorMTaxDaoStubImpl() {
        String taxState = "KY";
        BigDecimal taxRate = new BigDecimal("2.00");
        taxRate = taxRate.setScale(2, HALF_UP);
        stubTaxState = new TaxRate(taxState, taxRate);

        taxStates.add(stubTaxState);
    }

    @Override
    public TaxRate addTaxRate(TaxRate taxRate) {
        if (!taxRate.equals(stubTaxState)) {
            return taxRate;
        } else {
            return null;
        }
    }

    @Override
    public TaxRate removeTaxRate(TaxRate taxRate) {
        if (taxRate.equals(stubTaxState)) {
            return taxRate;
        } else {
            return null;
        }
    }

    @Override
    public TaxRate editTaxRate(TaxRate taxRateOld, TaxRate taxRateNew) {
        if (taxRateOld.equals(stubTaxState)) {
            return taxRateNew;
        } else {
            return null;
        }
    }

    @Override
    public TaxRate getTaxRate(String name) {
        if (name.equals(stubTaxState.getTaxStateName())) {
            return stubTaxState;
        } else {
            return null;
        }
    }

    @Override
    public List<TaxRate> getAllTaxRates() {
        List<TaxRate> stubTaxRates = new ArrayList<>();
        stubTaxRates.add(stubTaxState);
        return stubTaxRates;
    }

    @Override
    public void readTData() throws TradeWarPersistenceException {

    }

}
