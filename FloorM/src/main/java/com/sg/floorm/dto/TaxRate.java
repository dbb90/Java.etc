/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.dto;

import java.math.BigDecimal;
import java.util.Objects;


public class TaxRate {
    
    private String name;
    private BigDecimal tax;
    
    public TaxRate(String name, BigDecimal tax) {
        this.name = name;
        this.tax = tax;
    }
    
    public String getClientName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }
    @Override
    public int hashCode() {
        int hash = 6;
        hash = 32 * hash + Objects.hashCode(this.name);
        hash = 32 * hash + Objects.hashCode(this.tax);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaxRate other = (TaxRate) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.tax, other.tax)) {
            return false;
        }
        return true;
    }
}
