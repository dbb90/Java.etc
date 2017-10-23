/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.superheroes;

import com.sguild.superheroes.dao.HeroesDao;
import com.sguild.superheroes.dao.PowersDao;
import com.sguild.superheroes.dto.Hero;
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

    HeroesDao testHeroDao;
    PowersDao testPowerDao;

    public JDBCDaoTest() {

        ApplicationContext factory = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        testHeroDao = factory.getBean(HeroesDao.class);
        testPowerDao = factory.getBean(PowersDao.class);

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testConnection() {
        System.out.println("Testing...");
        List<Power> powers = testPowerDao.getAllPowers();
        Hero heroAdded = testHeroDao.addHero(new Hero(9, "The Bat", "Hank Venture in a most convincing costume",
                false, powers)
        );

        System.out.println("THE ID: " + heroAdded.getHeroid());

        System.out.println("List of heroes:");
        for (Hero hero : testHeroDao.getAllHeroes()) {
            System.out.println(hero.getHeroName());
            System.out.println(hero.getHeroDesc());
            System.out.println(hero.getVillain());
        }

        System.out.println("Hero # 9:");
        Hero hero = testHeroDao.getHero(8);
        System.out.println(hero.getHeroName());
        System.out.println(hero.getHeroDesc());
        System.out.println(hero.getVillain());
        
        List<Hero> heroes = testHeroDao.getAllHeroes();

        Power powerAdded = testPowerDao.addPower(new Power(7, "Invincibility",
                "untouchable!"));

        System.out.println("THE ID: " + powerAdded.getPowerid());

        System.out.println("List of powers:");
        for (Power power : testPowerDao.getAllPowers()) {
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
        Hero heroToCheck = testHeroDao.getHero(i);
        heroToCheck.setPowers(testHeroDao.getPowersOfHero(heroToCheck));
        System.out.println(heroToCheck.getPowers());
        i++;
        }
        

    }

}
