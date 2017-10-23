/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.superheroes.dao;

import com.sguild.superheroes.Mapper.HeroMapper;
import com.sguild.superheroes.Mapper.PowerMapper;
import com.sguild.superheroes.dto.Hero;
import com.sguild.superheroes.dto.Power;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dbb09
 */
public class HeroesDaoJdbcIml implements HeroesDao {

    private JdbcTemplate jdbcTemplate;

    @Inject
    public HeroesDaoJdbcIml(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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

    
    
    
    
}
