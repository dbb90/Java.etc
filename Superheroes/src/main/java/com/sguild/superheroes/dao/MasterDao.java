/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.superheroes.dao;

import com.sguild.superheroes.dto.Hero;
import com.sguild.superheroes.dto.Loc;
import com.sguild.superheroes.dto.Org;
import com.sguild.superheroes.dto.Power;
import com.sguild.superheroes.dto.Sighting;
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

//   ____                _____              
//  / __ \              |  __ \             
// | |  | |_ __ __ _ ___| |  | | __ _  ___  
// | |  | | '__/ _` / __| |  | |/ _` |/ _ \ 
// | |__| | | | (_| \__ \ |__| | (_| | (_) |
//    ___/|_|  \__, |___/_____/ \__,_|\___/ 
//              __/ |                       
//             |___/                        
//
    // CRUD
    // CREATE
    public Org addOrg(Org orgToAdd);

    // READ
    public List<Org> getAllOrgs();

    public Org getOrg(int orgid);

    public List<Hero> getHeroesInOrg(Org orgToCheck);
    
    
    // UPDATE
    public void updateOrg(Org orgToUpdpate);

    // DELETE
    public Org removeOrg(Org orgToRemove);
    
    public void removeOrg(int orgid);
    
    public Org removeAndReturnOrg(int orgid);





//
//  _                _____              
// | |              |  __ \             
// | |     ___   ___| |  | | __ _  ___  
// | |    / _ \ / __| |  | |/ _` |/ _\ 
// | |___| (_) | (__| |__| | (_| | (_) |
// |______\___/ \___|_____/ \__,_|\___/ 
//                                      
//                                      

public Loc addLoc(Loc locToAdd);

public  List<Loc> getAllLocs();

public Loc getLoc(int locid);

public void updateLoc(Loc locToUpdate);

public Loc removeLcc(Loc locToRemove);

public void removeLoc(int locid);

public Loc removeAndReturnLoc(int locid);


//
//   _____ _       _     _   _             _____              
//  / ____(_)     | |   | | (_)           |  __ \             
// | (___  _  __ _| |__ | |_ _ _ __   __ _| |  | | __ _  ___  
//  \___ \| |/ _` | '_ \| __| | '_ \ / _` | |  | |/ _` |/ _ \ 
//  ____) | | (_| | | | | |_| | | | | (_| | |__| | (_| | (_) |
// |_____/|_|\__, |_| |_|\__|_|_| |_|\__, |_____/ \__,_|\___/ 
//            __/ |                   __/ |                   
//           |___/                   |___/                    
//

public Sighting addSighting(Sighting sightingToAdd);

public List<Sighting> getAllSightings();

public Sighting getSighting(int sightingid);

public void updateSighting(Loc locToUpdate);

public 









}