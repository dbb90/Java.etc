/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.superheroes.dao;

import com.sguild.superheroes.dto.Power;
import java.util.List;

/**
 *
 * @author dbb09
 */
public interface PowersDao {
    
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
