/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.superheroes;

import com.sguild.superheroes.dto.Hero;
import com.sguild.superheroes.dto.Power;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author dbb09
 */
public class Mapper {

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
}
