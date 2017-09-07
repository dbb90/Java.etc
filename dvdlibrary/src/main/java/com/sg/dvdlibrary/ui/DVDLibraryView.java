/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;

import java.util.List;

/**
 *
 *
 *
 * @author dbb09-
 *
 */
public class DVDLibraryView {

    UserIO io;

    public DVDLibraryView(UserIO io) {

        this.io = io;

    }

    public int printMenuAndGetSelection() {

        io.print("----------MENU-----------");

        io.print("1) List DVDs");

        io.print("2) Add a DVD");

        io.print("3) Edit a DVD");

        io.print("4) Remove a DVD");

        io.print("5) View a specific DVD");

        io.print("6) Search DVDs");

        io.print("7) Exit");

        return io.readInt("Please select an option from 1 to 7.", 1, 7);

    }

    public void displayUnknownInput() {
        io.print("ERROR: Unknown User Input!");

    }

    public DVD getDVDInfo() {

        String title = io.readString("What is the DVD's title?");

        String releaseDate = io.readString("What year was the DVD released?");

        String mpaaRating = io.readString("What rating was the DVD given by the MPAA? (G, PG, PG13, R, NC17)");

        String director = io.readString("Who is the film's director?");

        String studio = io.readString("What studio produced the film?");

        String rating = io.readString("Please enter any additional notes you may have at this time.");

        DVD currentDVD = new DVD(title);

        currentDVD.setReleaseYear(releaseDate);

        currentDVD.setMpaa(mpaaRating);

        currentDVD.setDirector(director);

        currentDVD.setStudio(studio);

        currentDVD.setRating(rating);

        return currentDVD;

    }

    public String getDVDTitle() {

        return io.readString("Please enter a stored DVD title.");

    }

    public void displayAllDVDs(List<DVD> dvds) {

        for (DVD currentDVD : dvds) {

            io.print(currentDVD.getTitle() + "\n" + currentDVD.getReleaseYear() + "\n"
                    + currentDVD.getMpaa() + "\n" + currentDVD.getDirector() + "\n"
                    + currentDVD.getStudio() + "\n" + currentDVD.getRating() + "\n\n");
            io.print("~~~~~~~~~~~~~~~~~~~~");

        }


    }

    public void displayDVD(DVD dvd) {

        if (dvd != null) {

            io.print(dvd.getTitle() + "\n" + dvd.getReleaseYear()
                    + "\n" + dvd.getMpaa() + "\n" + dvd.getDirector()
                    + "\n" + dvd.getStudio() + "\n" + dvd.getRating());

        } else {

            io.print("DVD not found.");

        }


    }

    public void displayExitMessage() {

        io.print("Now exiting...");

    }

    public void displayAddDVDBanner() {

        io.print("-----Add DVD-----");

    }

    public void displayAddCompleteBanner() {

        io.print("DVD added!");

    }

    public void displayRemoveDVDBanner() {

        io.print("-----Remove DVD-----");

    }

    public void displayRemoveCompleteBanner() {

        io.print("DVD removed!!");

    }

    public void displayListDVDsBanner() {

        io.print("----- DVD MASTER LIST -----");

    }

    public void displayEditDVDBanner() {

        io.print("----- Edit DVD -----");

    }

    public void displayEditCompleteBanner() {

        io.print("DVD edited!");

    }

    public void displayViewDVDBanner() {

        io.print("----- View DVD -----");

    }

    public int displayEditMenu() {

        displayEditDVDBanner();

        io.print("1) Title");

        io.print("2) Year of Release");

        io.print("3) MPAA Rating");

        io.print("4) Director");

        io.print("5) Studio");

        io.print("6) User Rating");

        io.print("7) Cancel");

        return io.readInt("Please select which category you would like to edit", 1, 7);

    }

    public String getNewRelease() {

        return io.readString("Please enter new Release Date");

    }

    public String getNewDirector() {

        return io.readString("Please enter new Director");

    }

    public String getNewMPAA() {

        return io.readString("Please enter new MPAA rating.");

    }

    public String getNewStudio() {

        return io.readString("Please enter new Studio");

    }

    public String getNewRating() {

        return io.readString("Please enter new rating.");

    }

    public void displayErrorMessage(String errorMessage) {

        io.print("Error!");

        io.print(errorMessage);

    }
    
    public String getSearchInput() {

        return io.readString("Please enter search term: ");

    }

    public String getNewTitle() {

        return io.readString("Please enter a new title");

    }

}
