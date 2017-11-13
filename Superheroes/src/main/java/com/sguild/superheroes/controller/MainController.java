/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.superheroes.controller;

import com.sguild.superheroes.dao.MasterDao;
import com.sguild.superheroes.dto.Hero;
import com.sguild.superheroes.dto.Loc;
import com.sguild.superheroes.dto.Power;
import com.sguild.superheroes.dto.Sighting;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dbb09
 */
@Controller
public class MainController {

    private MasterDao dao;

    @Inject
    public MainController(MasterDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayIndexPage(Model model) {

        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String displayIndexPageBack(Model model) {

        return "index";
    }

    @RequestMapping(value = "/heroes", method = RequestMethod.GET)
    public String displayHeroesPage(Model model) {
        List<Power> powers = dao.getAllPowers();
        List<Hero> heroes = dao.getAllHeroes();

        model.addAttribute("heroesList", heroes);
        model.addAttribute("powerList", powers);

        return "heroes";
    }

    @RequestMapping(value = "/sightings", method = RequestMethod.GET)
    public String displaySightingsPage(Model model) {
        List<Power> powers = dao.getAllPowers();
        List<Hero> heroes = dao.getAllHeroes();
        List<Sighting> sightings = dao.getAllSightingsOrdered();
        List<Loc> locs = dao.getAllLocs();

        model.addAttribute("heroesList", heroes);
        model.addAttribute("powerList", powers);
        model.addAttribute("sightingsList", sightings);
        model.addAttribute("locsList", locs);

        return "sightings";
    }

    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public String displayLocationsPage(Model model) {
        List<Power> powers = dao.getAllPowers();
        List<Hero> heroes = dao.getAllHeroes();
        List<Sighting> sightings = dao.getAllSightingsOrdered();
        List<Loc> locs = dao.getAllLocs();

        model.addAttribute("heroesList", heroes);
        model.addAttribute("powerList", powers);
        model.addAttribute("sightingsList", sightings);
        model.addAttribute("locsList", locs);

        return "locations";
    }

    @RequestMapping(value = "/powers", method = RequestMethod.GET)
    public String displayPowersPage(Model model) {
        List<Power> powers = dao.getAllPowers();
        List<Hero> heroes = dao.getAllHeroes();


        model.addAttribute("heroesList", heroes);
        model.addAttribute("powerList", powers);


        return "powers";
    }

    @RequestMapping(value = "/organizations", method = RequestMethod.GET)
    public String displayOrgsPage(Model model) {
        List<Power> powers = dao.getAllPowers();
        List<Hero> heroes = dao.getAllHeroes();
        List<Sighting> sightings = dao.getAllSightingsOrdered();
        List<Loc> locs = dao.getAllLocs();

        model.addAttribute("heroesList", heroes);
        model.addAttribute("powerList", powers);
        model.addAttribute("sightingsList", sightings);
        model.addAttribute("locsList", locs);

        return "organizations";
    }

}
