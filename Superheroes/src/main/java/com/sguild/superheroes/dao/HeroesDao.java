/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.superheroes.dao;

import com.sguild.superheroes.dto.Hero;
import com.sguild.superheroes.dto.Power;
import java.util.List;

/**
 *
 * @author dbb09
 */
public interface HeroesDao {

    // CRUD
    // CREATE
    public Hero addHero(Hero heroToAdd);

    // READ
    public List<Hero> getAllHeroes();

    public Hero getHero(int heroid);

    public List<Power> getPowersOfHero(Hero heroToCheck);

    // UPDATE
    public void updateHero(Hero heroToUpdate);

    // DELETE
    public Hero removeHero(Hero heroToRemove);

    public void removeHero(int heroid);

    public Hero removeAndReturnHero(int heroid);

}
