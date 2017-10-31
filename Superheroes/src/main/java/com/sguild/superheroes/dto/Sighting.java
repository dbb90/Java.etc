/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.superheroes.dto;

import java.sql.Date;
import java.util.List;
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
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sighting {
    
    private int sightingid;
    public int sightinglocid;
    public Date dateSighted;
    public List<Hero> heroes;
    public String loc;

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.sightingid;
        hash = 13 * hash + this.sightinglocid;
        hash = 13 * hash + Objects.hashCode(this.dateSighted);
        hash = 13 * hash + Objects.hashCode(this.heroes);
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
        final Sighting other = (Sighting) obj;
        if (this.sightingid != other.sightingid) {
            return false;
        }
        if (this.sightinglocid != other.sightinglocid) {
            return false;
        }
        if (!Objects.equals(this.dateSighted, other.dateSighted)) {
            return false;
        }
        if (!Objects.equals(this.heroes, other.heroes)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
