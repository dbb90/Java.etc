/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.superheroes.dao;

import com.sguild.superheroes.Mapper.PowerMapper;
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
public class PowersDaoJdbcIml implements PowersDao {

    private JdbcTemplate jdbcTemplate;

    @Inject
    public PowersDaoJdbcIml(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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

}
