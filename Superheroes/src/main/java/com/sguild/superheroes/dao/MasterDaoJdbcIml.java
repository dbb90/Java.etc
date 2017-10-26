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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dbb09
 */
public class MasterDaoJdbcIml implements MasterDao {

    private JdbcTemplate jdbcTemplate;

    @Inject
    public MasterDaoJdbcIml(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    
//    _    _                          _____              
//   | |  | |                        |  __ \             
//   | |__| | ___ _ __ ___   ___  ___| |  | | __ _  ___  
//   |  __  |/ _ \ '__/ _ \ / _ \/ __| |  | |/ _` |/ _ \ 
//   | |  | |  __/ | | (_) |  __/\__ \ |__| | (_| | (_) |
//   |_|  |_|\___|_|  \___/ \___||___/_____/ \__,_|\___/ 
//                                                       
//   
    
    
    private static final String SQL_ADD_HERO
            = "INSERT INTO Heroes (heroname, herodesc, villain)"
            //            + " VALUES('Dont Starve', 'PC', 'Fantasyish Survival', 'Klei', 11)";
            + " VALUES(?, ?, ?)";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Hero addHero(Hero heroToAdd) {

        // First do the insert
        jdbcTemplate.update(SQL_ADD_HERO,
                heroToAdd.getHeroName(),
                heroToAdd.getHeroDesc(),
                heroToAdd.getVillain());

        // Then get the id
        int myId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        // Then stuff it in the object
        heroToAdd.setHeroid(myId);
        return heroToAdd;
    }

    private static final String SQL_GET_ALL_HEROES = "SELECT * FROM Heroes";

    @Override
    public List<Hero> getAllHeroes() {

        List<Hero> theDatabaseHeroes
                = jdbcTemplate.query(SQL_GET_ALL_HEROES, new HeroMapper());
        return theDatabaseHeroes;

    }

    private static final String SQL_GET_HERO_BY_HEROID = "SELECT * FROM Heroes WHERE heroid = ?";

    @Override
    public Hero getHero(int heroid) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_HERO_BY_HEROID, new HeroMapper(), heroid);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private static final String SQL_UPDATE_HERO
            = "update heroes set heroname = ?, herodesc = ?, villain = ? where heroid =  ?";

    @Override
    public void updateHero(Hero heroToUpdate) {
        jdbcTemplate.update(SQL_UPDATE_HERO,
                heroToUpdate.getHeroName(),
                heroToUpdate.getHeroDesc(),
                heroToUpdate.getVillain(),
                heroToUpdate.getHeroid());
    }

    private static final String SQL_DELETE_HERO_BY_NAME
            = "delete from heroes where heroname = ?";

    @Override
    public Hero removeHero(Hero heroToRemove) {
        jdbcTemplate.update(SQL_DELETE_HERO_BY_NAME, heroToRemove);
        return heroToRemove;
    }

    private static final String SQL_DELETE_HERO
            = "delete from heroes where heroid = ?";

    @Override
    public void removeHero(int heroid) {
        jdbcTemplate.update(SQL_DELETE_HERO, heroid);
    }

