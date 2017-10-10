/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tradewar.controller;

import com.sg.tradewar.dao.TradeWarPersistenceException;
import com.sg.tradewar.dto.Card;
import com.sg.tradewar.service.FloorMServiceLayer;
import com.sg.tradewar.ui.TradeWarView;
import java.util.List;

public class CardController {

    private TradeWarView view;
    private FloorMServiceLayer service;
    private int saveRequired;

    public CardController(TradeWarView view, FloorMServiceLayer service) {
        this.view = view;
        this.service = service;
    }


    public void run() {
        boolean keepGoing = true;
        saveRequired = 0;
        try {
            readFile();
            while (keepGoing) {
                int menuSelection = view.printMenuAndGetSelection(1, 6);
                switch (menuSelection) {

                    case 1:
                        //displays orders by date
                        listAllCards();
                        break;

                    case 2: {
                        //adds an order
                       

                    }
                    break;

                    case 3: {
                        //edits an order
                        
                    }
                    break;

                    case 4:
                        //deletes an order
                       
                        break;

                    case 5:
                        //saves changes
                  
                        break;

                    case 6:
                        //checks if save on quit is necessary, then quits
           
                        break;

                    default:
                        unknownEntry();
                        break;

                }
            }

            view.displayExitMessage();

        } catch (TradeWarPersistenceException e) {
            view.displayErrorMessage(e);
        }
    }

    private void readFile() throws TradeWarPersistenceException {
        service.readAllData();
    }

private void listAllCards() {
    List<Card> cards = service.getAllCards();
    view.listAllCards(cards);
}
//
//    private void writeFile() throws TradeWarPersistenceException {
//        // save orders as currently held in memory
//        try {
//            service.writeAllData();
//            saveRequired = 0;
//        } catch (TradeWarPersistenceException e) {
//            view.displayErrorMssg("Something went wrong.  Changes not saved!");
//
//        }
//    }
//
    private void unknownEntry() {
        view.displayUnknownEntry();
    }}

//    private void deleteOrder() {
//
//        String date = view.getDateToView();
//        int orderNum = view.getOrderNumber();
//        Card orderToDelete = service.getOrder(orderNum);
//
//        if (!(orderToDelete == null)) {
//            String toDelete = view.confirmChanges(orderToDelete, "Are you sure you want to delete this order?[Y/N]: ");
//            if (toDelete.equalsIgnoreCase("Y")) {
//                service.deleteOrder(orderToDelete, date, orderNum);
//                saveRequired = 1;
//
//            } else {
//                view.displayDeleteCancellation();
//
//            }
//
//        } else {
//            view.displayOrderByDateNotFound();
//        }
//
//    }
//
//    private void editOrder() {
//        try {
//            editOrderAttempt();
//        } catch (InvalidTaxRateException | InvalidProductException e) {
//            view.displayErrorMessage(e);
//        }
//    }
//
//    private void editOrderAttempt() throws InvalidTaxRateException, InvalidProductException {
//        String date = view.getDateToView();
//        Card order = new Card();
//
//        int orderNum = view.getOrderNumber();
//        List<Card> ordersByDate = service.getOrdersByDate(date);
//        for (Card currentOrder : ordersByDate) {
//            if (currentOrder.getOrderNum() == orderNum) {
//                order = currentOrder;
//
//                break;
//            }
//        }
//        Card uneditedOrder = new Card();
//        uneditedOrder.setClient(order.getClient());
//        uneditedOrder.setTaxState(order.getState());
//        uneditedOrder.setArea(order.getArea());
//        uneditedOrder.setProductType(order.getProductType());
//        uneditedOrder.setOrderDate(order.getOrderDate());
//        Card orderToEdit = order;
//
////        order.setOrderNum(orderNum);
////        service.calcOrderNum(orderToEdit);
//        List<TaxRate> taxRates = service.getAllTaxRates();
//        List<Spell> products = service.getAllProducts();
//
//        Card editedOrder = view.getEditInfo(orderToEdit, taxRates, products);
//        editedOrder = service.calcCosts(editedOrder);
//        uneditedOrder = service.calcCosts(uneditedOrder);
//        String choice = view.confirmChanges(editedOrder, "Keep changes? [Y/N] : ");
//
//        if (choice.equalsIgnoreCase("N")) {
//            service.deleteOrder(editedOrder, date, orderNum);
//            service.calcOrderNum(uneditedOrder);
//            service.addOrder(uneditedOrder);
//        } else {
//            saveRequired = 1;
////            service.deleteOrder(order, date, orderNum);
//            service.addOrder(editedOrder);
//            view.displayEditSuccess();
//
//        }
//    }
//
//    private void saveCheck() throws TradeWarPersistenceException {
//
//        if (saveRequired != 0) {
//            String confirmation = view.requestSave("You have unsaved changes, do you want to save them?");
//            if (confirmation.equalsIgnoreCase("y")) {
//                writeFile();
//                view.saveSuccess();
//            }
//        }
//    }
//}
