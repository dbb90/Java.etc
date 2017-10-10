/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tradewar.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Card {

    private String cardName;
    private int cardNum;
    private int rarity;
    private String type;
    private String description;
    private String flavorText;
    private BigDecimal baseValue;
    private BigDecimal elasticityFactor;
    
    public Card(int cardNum) {
        
        this.cardNum = cardNum;

    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }
    
//    public void setStringRarity(String stringRarity) {
//        Stri;
//    
//    }
//    

    public BigDecimal getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(BigDecimal baseValue) {
        this.baseValue = baseValue;
    }

    public BigDecimal getElasticityFactor() {
        return elasticityFactor;
    }

    public void setElasticityFactor(BigDecimal elasticityFactor) {
        this.elasticityFactor = elasticityFactor;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

   

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Card() {
    }



    @Override
    public String toString() {
        return "Card: " + cardNum + " - " + cardName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.cardName);
        hash = 89 * hash + this.cardNum;
        hash = 89 * hash + this.rarity;
        hash = 89 * hash + Objects.hashCode(this.type);
        hash = 89 * hash + Objects.hashCode(this.description);
        hash = 89 * hash + Objects.hashCode(this.flavorText);
        hash = 89 * hash + Objects.hashCode(this.baseValue);
        hash = 89 * hash + Objects.hashCode(this.elasticityFactor);
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
        final Card other = (Card) obj;
        if (this.cardNum != other.cardNum) {
            return false;
        }
        if (this.rarity != other.rarity) {
            return false;
        }
        if (!Objects.equals(this.cardName, other.cardName)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.flavorText, other.flavorText)) {
            return false;
        }
        if (!Objects.equals(this.baseValue, other.baseValue)) {
            return false;
        }
        if (!Objects.equals(this.elasticityFactor, other.elasticityFactor)) {
            return false;
        }
        return true;
    }

  
}

 