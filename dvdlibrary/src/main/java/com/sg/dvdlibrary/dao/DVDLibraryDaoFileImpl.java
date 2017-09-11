/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;

import java.io.BufferedReader;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

import java.util.Map;

import java.util.Scanner;

import java.util.Set;

/**
 *
 *
 *
 * @author dbb09-
 *
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    Map<String, DVD> dvds = new HashMap<>();

    public static final String DVD_FILE = "dvd.txt";

    public static final String DELIMITER = "::";

    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException {
        
        readLibrary();
        
        DVD newDVD = dvds.put(title, dvd);

        writeLibrary();

        return newDVD;

    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoException {

        DVD removedDVD = dvds.remove(title);

        writeLibrary();

        return removedDVD;

    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryDaoException {

        readLibrary();

        return dvds.get(title);

    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryDaoException {

        readLibrary();

        return new ArrayList<DVD>(dvds.values());

    }

    @Override
    public DVD editTitle(DVD dvd, String newTitle, String title) throws DVDLibraryDaoException {

        dvd.setTitle(newTitle);

        dvds.put(newTitle, dvd);

        writeLibrary();

        return dvd;

    }

    @Override
    public DVD editReleaseDate(DVD dvd, String newRelease, String title) throws DVDLibraryDaoException {

        dvd.setReleaseYear(newRelease);

        dvds.put(title, dvd);

        writeLibrary();

        return dvd;

    }

    @Override
    public DVD editDirector(DVD dvd, String newDirector, String title) throws DVDLibraryDaoException {

        dvd.setDirector(newDirector);

        dvds.put(title, dvd);

        writeLibrary();

        return dvd;

    }

    @Override
    public DVD editMPAA(DVD dvd, String newMpaa, String title) throws DVDLibraryDaoException {

        dvd.setMpaa(newMpaa);

        dvds.put(title, dvd);

        writeLibrary();

        return dvd;

    }

    @Override
    public DVD editStudio(DVD dvd, String newStudio, String title) throws DVDLibraryDaoException {

        dvd.setStudio(newStudio);

        dvds.put(title, dvd);

        writeLibrary();

        return dvd;

    }

    @Override
    public DVD editRating(DVD dvd, String newRating, String title) throws DVDLibraryDaoException {

        dvd.setRating(newRating);

        dvds.put(title, dvd);

        writeLibrary();

        return dvd;

    }

    @Override
    public void readLibrary() throws DVDLibraryDaoException {

        Scanner scanner;

        try {

            scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));

        } catch (FileNotFoundException e) {

            throw new DVDLibraryDaoException("Could not load DVD library", e);

        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            DVD newDVD = new DVD(currentTokens[0]);

            newDVD.setReleaseYear(currentTokens[1]);

            newDVD.setMpaa(currentTokens[2]);

            newDVD.setDirector(currentTokens[3]);

            newDVD.setStudio(currentTokens[4]);

            newDVD.setRating(currentTokens[5]);

            dvds.put(newDVD.getTitle(), newDVD);

        }

        scanner.close();

    }

    @Override
    public void writeLibrary() throws DVDLibraryDaoException {

        PrintWriter out;

        try {

            out = new PrintWriter(new FileWriter(DVD_FILE));

        } catch (IOException e) {

            throw new DVDLibraryDaoException("Could not save DVD library", e);

        }

        List<DVD> DVDList = this.getAllDVDs();

        for (DVD currentDVD : DVDList) {

            out.println(currentDVD.getTitle()
                    + DELIMITER + currentDVD.getReleaseYear()
                    + DELIMITER + currentDVD.getMpaa()
                    + DELIMITER + currentDVD.getDirector()
                    + DELIMITER + currentDVD.getStudio()
                    + DELIMITER + currentDVD.getRating());

            out.flush();

        }

        out.close();

    }

    public List<DVD> searchDVDs(String searchInput) throws DVDLibraryDaoException {
        readLibrary();

        Set<String> keys = dvds.keySet();

        List<DVD> containerList = new ArrayList<>();
        for (String currentKey : keys) {
            if (currentKey.contains(searchInput)) {
                containerList.add(dvds.get(currentKey));

            }
        }
        return containerList;
    }

}
