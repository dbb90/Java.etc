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
    private BigDecimal materialSqFtCost;
    private BigDecimal laborSqFtCost;
    
    public Product(String productType, BigDecimal materialSqFtCost, BigDecimal laborSqFtCost) {
        this.productType = productType;
        this.materialSqFtCost = materialSqFtCost;
        this.laborSqFtCost = laborSqFtCost;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getMaterialSqFtCost() {
        return materialSqFtCost;
    }

    public void setMaterialSqFtCost(BigDecimal materialSqFtCost) {
        this.materialSqFtCost = materialSqFtCost;
    }

    public BigDecimal getLaborSqFtCost() {
        return laborSqFtCost;
    }

    public void setLaborSqFtCost(BigDecimal laborSqFtCost) {
        this.laborSqFtCost = laborSqFtCost;
    }

    @Override

    public int hashCode() {

        int hash = 4;
        hash = 12 * hash + Objects.hashCode(this.productType);
        hash = 12 * hash + Objects.hashCode(this.materialSqFtCost);
        hash = 12 * hash + Objects.hashCode(this.laborSqFtCost);
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
        if (!Objects.equals(this.materialSqFtCost, other.materialSqFtCost)) {
            return false;
        }
        if (!Objects.equals(this.laborSqFtCost, other.laborSqFtCost)) {
            return false;
        }
        return true;
    }
}
