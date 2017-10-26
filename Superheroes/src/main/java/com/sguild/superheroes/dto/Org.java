/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.superheroes.dto;

import java.util.List;
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
public class Org {
    
    private int orgid;
    private String orgName;
    private String orgDesc;
    private List<Hero> heroes;

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setOrgs(List<Hero> heroes) {
        this.heroes = heroes;
    }
}
