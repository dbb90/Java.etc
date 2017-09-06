

/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */

package com.sg.dvdlibrary.controller;

 

import com.sg.dvdlibrary.dao.DVDLibraryDao;

import com.sg.dvdlibrary.dao.DVDLibraryDaoException;

import com.sg.dvdlibrary.dto.DVD;

import com.sg.dvdlibrary.ui.DVDLibraryView;

import java.util.List;

 

/**

 *

 * @author dbb09-

 */

public class DVDLibraryController {

 

   DVDLibraryView view;

   DVDLibraryDao dao;

 

   public DVDLibraryController(DVDLibraryView view, DVDLibraryDao dao) {

       this.view = view;

       this.dao = dao;

   }

 

   public void run() {

 

       boolean keepGoing = true;

       int menuSelection;

       

       try{

       while (keepGoing) {

           menuSelection = getMenuSelection();

 

           switch (menuSelection) {

               case 1:

                   listAllDVDs();

                   break;

               case 2:

                   createDVD();

                   break;

               case 3:

                   removeDVD();

                   break;

               case 4:

                   editDVD();

                   break;

               case 5:

                   viewDVD();

                   break;

               case 6:

                   searchDVDs();

                   break;

               case 7:

                   keepGoing = false;

                   break;

               default:

                   unknownInput();

                   break;

           }

       }

       }catch (DVDLibraryDaoException e){

           view.displayErrorMessage(e.getMessage());

       }

       

       exitMessage();

   }

 

   private int getMenuSelection() {

       return view.printMenuAndGetSelection();

   }

 

   private void exitMessage() {

       view.displayExitMessage();

   }

 

   private void unknownInput() {

       view.displayUnknownInput();

   }

 

   private void createDVD() throws DVDLibraryDaoException {

       view.displayAddDVDBanner();

       DVD newDVD = view.getDVDInfo();

       dao.addDVD(newDVD.getTitle(), newDVD);

       view.displayAddCompleteBanner();

   }

 

   private void removeDVD() throws DVDLibraryDaoException {

       view.displayRemoveDVDBanner();

       String title = view.getDVDTitle();

       dao.removeDVD(title);

       view.displayRemoveCompleteBanner();

   }

 

   private void removeDVD(String title) throws DVDLibraryDaoException {

       dao.removeDVD(title);

 

   }

 

   private void listAllDVDs() throws DVDLibraryDaoException {

       view.displayListDVDsBanner();

       List<DVD> dvdList = dao.getAllDVDs();

       view.displayAllDVDs(dvdList);

   }

 

   private void viewDVD() throws DVDLibraryDaoException {

       view.displayViewDVDBanner();

       String dvdTitle = view.getDVDTitle();

       DVD dvd = dao.getDVD(dvdTitle);

       view.displayDVD(dvd);

   }

 

   private void editDVD() {

 

       boolean keepGoingEdit = true;

 

       try {

           while (keepGoingEdit) {

               int menuChoice = view.displayEditMenu();

               switch (menuChoice) {

                   case 1:

                       editTitle();

                       break;

                   case 2:

                       editRelease();

                       break;

                   case 3:

                       editMPAA();

                       break;

                   case 4:

                       editDirector();

                       break;

                   case 5:

                       editStudio();

                       break;

                   case 6:

                       editRating();

                       break;

                   case 7:

                       keepGoingEdit = false;

                       break;

                   default:

                       unknownInput();

                       break;

               }

           }

       }catch (DVDLibraryDaoException e){

           view.displayErrorMessage(e.getMessage());

       }

   }

 

   private void editTitle() throws DVDLibraryDaoException {

       String title = view.getDVDTitle();

       DVD editedDVD = dao.getDVD(title);

       String newTitle = view.getNewTitle();

       dao.editTitle(editedDVD, newTitle, title);

       removeDVD(title);

   }

 

   private void editRelease() throws DVDLibraryDaoException {

       String title = view.getDVDTitle();

       DVD editedDVD = dao.getDVD(title);

       String newRelease = view.getNewRelease();

       dao.editReleaseDate(editedDVD, newRelease, title);

 

   }

 

   private void editMPAA() throws DVDLibraryDaoException {

       String title = view.getDVDTitle();

       DVD editedDVD = dao.getDVD(title);

       String newMPAA = view.getNewMPAA();

       dao.editMPAA(editedDVD, newMPAA, title);

   }

 

   private void editDirector() throws DVDLibraryDaoException {

       String title = view.getDVDTitle();

       DVD editedDVD = dao.getDVD(title);

       String newDirector = view.getNewDirector();

       dao.editDirector(editedDVD, newDirector, title);

   }

 

   private void editStudio() throws DVDLibraryDaoException {

       String title = view.getDVDTitle();

       DVD editedDVD = dao.getDVD(title);

       String newStudio = view.getNewStudio();

       dao.editStudio(editedDVD, newStudio, title);

   }

 

   private void editRating() throws DVDLibraryDaoException {

       String title = view.getDVDTitle();

       DVD editedDVD = dao.getDVD(title);

       String newRating = view.getNewRating();

       dao.editRating(editedDVD, newRating, title);

   }

   

   private void searchDVDs() throws DVDLibraryDaoException{


       view.displaySearchBanner();

       String toSearch = view.getSearchInput();

       List<DVD> dvdList = dao.searchDVDs(toSearch);

       view.displayAllDVDs(dvdList);

   }

 

}