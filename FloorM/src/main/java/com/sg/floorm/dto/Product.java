/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private String productType;
    private BigDecimal materialSqFootCost;
    private BigDecimal laborSqFootCost;
    
    public Product(String productType, BigDecimal materialSqFootCost, BigDecimal laborSqFootCost) {
        this.productType = productType;
        this.materialSqFootCost = materialSqFootCost;
        this.laborSqFootCost = laborSqFootCost;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getMaterialSqFootCost() {
        return materialSqFootCost;
    }

    public void setMaterialSqFootCost(BigDecimal materialSqFootCost) {
        this.materialSqFootCost = materialSqFootCost;
    }

    public BigDecimal getLaborSqFootCost() {
        return laborSqFootCost;
    }

    public void setLaborSqFootCost(BigDecimal laborSqFootCost) {
        this.laborSqFootCost = laborSqFootCost;
    }

    @Override

    public int hashCode() {

        int hash = 4;
        hash = 12 * hash + Objects.hashCode(this.productType);
        hash = 12 * hash + Objects.hashCode(this.materialSqFootCost);
        hash = 12 * hash + Objects.hashCode(this.laborSqFootCost);
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.productType, other.productType)) {
            return false;
        }
        if (!Objects.equals(this.materialSqFootCost, other.materialSqFootCost)) {
            return false;
        }
        if (!Objects.equals(this.laborSqFootCost, other.laborSqFootCost)) {
            return false;
        }
        return true;
    }
}
