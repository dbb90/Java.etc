/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.ui;

import com.sg.floorm.dto.Order;
import com.sg.floorm.dto.Product;
import com.sg.floorm.dto.TaxRate;
import com.sg.floorm.service.InvalidProductException;
import com.sg.floorm.service.InvalidTaxRateException;
import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;
import java.util.Date;
import java.util.List;

public class FloorMView {

    private final UserIO io;
    private static final String DATEFORMAT = "yyyyMMdd";

    public FloorMView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.printLine("\n////Throw It On The Ground Flooring Co.////");
        io.printLine("\n********MENU********");
        io.printLine("[1] Display Orders");
        io.printLine("[2] Add Order");
        io.printLine("[3] Edit Order");
        io.printLine("[4] Delete Order");
        io.printLine("[5] Save");
        io.printLine("[6] Quit");
        return io.readInt("Selection: ", 1, 6);
    }

    public void displayOrdersByDate(List<Order> orders, String date) {

        if (!(orders.isEmpty())) {
            io.printLine("**** " + date + " ****\n");
            orders.forEach(this::displayOrder);

        } else {
            io.printLine("No orders on that date!");
        }

        io.readString("Please press enter to continue.");
    }

    public void displayOrder(Order order) {

        io.printLine("*********");

        io.printLine("Order Number: " + order.getOrderNum()
                + "\n" + "Client Name: " + order.getClient()
                + "\n" + "State: " + order.getState()
                + "\n" + "Tax Rate: " + order.getTaxRate()
                + "\n" + "Product Type: " + order.getProductType()
                + "\n" + "Area: " + order.getArea()
                + "\n" + "Material Cost per SqFt: " + order.getCostSqFt()
                + "\n" + "Labor Cost per SqFt: " + order.getLaborCostSqFt()
                + "\n" + "Total Material Cost: " + order.getMatCost()
                + "\n" + "Total Labor Cost: " + order.getLabCost()
                + "\n" + "Total Tax Cost: " + order.gettTax()
                + "\n" + "Total: " + order.gettCost());

        io.printLine("\n");

    }

    public Order getNewOrderVars(List<TaxRate> taxRates, List<Product> products) throws InvalidTaxRateException, InvalidProductException {

        String orderDate = this.getDate();
        String client = this.getClient();
        String taxRate = this.getTaxRate(taxRates);
        String productType = this.getProductType(products);
        BigDecimal area = this.getArea();
        Order orderNew = new Order();
        orderNew.setOrderDate(orderDate);
        orderNew.setClient(client);
        orderNew.setTaxRate(taxRate);
        orderNew.setProductType(productType);
        orderNew.setArea(area);

        return orderNew;

    }

    public String getDate() {

        String orderDate = "";
        boolean valiDate = false;
        String currentDateOption = "";
        currentDateOption = io.readString("would you like to use today's date? [Y/N]");
        if ("y".equalsIgnoreCase(currentDateOption)) {
            LocalDate orderDateDate = LocalDate.now();
            String date = orderDateDate.format(BASIC_ISO_DATE);
            orderDate = date;
        } else {
            while (!valiDate) {

                orderDate = io.readString("Please input date as yyyyMMdd such as (20171225) :");

                if (!(orderDate == null) && !(orderDate.equals("")) && (orderDate.matches("\\b\\d{8}\\b"))) {
                    valiDate = this.Validation(orderDate, DATEFORMAT);
                    if (!valiDate) {
                        io.printLine("Please enter a valid date!");
                    }

                } else {
                    io.printLine("please use format yyyyMMdd");
                }

            }
        }
        return orderDate;

    }

    public String getDateToView() {

        io.printLine("Please enter the date of the orders: ");

        String orderDate = "";
        boolean validDate = false;
        while (!validDate) {
            orderDate = io.readString("Please input date as yyyyMMdd such as (20170928) :");
            if (!(orderDate == null) && (orderDate.matches("\\b\\d{8}\\b"))) {
                validDate = this.Validation(orderDate, DATEFORMAT);
                if (!validDate) {
                    io.printLine("You must enter a valid date!");
                }
            } else {
                io.printLine("please use format MMddyyyy");
            }
        }

        return orderDate;

    }

    public boolean Validation(String dateToValidate, String dateFormat) {

        //checks the entry with SimpleDateFormat, and if it parses correctly,
        //allows the date to continue through
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateToValidate);
        } catch (ParseException e) {
            return false;
        }
        return true;

    }

    public String getClient() {

        String clientName = "";
        boolean validClientName = false;
        while (!validClientName) {
            clientName = io.readString("Input the client's surname: ");
            if (clientName == null || clientName.equals("")) {
                io.printLine("Input a name!");
            } else {
                validClientName = true;

            }
        }
        return clientName;
    }

    public String getTaxRate(List<TaxRate> taxRates) throws InvalidTaxRateException {

        String taxRate = "";

        //Read in taxRate String and validate that the taxRate exists
        boolean validTaxRate = false;

        while (!validTaxRate) {

            taxRate = io.readString("Input the state code (i.e. IN, KY): ");

            for (TaxRate currentTaxRate : taxRates) {

                if (taxRate.equalsIgnoreCase(currentTaxRate.getClientName())) {
                    validTaxRate = true;
                    break;
                }

            }

            if (validTaxRate) {
                break;
            }

            io.printLine("State not found. Please select one of the following: \n");
            taxRates.forEach((currentTaxRate) -> {
                io.print(currentTaxRate.getClientName() + ", ");
            });

            String keepGoing = io.readString("Try a new entry? [Y/N]: ");

            if (keepGoing.equals("N")) {
                throw new InvalidTaxRateException("");
            }
        }

        return taxRate;

    }

    private String getProductType(List<Product> products) throws InvalidProductException {

        boolean validProduct = false;
        String productType = "";

        //Read in String productType and validate it
        while (!validProduct) {
            productType = io.readString("Please input the product you wish to order: ");

            for (Product currentProduct : products) {
                if (currentProduct.getProductType().equalsIgnoreCase(productType)) {
                    validProduct = true;
                    break;
                }
            }

            if (validProduct) {
                break;
            }

            io.printLine("Product type not found.");

            io.printLine("These are the products on offer:\n");
            products.forEach((currentProduct) -> {
                io.print(currentProduct.getProductType() + ", ");
            });

            String keepGoing = io.readString("Continue? [Y/N]: ");
            if (keepGoing.equals("N")) {
                throw new InvalidProductException("");
            }
        }

        return productType;

    }

    private BigDecimal getArea() {

        BigDecimal min = new BigDecimal("0");
        BigDecimal area = io.readBigDecimal("enter the floor's area in feet: ", min);
        area = area.setScale(2, HALF_UP);
        return area;

    }

    public Order getEditInfo(Order order, List<TaxRate> taxRates, List<Product> products)
            throws InvalidTaxRateException, InvalidProductException {

        io.printLine("****Edit Order****");

        String clientName = this.getEditClientName(order);
        if (clientName == null) {

        } else {
            order.setClient(clientName);
        }

        String taxRate = this.getEditTaxRate(order, taxRates);

        if (taxRate == null) {

        } else {
            order.setTaxRate(taxRate);
        }

        String productType = this.getEditProductType(order, products);

        if (productType == null) {

        } else {
            order.setProductType(productType);
        }

        BigDecimal area = this.getEditArea(order);

        if (area == null) {

        } else {
            order.setArea(area);
        }
        return order;

    }

    private String getEditClientName(Order order) {

        String clientName = "";
        boolean validName = false;

        while (!validName) {
            clientName = io.readString("Please input the client's surname -- Currently: " + order.getClient());
            if (!(clientName == null)) {
                if (clientName.trim().length() == 0) {
                    return null;
                }
                validName = true;
            }
        }

        return clientName;

    }

    private String getEditTaxRate(Order order, List<TaxRate> taxRates) throws InvalidTaxRateException {

        String taxRate = "";

        boolean validTaxRate = false;

        while (!validTaxRate) {

            taxRate = io.readString("Please input state code (i.e. KY, IN) -- Currently: " + order.getState());
            if (taxRate.trim().length() == 0) {
                return null;

            }

            for (TaxRate currentTaxRate : taxRates) {

                if (taxRate.equalsIgnoreCase(currentTaxRate.getClientName())) {
                    validTaxRate = true;
                    break;
                }
            }

            if (validTaxRate) {
                break;
            }

            io.printLine("State not found. Please select one of the following: \n");
            taxRates.forEach((currentState) -> {
                io.print(currentState.getClientName() + ", ");
            });

            String keepGoing = io.readString("Try a new entry? [Y/N]: ");

            if (keepGoing.equals("N")) {
                throw new InvalidTaxRateException("");
            }
        }

        return taxRate;

    }

    private BigDecimal getEditArea(Order order) {

        BigDecimal min = new BigDecimal("0");

        BigDecimal area = io.readBigDecimal("Please enter the area of the floor in feet: (" + order.getArea().toString() + ")", min);

        if (area == null) {
            return null;
        }
        area = area.setScale(2, HALF_UP);
        return area;

    }

    private String getEditProductType(Order order, List<Product> products) throws InvalidProductException {

        boolean validProduct = false;

        String productType = "";

        while (!validProduct) {

            productType = io.readString("Please input product type -- Currently: " + order.getProductType());
            if (productType.trim().length() == 0) {
                return null;
            }

            for (Product currentProduct : products) {
                if (currentProduct.getProductType().equalsIgnoreCase(productType)) {
                    validProduct = true;
                    break;
                }

            }
            if (validProduct) {
                break;
            }

            io.printLine("Product type not found.");

            io.printLine("These are the products on offer:\n");
            products.forEach((currentProduct) -> {
                io.print(currentProduct.getProductType() + ", ");
            });

            String keepGoing = io.readString("Continue? [Y/N]: ");
            if (keepGoing.equals("N")) {
                throw new InvalidProductException("");
            }
        }
        return productType;
    }

    public int getOrderNumber() {
        return io.readInt("Input an order #: ");
    }

    public String confirmMssg(String prompt) {
        return io.readString(prompt);
    }

    public String confirmChanges(Order order, String prompt) {
        this.displayOrder(order);
        return io.readString(prompt);
    }

    public void displayDeleteCancellation() {
        io.readString("Order not removed.  Please press enter to continue.");

    }

    public void displayRemoveSuccessful() {
        io.readString("Order removed! Please press enter to continue.");
    }

    public void displayOrderNotFound() {
        io.printLine("Order not found!");
    }

    public void saveSuccess() {
        io.readString("Data Saved!  Press enter to continue.");
    }

    public void displayOrderByDateNotFound() {
        io.printLine("Order not Found, please make "
                + "sure you enter the correct date.\n");
    }

    public void displayEditSuccess() {
        io.printLine("Order Edited!\n");

    }

    public void displayErrorMessage(Exception e) {
        io.printLine(e.getMessage());

    }

    public void displayUnknownEntry() {
        io.printLine("Please enter a valid input!");

    }

    public void displayAddOrderBanner() {
        io.printLine("------Add Order-----");
    }

    public void displayExitMessage() {
        io.printLine("Quitting..");
    }

}
