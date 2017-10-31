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

// Wanna use some lombok? https://projectlombok.org/features/all
// Make sure you update your pom and download your dependencies!

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
public class Loc {
    
    public int locid;
    public String locName;
    private String locDesc;
    private String locAddress;
    private String locLat;
    private String locLong;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.locid;
        hash = 29 * hash + Objects.hashCode(this.locName);
        hash = 29 * hash + Objects.hashCode(this.locDesc);
        hash = 29 * hash + Objects.hashCode(this.locAddress);
        hash = 29 * hash + Objects.hashCode(this.locLat);
        hash = 29 * hash + Objects.hashCode(this.locLong);
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
        final Loc other = (Loc) obj;
        if (this.locid != other.locid) {
            return false;
        }
        if (!Objects.equals(this.locName, other.locName)) {
            return false;
        }
        if (!Objects.equals(this.locDesc, other.locDesc)) {
            return false;
        }
        if (!Objects.equals(this.locAddress, other.locAddress)) {
            return false;
        }
        if (!Objects.equals(this.locLat, other.locLat)) {
            return false;
        }
        if (!Objects.equals(this.locLong, other.locLong)) {
            return false;
        }
        return true;
    }



    

   

}
