/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.superheroes.dto;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author dbb09
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Power {

    private int powerid;
    private String powerName;
    private String powerDesc;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.powerid;
        hash = 23 * hash + Objects.hashCode(this.powerName);
        hash = 23 * hash + Objects.hashCode(this.powerDesc);
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
        final Power other = (Power) obj;
        if (this.powerid != other.powerid) {
            return false;
        }
        if (!Objects.equals(this.powerName, other.powerName)) {
            return false;
        }
        if (!Objects.equals(this.powerDesc, other.powerDesc)) {
            return false;
        }
        return true;
    }

}