    @Override
    public Hero removeAndReturnHero(int heroid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
        private static final String SQL_SELECT_POWERS_BY_HEROID
            = "select powers.powerid, powers.powername, powers.powerdesc from powers join heroespowers on powers.powerid = heroespowers.powerid where heroespowers.heroid = ?";

    @Override
    public List<Power> getPowersOfHero(Hero heroToCheck) {
        return jdbcTemplate.query(SQL_SELECT_POWERS_BY_HEROID,
                new PowerMapper(),
                heroToCheck.getHeroid());
    }

    
    
//    _____                           _____              
//   |  __ \                         |  __ \             
//   | |__) |____      _____ _ __ ___| |  | | __ _  ___  
//   |  ___/ _ \ \ /\ / / _ \ '__/ __| |  | |/ _` |/ _ \ 
//   | |  | (_) \ V  V /  __/ |  \__ \ |__| | (_| | (_) |
//   |_|   \___/ \_/\_/ \___|_|  |___/_____/ \__,_|\___/ 
//                                                       
// 
        private static final String SQL_ADD_Power
            = "INSERT INTO powers (Powername, Powerdesc)"
            + " VALUES(?, ?)";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Power addPower(Power powerToAdd) {

        // First do the insert
        jdbcTemplate.update(SQL_ADD_Power,
                powerToAdd.getPowerName(),
                powerToAdd.getPowerDesc());

        // Then get the id
        int myId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        // Then stuff it in the object
        powerToAdd.setPowerid(myId);
        return powerToAdd;
    }

    private static final String SQL_GET_ALL_powers = "SELECT * FROM powers";

    @Override
    public List<Power> getAllPowers() {

        List<Power> theDatabasePowers
                = jdbcTemplate.query(SQL_GET_ALL_powers, new PowerMapper());
        return theDatabasePowers;

    }

    private static final String SQL_GET_Power_BY_PowerID = "SELECT * FROM powers WHERE Powerid = ?";

    @Override
    public Power getPower(int powerid) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_Power_BY_PowerID, new PowerMapper(), powerid);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }


    private static final String SQL_UPDATE_Power
            = "update powers set Powername = ?, Powerdesc = ? where Powerid =  ?";

    @Override
    public void updatePower(Power powerToUpdate) {
        jdbcTemplate.update(SQL_UPDATE_Power,
                powerToUpdate.getPowerName(),
                powerToUpdate.getPowerDesc(),
                powerToUpdate.getPowerid());
    }

    private static final String SQL_DELETE_Power_BY_NAME
            = "delete from powers where Powername = ?";

    @Override
    public Power removePower(Power powerToRemove) {
        jdbcTemplate.update(SQL_DELETE_Power_BY_NAME, powerToRemove);
        return powerToRemove;
    }

    private static final String SQL_DELETE_Power
            = "delete from powers where Powerid = ?";

    @Override
    public void removePower(int powerid) {
        jdbcTemplate.update(SQL_DELETE_Power, powerid);
    }

    @Override
    public Power removeAndReturnPower(int powerid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

//   ____                _____              
//  / __ \              |  __ \             
// | |  | |_ __ __ _ ___| |  | | __ _  ___  
// | |  | | '__/ _` / __| |  | |/ _` |/ _ \ 
// | |__| | | | (_| \__ \ |__| | (_| | (_) |
//  \____/|_|  \__, |___/_____/ \__,_|\___/ 
//              __/ |                       
//             |___/                        


    
    private static final String SQL_ADD_ORG
            = "INSERT INTO Orgs (orgname, orgdesc)"
            //            + " VALUES('Dont Starve', 'PC', 'Fantasyish Survival', 'Klei', 11)";
            + " VALUES(?, ?)";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Org addOrg(Org orgToAdd) {

        // First do the insert
        jdbcTemplate.update(SQL_ADD_ORG,
                orgToAdd.getOrgName(),
                orgToAdd.getOrgDesc());

        // Then get the id
        int myId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        // Then stuff it in the object
        orgToAdd.setOrgid(myId);
        return orgToAdd;
    }

    private static final String SQL_GET_ALL_ORGS = "SELECT * FROM Orgs";

    @Override
    public List<Org> getAllOrgs() {

        List<Org> theDatabaseOrgs
                = jdbcTemplate.query(SQL_GET_ALL_ORGS, new OrgMapper());
        return theDatabaseOrgs;

    }

    private static final String SQL_GET_ORG_BY_ORGID = "SELECT * FROM Orgs WHERE orgid = ?";

    @Override
    public Org getOrg(int orgid) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_ORG_BY_ORGID, new OrgMapper(), orgid);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private static final String SQL_UPDATE_ORG
            = "update orgs set orgname = ?, orgdesc = ? where orgid =  ?";

    @Override
    public void updateOrg(Org orgToUpdate) {
        jdbcTemplate.update(SQL_UPDATE_ORG,
                orgToUpdate.getOrgName(),
                orgToUpdate.getOrgDesc(),
                orgToUpdate.getOrgid());
    }

    private static final String SQL_DELETE_ORG_BY_NAME
            = "delete from orgs where orgname = ?";

    @Override
    public Org removeOrg(Org orgToRemove) {
        jdbcTemplate.update(SQL_DELETE_ORG_BY_NAME, orgToRemove);
        return orgToRemove;
    }

    private static final String SQL_DELETE_ORG
            = "delete from orogs where orgid = ?";

    @Override
    public void removeOrg(int orgid) {
        jdbcTemplate.update(SQL_DELETE_ORG, orgid);
    }

    @Override
    public Org removeAndReturnOrg(int orgid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
        private static final String SQL_SELECT_HEROES_BY_ORGID
            = "select heroes.heroid, heroes.heroname, heroes.herodesc, heroes.villain from heroes join heroesorgs on heroes.heroid = heroesorgs.heroid where heroesorgs.orgid = ?";

    @Override
    public List<Hero> getHeroesInOrg(Org orgToCheck) {
        return jdbcTemplate.query(SQL_SELECT_HEROES_BY_ORGID,
                new HeroMapper(),
                orgToCheck.getOrgid());
    }

    
    
    
    
    
    
    
    
    
    
    

    
    //   _                                                          
//  | |__   ___ _ __ ___  _ __ ___   __ _ _ __  _ __   ___ _ __ 
//  | '_ \ / _ \ '__/ _ \| '_ ` _ \ / _` | '_ \| '_ \ / _ \ '__|
//  | | | |  __/ | | (_) | | | | | | (_| | |_) | |_) |  __/ |   
//  |_| |_|\___|_|  \___/|_| |_| |_|\__,_| .__/| .__/ \___|_|   
//                                       |_|   |_|              
    
    
    public static final class HeroMapper implements RowMapper<Hero> {

    @Override
    public Hero mapRow(ResultSet rs, int i) throws SQLException {
        Hero heroFromRecord = new Hero();

        heroFromRecord.setHeroid(rs.getInt("heroid"));

        heroFromRecord.setHeroName(rs.getString("heroname"));
        heroFromRecord.setHeroDesc(rs.getString("herodesc"));
        heroFromRecord.setVillain(rs.getBoolean("villain"));

        return heroFromRecord;
    }
}
    
//                                                                      
//   _ __   _____      _____ _ __ _ __ ___   __ _ _ __  _ __   ___ _ __ 
//  | '_ \ / _ \ \ /\ / / _ \ '__| '_ ` _ \ / _` | '_ \| '_ \ / _ \ '__|
//  | |_) | (_) \ V  V /  __/ |  | | | | | | (_| | |_) | |_) |  __/ |   
//  | .__/ \___/ \_/\_/ \___|_|  |_| |_| |_|\__,_| .__/| .__/ \___|_|   
//  |_|                                          |_|   |_|              
    

    public static final class PowerMapper implements RowMapper<Power> {

        @Override
        public Power mapRow(ResultSet rs, int i) throws SQLException {
            Power powerFromRecord = new Power();

            powerFromRecord.setPowerid(rs.getInt("powerid"));

            powerFromRecord.setPowerName(rs.getString("powername"));
            powerFromRecord.setPowerDesc(rs.getString("powerdesc"));

            return powerFromRecord;
        }
    }
    
    

                                                        
                                                        
//   ___  _ __ __ _ _ __ ___   __ _ _ __  _ __   ___ _ __ 
//  / _ \| '__/ _` | '_ ` _ \ / _` | '_ \| '_ \ / _ \ '__|
// | (_) | | | (_| | | | | | | (_| | |_) | |_) |  __/ |   
//  \___/|_|  \__, |_| |_| |_|\__,_| .__/| .__/ \___|_|   
//             __/ |               | |   | |              
//            |___/                |_|   |_|              
//

    
    
    
        public static final class OrgMapper implements RowMapper<Org> {

        @Override
        public Org mapRow(ResultSet rs, int i) throws SQLException {
            Org orgFromRecord = new Org();

            orgFromRecord.setOrgid(rs.getInt("orgid"));

            orgFromRecord.setOrgName(rs.getString("orgname"));
            orgFromRecord.setOrgDesc(rs.getString("orgdesc"));

            return orgFromRecord;
        }
    }
    
    
    

//      _       _     _   _                                                   
//     (_)     | |   | | (_)                                                  
//  ___ _  __ _| |__ | |_ _ _ __   __ _ _ __ ___   __ _ _ __  _ __   ___ _ __ 
// / __| |/ _` | '_ \| __| | '_ \ / _` | '_ ` _ \ / _` | '_ \| '_ \ / _ \ '__|
// \__ \ | (_| | | | | |_| | | | | (_| | | | | | | (_| | |_) | |_) |  __/ |   
// |___/_|\__, |_| |_|\__|_|_| |_|\__, |_| |_| |_|\__,_| .__/| .__/ \___|_|   
//         __/ |                   __/ |               | |   | |              
//        |___/                   |___/                |_|   |_|              
//

        
        public static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            Sighting sightingFromRecord = new Sighting();

            sightingFromRecord.setSightingid(rs.getInt("sightingid"));

            sightingFromRecord.setLocid(rs.getInt("locid"));
            sightingFromRecord.setDateSighted(rs.getDate("datesighted"));

            return sightingFromRecord;
        }
    }
    
    

