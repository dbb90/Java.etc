/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.superheroes;

import com.sguild.superheroes.dao.MasterDao;
import com.sguild.superheroes.dto.Loc;
import com.sguild.superheroes.dto.Power;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author dbb09
 */
public class JDBCDaoTest {

    MasterDao dao;
    JdbcTemplate template;

    public void setJdbcTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public JDBCDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("testMasterDao", MasterDao.class);
        template = ctx.getBean("jdbcTemplateBean", JdbcTemplate.class);

        template.execute("DELETE FROM contacts WHERE 1 = 1");
        template.execute("DELETE FROM heroessightings WHERE 1 = 1");
        template.execute("DELETE FROM sightings WHERE 1 = 1");
        template.execute("DELETE FROM locs WHERE 1 = 1");
        template.execute("DELETE FROM heroesorgs WHERE 1 = 1");
        template.execute("DELETE FROM orgs WHERE 1 = 1");
        template.execute("DELETE FROM heroespowers WHERE 1 = 1");
        template.execute("DELETE FROM heroes WHERE 1 = 1");
        template.execute("DELETE FROM powers WHERE 1 = 1");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddAndRetrievePower() {
        Power power = new Power();
        power.setPowerName("First Power");
        power.setPowerDesc("First Power Desc");
        dao.addPower(power);

        int thisid = power.getPowerid();
        Power fromMem = new Power();
        fromMem = dao.getPower(thisid);
//        String powerString = power.toString();
//        String fromMemString = fromMem.toString();
//        System.out.println(powerString);
        assertEquals(power, fromMem);
    }

    @Test
    public void testRemovePower() {
        Power power = new Power();
        power.setPowerName("First Power!");
        power.setPowerDesc("First Power Desc!");
        dao.addPower(power);
        int thisid = power.getPowerid();
        Power fromMem = dao.getPower(thisid);
//        String powerString = power.toString();
//        String fromMemString = fromMem.toString();
        assertEquals(power, fromMem);
        dao.removePower(thisid);
        assertNull(dao.getPower(thisid));
    }

    @Test
    public void testUpdatePower() {
        Power power = new Power();
        power.setPowerName("First Power!");
        power.setPowerDesc("First Power Desc!");
        dao.addPower(power);

        Power fromMem = dao.getPower(power.getPowerid());
        assertEquals(power, fromMem);

        Power powerTwo = new Power();

        powerTwo.setPowerid(power.getPowerid());
        powerTwo.setPowerName("Second Power!");
        powerTwo.setPowerDesc("Second Power Desc!");
        dao.updatePower(powerTwo);

        Power fromMemTwo = dao.getPower(power.getPowerid());

        assertNotEquals(fromMemTwo, fromMem);

        assertEquals(fromMemTwo, powerTwo);

    }

    @Test
    public void testGetAllPowers() {

        //check to ensure db is empty
        assertEquals(0, dao.getAllPowers().size());

        Power power = new Power();
        power.setPowerName("First Power!");
        power.setPowerDesc("First Power Desc!");
        dao.addPower(power);

        Power fromMem = dao.getPower(power.getPowerid());
        assertEquals(power, fromMem);

        Power powerTwo = new Power();

        powerTwo.setPowerid(power.getPowerid() + 1);
        powerTwo.setPowerName("Second Power!");
        powerTwo.setPowerDesc("Second Power Desc!");
        dao.addPower(powerTwo);

        Power fromMemTwo = dao.getPower(powerTwo.getPowerid());

        assertEquals(powerTwo, fromMemTwo);
        assertEquals(2, dao.getAllPowers().size());
    }

    @Test
    public void testAddGetLocation() {
        Loc testLoc = new Loc();
        testLoc.setLocName("1st loc");
        testLoc.setLocDesc("1st loc desc");
        testLoc.setLocAddress("Address One");
        testLoc.setLocLat("11.11");
        testLoc.setLocLong("22.22");
        dao.addLoc(testLoc);

        Loc fromMem = dao.getLoc(testLoc.getLocid());
        assertEquals(fromMem, testLoc);
    }

}
