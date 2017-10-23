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
public interface MasterDao {
    
//    _    _                          _____              
//   | |  | |                        |  __ \             
//   | |__| | ___ _ __ ___   ___  ___| |  | | __ _  ___  
//   |  __  |/ _ \ '__/ _ \ / _ \/ __| |  | |/ _` |/ _ \ 
//   | |  | |  __/ | | (_) |  __/\__ \ |__| | (_| | (_) |
//   |_|  |_|\___|_|  \___/ \___||___/_____/ \__,_|\___/ 
//                                                       
//                                                       

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

    
    
//    _____                           _____              
//   |  __ \                         |  __ \             
//   | |__) |____      _____ _ __ ___| |  | | __ _  ___  
//   |  ___/ _ \ \ /\ / / _ \ '__/ __| |  | |/ _` |/ _ \ 
//   | |  | (_) \ V  V /  __/ |  \__ \ |__| | (_| | (_) |
//   |_|   \___/ \_/\_/ \___|_|  |___/_____/ \__,_|\___/ 
//                                                       
//                                                       
    
    
        
    // CRUD
    
    // CREATE
    public Power addPower(Power powerToAdd);
    
    // READ
    public List<Power> getAllPowers();
    public Power getPower(int powerid);
    
    // UPDATE
    public void updatePower(Power powerToUpdate);
    
    // DELETE
    public Power removePower(Power powerToRemove);
    public void removePower(int powerid);
    public Power removeAndReturnPower(int powerid);
    
    


    
}
