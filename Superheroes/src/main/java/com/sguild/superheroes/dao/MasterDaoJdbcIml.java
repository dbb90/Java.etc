/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.superheroes.dao;

import com.sguild.superheroes.dto.Contact;
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

//
//  _                _____              
// | |              |  __ \             
// | |     ___   ___| |  | | __ _  ___  
// | |    / _ \ / __| |  | |/ _` |/ _ \ 
// | |___| (_) | (__| |__| | (_| | (_) |
// |______\___/ \___|_____/ \__,_|\___/ 
//                                      
    private static final String SQL_ADD_LOC
            = "INSERT INTO LOCS (locname, locdesc, locaddress, loclat, loclong"
            //            + " VALUES('Dont Starve', 'PC', 'Fantasyish Survival', 'Klei', 11)";
            + " VALUES(?, ?, ?, ?, ?)";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Loc addLoc(Loc locToAdd) {

        // First do the insert
        jdbcTemplate.update(SQL_ADD_LOC,
                locToAdd.getLocName(),
                locToAdd.getLocDesc(),
                locToAdd.getLocAddress(),
                locToAdd.getLocLat(),
                locToAdd.getLocLong());

        // Then get the id
        int myId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        // Then stuff it in the object
        locToAdd.setLocid(myId);
        return locToAdd;
    }

    private static final String SQL_GET_ALL_LOCS = "SELECT * FROM Locs";

    @Override
    public List<Loc> getAllLocs() {

        List<Loc> theDatabaseLocs
                = jdbcTemplate.query(SQL_GET_ALL_LOCS, new LocMapper());
        return theDatabaseLocs;

    }

    private static final String SQL_GET_LOC_BY_LOCID = "SELECT * FROM Locs WHERE locid = ?";

    @Override
    public Loc getLoc(int locid) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_LOC_BY_LOCID, new LocMapper(), locid);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private static final String SQL_UPDATE_LOC
            = "update locs set locname = ?, locdesc = ?, locaddress = ?, loclatlong = ? where locid =  ?";

    @Override
    public void updateLoc(Loc locToUpdate) {
        jdbcTemplate.update(SQL_UPDATE_LOC,
                locToUpdate.getLocName(),
                locToUpdate.getLocDesc(),
                locToUpdate.getLocAddress(),
                locToUpdate.getLocLat(),
                locToUpdate.getLocLong());
    }

    private static final String SQL_DELETE_LOC_BY_NAME
            = "delete from locs where locname = ?";

    @Override
    public Loc removeLoc(Loc locToRemove) {
        jdbcTemplate.update(SQL_DELETE_LOC_BY_NAME, locToRemove);
        return locToRemove;
    }

    private static final String SQL_DELETE_LOC
            = "delete from locs where locid = ?";

    @Override
    public void removeLoc(int locid) {
        jdbcTemplate.update(SQL_DELETE_LOC, locid);
    }

    @Override
    public Loc removeAndReturnLoc(int locid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//   _____ _       _     _   _             _____              
//  / ____(_)     | |   | | (_)           |  __ \             
// | (___  _  __ _| |__ | |_ _ _ __   __ _| |  | | __ _  ___  
//  \___ \| |/ _` | '_ \| __| | '_ \ / _` | |  | |/ _` |/ _ \ 
//  ____) | | (_| | | | | |_| | | | | (_| | |__| | (_| | (_) |
// |_____/|_|\__, |_| |_|\__|_|_| |_|\__, |_____/ \__,_|\___/ 
//            __/ |                   __/ |                   
//           |___/                   |___/                    
    private static final String SQL_ADD_SIGHTING
            = "INSERT INTO SIGHTINGS (locid, datesighted)"
            //            + " VALUES('Dont Starve', 'PC', 'Fantasyish Survival', 'Klei', 11)";
            + " VALUES(?, ?)";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Sighting addSighting(Sighting sightingToAdd) {

        // First do the insert
        jdbcTemplate.update(SQL_ADD_SIGHTING,
                sightingToAdd.getLocid(),
                sightingToAdd.getDateSighted());

        // Then get the id
        int myId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        // Then stuff it in the object
        sightingToAdd.setLocid(myId);
        return sightingToAdd;
    }

    private static final String SQL_GET_ALL_SIGHTINGS = "SELECT * FROM Sightings";

    @Override
    public List<Sighting> getAllSightings() {

        List<Sighting> theDatabaseSightings
                = jdbcTemplate.query(SQL_GET_ALL_SIGHTINGS, new SightingMapper());
        return theDatabaseSightings;

    }

    private static final String SQL_GET_SIGHTING_BY_SIGHTINGID = "SELECT * FROM Sightings WHERE sightingid = ?";

    @Override
    public Sighting getSighting(int sightingid) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_SIGHTING_BY_SIGHTINGID, new SightingMapper(), sightingid);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private static final String SQL_UPDATE_SIGHTING
            = "update sightings set locid = ?, datesighted = ? where sightingid =  ?";

    @Override
    public void updateSighting(Sighting sightingToUpdate) {
        jdbcTemplate.update(SQL_UPDATE_SIGHTING,
                sightingToUpdate.getLocid(),
                sightingToUpdate.getDateSighted());
    }

    private static final String SQL_DELETE_SIGHTING_BY_LOCID
            = "delete from sightings where locid = ?";

    @Override
    public Sighting removeSighting(Sighting sightingToRemove) {
        jdbcTemplate.update(SQL_DELETE_SIGHTING_BY_LOCID, sightingToRemove);
        return sightingToRemove;
    }

    private static final String SQL_DELETE_SIGHTING
            = "delete from sightings where sightingid = ?";

    @Override
    public void removeSighting(int sightingid) {
        jdbcTemplate.update(SQL_DELETE_SIGHTING, sightingid);
    }

    @Override
    public Sighting removeAndReturnSighting(int sightingid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private static final String SQL_SELECT_HEROES_BY_SIGHTINGID
            = "select heroes.heroid, heroes.heroname, heroes.herodesc, heroes.villain from heroes join heroessightings on heroes.heroid = heroessightings.heroid where heroessightings.sightingid = ?";
    
    
        @Override
    public List<Hero> getHeroesSighted(Sighting sightingToCheck) {
        return jdbcTemplate.query(SQL_SELECT_HEROES_BY_SIGHTINGID,
                new HeroMapper(),
                sightingToCheck.getSightingid());
    }
    
    

    //
//   _____            _             _   _____              
//  / ____|          | |           | | |  __ \             
// | |     ___  _ __ | |_ __ _  ___| |_| |  | | __ _  ___  
// | |    / _ \| '_ \| __/ _` |/ __| __| |  | |/ _` |/ _ \ 
// | |___| (_) | | | | || (_| | (__| |_| |__| | (_| | (_) |
//  \_____\___/|_| |_|\__\__,_|\___|\__|_____/ \__,_|\___/ 
//                                                         
//   
    private static final String SQL_ADD_CONTACT
            = "INSERT INTO CONTACTS (contactid, orgid, locid, phone, email)"
            //            + " VALUES('Dont Starve', 'PC', 'Fantasyish Survival', 'Klei', 11)";
            + " VALUES(?, ?, ?, ?, ?)";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Contact addContact(Contact contactToAdd) {

        // First do the insert
        jdbcTemplate.update(SQL_ADD_CONTACT,
                contactToAdd.getContactid(),
                contactToAdd.getOrgid(),
                contactToAdd.getLocid(),
                contactToAdd.getPhone(),
                contactToAdd.getEmail());

        // Then get the id
        int myId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        // Then stuff it in the object
        contactToAdd.setLocid(myId);
        return contactToAdd;
    }

    private static final String SQL_GET_ALL_CONTACTS = "SELECT * FROM Contacts";

    @Override
    public List<Contact> getAllContacts() {

        List<Contact> theDatabaseContacts
                = jdbcTemplate.query(SQL_GET_ALL_CONTACTS, new ContactMapper());
        return theDatabaseContacts;

    }

    private static final String SQL_GET_CONTACT_BY_CONTACTID = "SELECT * FROM Contacts WHERE contactid = ?";

    @Override
    public Contact getContact(int contactid) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_CONTACT_BY_CONTACTID, new ContactMapper(), contactid);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private static final String SQL_UPDATE_CONTACT
            = "update contacts set orgid = ?, locid = ?, phone = ?, email = ? where contactid =  ?";

    @Override
    public void updateContact(Contact contactToUpdate) {
        jdbcTemplate.update(SQL_UPDATE_CONTACT,
                contactToUpdate.getOrgid(),
                contactToUpdate.getLocid(),
                contactToUpdate.getPhone(),
                contactToUpdate.getEmail());
    }

    private static final String SQL_DELETE_CONTACT_BY_ORGID
            = "delete from contacts where orgid = ?";

    @Override
    public Contact removeContact(Contact contactToRemove) {
        jdbcTemplate.update(SQL_DELETE_CONTACT_BY_ORGID, contactToRemove);
        return contactToRemove;
    }

    private static final String SQL_DELETE_CONTACT
            = "delete from contacts where contacts = ?";

    @Override
    public void removeContact(int contactid) {
        jdbcTemplate.update(SQL_DELETE_CONTACT, contactid);
    }

    @Override
    public Contact removeAndReturnContact(int contactid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            locFromRecord.setLocLat(rs.getString("loclat"));
            locFromRecord.setLocLong(rs.getString("loclong"));

            return locFromRecord;
        }
    }

//                  _             _                                         
//                 | |           | |                                        
//   ___ ___  _ __ | |_ __ _  ___| |_ _ __ ___   __ _ _ __  _ __   ___ _ __ 
//  / __/ _ \| '_ \| __/ _` |/ __| __| '_ ` _ \ / _` | '_ \| '_ \ / _ \ '__|
// | (_| (_) | | | | || (_| | (__| |_| | | | | | (_| | |_) | |_) |  __/ |   
//  \___\___/|_| |_|\__\__,_|\___|\__|_| |_| |_|\__,_| .__/| .__/ \___|_|   
//                                                   | |   | |              
//                                                   |_|   |_|              
    public static final class ContactMapper implements RowMapper<Contact> {

        @Override
        public Contact mapRow(ResultSet rs, int i) throws SQLException {
            Contact contactFromRecord = new Contact();
            contactFromRecord.setContactid(rs.getInt("contactid"));

            contactFromRecord.setOrgid(rs.getInt("orgid"));
            contactFromRecord.setLocid(rs.getInt("locid"));
            contactFromRecord.setPhone(rs.getString("phone"));
            contactFromRecord.setEmail(rs.getString("email"));

            return contactFromRecord;
        }
    }

}