//
//  _                _____              
// | |              |  __ \             
// | |     ___   ___| |  | | __ _  ___  
// | |    / _ \ / __| |  | |/ _` |/ _ \ 
// | |___| (_) | (__| |__| | (_| | (_) |
// |______\___/ \___|_____/ \__,_|\___/ 
//                                      
                                      


        
        
        


//   _____ _       _     _   _             _____              
//  / ____(_)     | |   | | (_)           |  __ \             
// | (___  _  __ _| |__ | |_ _ _ __   __ _| |  | | __ _  ___  
//  \___ \| |/ _` | '_ \| __| | '_ \ / _` | |  | |/ _` |/ _ \ 
//  ____) | | (_| | | | | |_| | | | | (_| | |__| | (_| | (_) |
// |_____/|_|\__, |_| |_|\__|_|_| |_|\__, |_____/ \__,_|\___/ 
//            __/ |                   __/ |                   
//           |___/                   |___/                    


        
        
        
        


//  _                                                  
// | |                                                 
// | | ___   ___ _ __ ___   __ _ _ __  _ __   ___ _ __ 
// | |/ _ \ / __| '_ ` _ \ / _` | '_ \| '_ \ / _ \ '__|
// | | (_) | (__| | | | | | (_| | |_) | |_) |  __/ |   
// |_|\___/ \___|_| |_| |_|\__,_| .__/| .__/ \___|_|   
//                              | |   | |              
//                              |_|   |_|              
//
//

    
        public static final class LocMapper implements RowMapper<Loc> {

        @Override
        public Loc mapRow(ResultSet rs, int i) throws SQLException {
            Loc locFromRecord = new Loc();
            locFromRecord.setLocid(rs.getInt("locid"));

            locFromRecord.setLocName(rs.getString("locname"));
            locFromRecord.setLocDesc(rs.getString("locdesc"));
            locFromRecord.setLocAddress(rs.getString("locaddress"));
            locFromRecord.setLocLatLong(rs.getString("loclatlong"));

            return locFromRecord;
        }
    }
        
}