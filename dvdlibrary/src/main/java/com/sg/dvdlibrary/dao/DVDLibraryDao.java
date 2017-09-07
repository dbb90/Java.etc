/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;

import java.util.List;

/**
 *
 *
 *
 * @author dbb09-
 *
 */
public interface DVDLibraryDao {

    DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException;

    DVD removeDVD(String title) throws DVDLibraryDaoException;

    DVD getDVD(String title) throws DVDLibraryDaoException;

    List<DVD> getAllDVDs() throws DVDLibraryDaoException;

    DVD editTitle(DVD dvd, String newRelease, String title) throws DVDLibraryDaoException;

    DVD editReleaseDate(DVD dvd, String newRelease, String title) throws DVDLibraryDaoException;

    DVD editDirector(DVD dvd, String newDirector, String title) throws DVDLibraryDaoException;

    DVD editMPAA(DVD dvd, String newMPAA, String title) throws DVDLibraryDaoException;

    DVD editStudio(DVD dvd, String newStudio, String title) throws DVDLibraryDaoException;

    DVD editRating(DVD dvd, String newRating, String title) throws DVDLibraryDaoException;

    void writeLibrary() throws DVDLibraryDaoException;

    void readLibrary() throws DVDLibraryDaoException;

    List<DVD> searchDVDs(String searchInput) throws DVDLibraryDaoException;

}
