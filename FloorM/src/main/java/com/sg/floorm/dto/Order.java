/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Order {

    private String orderDate;
    private int orderNum;
    private String client;
    private String state;
    private BigDecimal taxRate;
    private String productType;
    private BigDecimal area;
    private BigDecimal costSqFt;
    private BigDecimal laborCostSqFt;
    private BigDecimal matCost;
    private BigDecimal labCost;
    private BigDecimal tTax;
    private BigDecimal tCost;
    public Order(int orderNum) {
        
        this.orderNum = orderNum;

    }

    public Order() {
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getState() {
        return state;
    }

    public void setTaxRate(String state) {
        this.state = state;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getCostSqFt() {
        return costSqFt;
    }

    public void setCostSqFt(BigDecimal costSqFt) {
        this.costSqFt = costSqFt;
    }

    public BigDecimal getLaborCostSqFt() {
        return laborCostSqFt;
    }

    public void setLaborCostSqFt(BigDecimal laborCostSqFt) {
        this.laborCostSqFt = laborCostSqFt;
    }

    public BigDecimal getMatCost() {
        return matCost;
    }

    public void setMatCost(BigDecimal matCost) {
        this.matCost = matCost;
    }

    public BigDecimal getLabCost() {
        return labCost;
    }

    public void setLabCost(BigDecimal labCost) {
        this.labCost = labCost;
    }

    public BigDecimal gettTax() {
        return tTax;
    }

    public void settTax(BigDecimal tTax) {
        this.tTax = tTax;
    }

    public BigDecimal gettCost() {
        return tCost;
    }

    public void settCost(BigDecimal tCost) {
        this.tCost = tCost;
    }

    @Override
    public String toString() {
        return "Order: " + orderNum;
    }

    @Override

    public int hashCode() {

        int hash = 8;
        hash = 71 * hash + Objects.hashCode(this.orderDate);
        hash = 71 * hash + this.orderNum;
        hash = 71 * hash + Objects.hashCode(this.client);
        hash = 71 * hash + Objects.hashCode(this.state);
        hash = 71 * hash + Objects.hashCode(this.taxRate);
        hash = 71 * hash + Objects.hashCode(this.productType);
        hash = 71 * hash + Objects.hashCode(this.area);
        hash = 71 * hash + Objects.hashCode(this.costSqFt);
        hash = 71 * hash + Objects.hashCode(this.laborCostSqFt);
        hash = 71 * hash + Objects.hashCode(this.matCost);
        hash = 71 * hash + Objects.hashCode(this.labCost);
        hash = 71 * hash + Objects.hashCode(this.tTax);
        hash = 71 * hash + Objects.hashCode(this.tCost);
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
        final Order other = (Order) obj;
        if (this.orderNum != other.orderNum) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        if (!Objects.equals(this.client, other.client)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.productType, other.productType)) {
            return false;
        }
        if (!Objects.equals(this.taxRate, other.taxRate)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.costSqFt, other.costSqFt)) {
            return false;
        }
        if (!Objects.equals(this.laborCostSqFt, other.laborCostSqFt)) {
            return false;
        }
        if (!Objects.equals(this.matCost, other.matCost)) {
            return false;
        }
        if (!Objects.equals(this.labCost, other.labCost)) {
            return false;
        }
        if (!Objects.equals(this.tTax, other.tTax)) {
            return false;
        }
        return Objects.equals(this.tCost, other.tCost);
    }

}
