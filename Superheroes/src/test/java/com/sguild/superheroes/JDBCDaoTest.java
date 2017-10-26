/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.superheroes;

import com.sguild.superheroes.dao.MasterDao;
import com.sguild.superheroes.dto.Hero;
import com.sguild.superheroes.dto.Org;
import com.sguild.superheroes.dto.Power;
import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ahill
 */
public class JDBCDaoTest {

    MasterDao testMasterDao;

    public JDBCDaoTest() {

        ApplicationContext factory = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        testMasterDao = factory.getBean(MasterDao.class);
     

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testConnection() {
        System.out.println("Testing...");
        List<Power> powers = testMasterDao.getAllPowers();
        Hero heroAdded = testMasterDao.addHero(new Hero(9, "The Bat", "Hank Venture in a most convincing costume",
                false, powers)
        );

        System.out.println("THE ID: " + heroAdded.getHeroid());

        System.out.println("List of heroes:");
        for (Hero hero : testMasterDao.getAllHeroes()) {
            System.out.println(hero.getHeroName());
            System.out.println(hero.getHeroDesc());
            System.out.println(hero.getVillain());
        }

        System.out.println("Hero # 9:");
        Hero hero = testMasterDao.getHero(8);
        System.out.println(hero.getHeroName());
        System.out.println(hero.getHeroDesc());
        System.out.println(hero.getVillain());
        
        List<Hero> heroes = testMasterDao.getAllHeroes();
        List<Org> orgs = testMasterDao.getAllOrgs();

        Power powerAdded = testMasterDao.addPower(new Power(7, "Invincibility",
                "untouchable!"));

        System.out.println("THE ID: " + powerAdded.getPowerid());

        System.out.println("List of powers:");
        for (Power power : testMasterDao.getAllPowers()) {
            System.out.println(power.getPowerName());
            System.out.println(power.getPowerDesc());
        }

       // System.out.println("Hero # 9:");
       // Power power = testPowerDao.getPower(7);
       // System.out.println(power.getPowerName());
      //  System.out.println(power.getPowerDesc());
        
        System.out.println("powers of heroes:");
        int maximum = heroes.size();
        int i = 1;
        while (i < maximum) {
        Hero heroToCheck = testMasterDao.getHero(i);
        heroToCheck.setPowers(testMasterDao.getPowersOfHero(heroToCheck));
            System.out.println("---" + heroToCheck.getHeroName() + "---");
            for (Power thisPower : heroToCheck.getPowers()) {
                System.out.println(thisPower.getPowerName());
                System.out.println(thisPower.getPowerDesc());
            }
        System.out.println(heroToCheck.getPowers());
        i++;
        }
        
                System.out.println("heroes of orgs:");
        maximum = orgs.size();
        i = 1;
        while (i < maximum) {
        Org orgToCheck = testMasterDao.getOrg(i);
        orgToCheck.setHeroes(testMasterDao.getHeroesInOrg(orgToCheck));
            System.out.println("---" + orgToCheck.getOrgName() + "---");
        List<Hero> temp;
            temp = orgToCheck.getHeroes();
            for (Hero zero : temp) {
                System.out.println(zero.getHeroName());
            }
                
        i++;
        }

    }

}
