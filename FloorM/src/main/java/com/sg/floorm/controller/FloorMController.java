/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.controller;

import com.sg.floorm.dao.FloorMPersistenceException;
import com.sg.floorm.dto.Order;
import com.sg.floorm.dto.Product;
import com.sg.floorm.dto.TaxRate;
import com.sg.floorm.service.FloorMServiceLayer;
import com.sg.floorm.service.InvalidProductException;
import com.sg.floorm.service.InvalidTaxRateException;
import com.sg.floorm.ui.FloorMView;
import java.util.List;

public class FloorMController {

    private FloorMView view;
    private FloorMServiceLayer service;
    private int saveRequired;

    public FloorMController(FloorMView view, FloorMServiceLayer service) {
        this.view = view;
        this.service = service;
    }

      public void getConfig() {
 
       try {
           readConfig();
 
           String config = service.getConfig();
           if (config.equalsIgnoreCase("training")) {
               runT();
           } else {
               runP();
           }
       } catch (FloorMPersistenceException e) {
           view.displayErrorMessage(e);
       }
   }
    
    
    private void readConfig() throws FloorMPersistenceException {
       service.readConfig();
   }

    
    
    public void runP() {
        boolean keepGoing = true;
        saveRequired = 0;
        try {
            readFile();
            while (keepGoing) {
                int menuSelection = view.printPMenuAndGetSelection(1, 6);
                switch (menuSelection) {

                    case 1:
                        //displays orders by date
                        displayOrdersByDate();
                        break;

                    case 2: {
                        //adds an order
                        addOrder();

                    }
                    break;

                    case 3: {
                        //edits an order
                        editOrder();
                    }
                    break;

                    case 4:
                        //deletes an order
                        deleteOrder();
                        break;

                    case 5:
                        //saves changes
                        writeFile();
                        view.saveSuccess();
                        break;

                    case 6:
                        //checks if save on quit is necessary, then quits
                        saveCheck();
                        keepGoing = false;
                        break;

                    default:
                        unknownEntry();
                        break;

                }
            }

            view.displayExitMessage();

        } catch (FloorMPersistenceException e) {
            view.displayErrorMessage(e);
        }
    }

        public void runT() {
        boolean keepGoing = true;
        saveRequired = 0;
        try {
            readFile();
            while (keepGoing) {
                int menuSelection = view.printTMenuAndGetSelection(1, 6);
                switch (menuSelection) {

                    case 1:
                        //displays orders by date
                        displayOrdersByDate();
                        break;

                    case 2: {
                        //adds an order
                        addOrder();

                    }
                    break;

                    case 3: {
                        //edits an order
                        editOrder();
                    }
                    break;

                    case 4:
                        //deletes an order
                        deleteOrder();
                        break;

                    case 5:
                        //saves changes (deprecated)
                        break;

                    case 6:
                        //checks if save on quit is necessary, then quits (deprecated)
                        keepGoing = false;
                        break;

                    default:
                        unknownEntry();
                        break;

                }
            }

            view.displayExitMessage();

        } catch (FloorMPersistenceException e) {
            view.displayErrorMessage(e);
        }
    }
    
    private void displayOrdersByDate() {

        String dateToView = view.getDateToView();
        List<Order> orders = service.getOrdersByDate(dateToView);
        view.displayOrdersByDate(orders, dateToView);
    }

    private void addOrder() {
        view.displayAddOrderBanner();
        try {
            addOrderAttempt();
        } catch (InvalidTaxRateException | InvalidProductException e) {
            view.displayErrorMessage(e);
        }

    }

    private void addOrderAttempt() throws InvalidProductException, InvalidTaxRateException {

        List<TaxRate> taxRates = service.getAllTaxRates();
        List<Product> products = service.getAllProducts();
        Order orderToAdd = view.getNewOrderVars(taxRates, products);
        orderToAdd = service.calcOrderNum(orderToAdd);
        orderToAdd = service.calcCosts(orderToAdd);

        String choice = view.confirmChanges(orderToAdd, "Really add this order? Y/N: ");
        if (!choice.equalsIgnoreCase("n")) {
            service.addOrder(orderToAdd);
            view.displayOrder(orderToAdd);
            saveRequired = 1;
        } else {
            
        }

    }

    private void readFile() throws FloorMPersistenceException {
        service.readAllData();
    }

    private void writeFile() throws FloorMPersistenceException {
        // save orders as currently held in memory
        try {
            service.writeAllData();
            saveRequired = 0;
        } catch (FloorMPersistenceException e) {
            view.displayErrorMssg("Something went wrong.  Changes not saved!");

        }
    }

    private void unknownEntry() {
        view.displayUnknownEntry();
    }

    private void deleteOrder() {

        String date = view.getDateToView();
        int orderNum = view.getOrderNumber();
        Order orderToDelete = service.getOrder(orderNum);

        if (!(orderToDelete == null)) {
            String toDelete = view.confirmChanges(orderToDelete, "Are you sure you want to delete this order?[Y/N]: ");
            if (toDelete.equalsIgnoreCase("Y")) {
                service.deleteOrder(orderToDelete, date, orderNum);
                saveRequired = 1;

            } else {
                view.displayDeleteCancellation();

            }

        } else {
            view.displayOrderByDateNotFound();
        }

    }

    private void editOrder() {
        try {
            editOrderAttempt();
        } catch (InvalidTaxRateException | InvalidProductException e) {
            view.displayErrorMessage(e);
        }
    }

    private void editOrderAttempt() throws InvalidTaxRateException, InvalidProductException {
        String date = view.getDateToView();
        Order order = new Order();

        int orderNum = view.getOrderNumber();
        List<Order> ordersByDate = service.getOrdersByDate(date);
        for (Order currentOrder : ordersByDate) {
            if (currentOrder.getOrderNum() == orderNum) {
                order = currentOrder;
                
                break;
            }
        }
        Order uneditedOrder = new Order();
        uneditedOrder.setClient(order.getClient());
        uneditedOrder.setTaxState(order.getState());
        uneditedOrder.setArea(order.getArea());
        uneditedOrder.setProductType(order.getProductType());
        uneditedOrder.setOrderDate(order.getOrderDate());
        Order orderToEdit = order;

//        order.setOrderNum(orderNum);
//        service.calcOrderNum(orderToEdit);
        List<TaxRate> taxRates = service.getAllTaxRates();
        List<Product> products = service.getAllProducts();

        Order editedOrder = view.getEditInfo(orderToEdit, taxRates, products);
        editedOrder = service.calcCosts(editedOrder);
        uneditedOrder = service.calcCosts(uneditedOrder);
        String choice = view.confirmChanges(editedOrder, "Keep changes? [Y/N] : ");

        if (!choice.equalsIgnoreCase("N")) {
            saveRequired = 1;
//            service.deleteOrder(order, date, orderNum);
            service.addOrder(editedOrder);
            view.displayEditSuccess();

        } else {
            service.deleteOrder(editedOrder, date, orderNum);
            service.calcOrderNum(uneditedOrder);
            service.addOrder(uneditedOrder);
        }
    }

    private void saveCheck() throws FloorMPersistenceException {

        if (saveRequired != 0) {
            String confirmation = view.requestSave("You have unsaved changes, do you want to save them?");
            if (confirmation.equalsIgnoreCase("y")) {
                writeFile();
                view.saveSuccess();
            }
        }
    }
}
