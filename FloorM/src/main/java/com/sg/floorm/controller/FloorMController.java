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

    public FloorMController(FloorMView view, FloorMServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    public void run() throws InvalidProductException, InvalidTaxRateException {
        boolean keepGoing = true;
        try {
            readFile();
            while (keepGoing) {
                int menuSelection = view.printMenuAndGetSelection();
                switch (menuSelection) {

                    case 1:
                        displayOrdersByDate();
                        break;

                    case 2:
                         try {
                            addOrder();

                        } catch (InvalidProductException | InvalidTaxRateException e) {
                            break;
                        }
                        break;

                    case 3:
                        try {
                            editOrder();

                        } catch (InvalidProductException | InvalidTaxRateException e) {
                            break;
                        }
                        break;

                    case 4:

                        deleteOrder();
                        break;

                    case 5:

                        writeFile();
                        view.saveSuccess();
                        break;

                    case 6:
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

    private void displayOrdersByDate() {

        String dateToView = view.getDateToView();
        List<Order> orderList = service.getOrdersByDate(dateToView);
        view.displayOrdersByDate(orderList, dateToView);
    }

    private void addOrder() throws InvalidTaxRateException, InvalidProductException {

        view.displayAddOrderBanner();
        List<TaxRate> taxRates = service.getAllTaxRates();
        List<Product> products = service.getAllProducts();
        Order orderToAdd = view.getNewOrderVars(taxRates, products);
        orderToAdd = service.calcOrderNum(orderToAdd);
        orderToAdd = service.calcCosts(orderToAdd);
        
        String choice = view.confirmChanges(orderToAdd, "Really add this order? Y/N: ");

        if (choice.equalsIgnoreCase("n")) {
            return;

        } else {

            service.addOrder(orderToAdd);
            view.displayOrder(orderToAdd);
        }

    }

    private void readFile() throws FloorMPersistenceException {
        service.readAllData();
    }

    private void writeFile() throws FloorMPersistenceException {
        service.writeAllData();
    }

    private void unknownEntry() {
        view.displayUnknownEntry();
    }

    private void deleteOrder() {

        String date = view.getDateToView();
        int orderNum = view.getOrderNumber();
        Order orderToDelete = service.getOrder(orderNum);

        if (!(orderToDelete == null)) {
            String toDelete = view.confirmChanges(orderToDelete, "Are you sure you want to delete this order? Y or N : ");
            if (toDelete.equalsIgnoreCase("Y")) {
                service.deleteOrder(orderToDelete, date, orderNum);

            } else {
                view.displayDeleteCancellation();

            }

        } else {
            view.displayOrderByDateNotFound();
        }

    }

    private void editOrder() throws InvalidTaxRateException, InvalidProductException {

        view.getDateToView();
        int orderNum = view.getOrderNumber();
        Order orderToEdit = service.getOrder(orderNum);
        List<TaxRate> taxRates = service.getAllTaxRates();
        List<Product> products = service.getAllProducts();

        Order editedOrder = view.getEditInfo(orderToEdit, taxRates, products);
        editedOrder = service.calcCosts(editedOrder);
        String choice = view.confirmChanges(editedOrder, "Keep changes? [Y/N] : ");

        if (choice.equals("N")) {
        } else {
            service.addOrder(editedOrder);
            view.displayEditSuccess();
        }
    }

    private void saveCheck() throws FloorMPersistenceException {

        String confirmation = view.confirmMssg("Would you like to save your work? [Y/N]");

        if (confirmation.equals("N")) {
            confirmation = view.confirmMssg("If you do not save, you will lose all work from this session."
                    + "\nWould you like to save your work? [Y/N]");

            if (confirmation.equals("N")) {
                view.confirmMssg("Changes reverted. Press enter to continue");

            } else {
                this.writeFile();
                view.saveSuccess();

            }

        } else {
            this.writeFile();
            view.saveSuccess();

        }
    }
}
