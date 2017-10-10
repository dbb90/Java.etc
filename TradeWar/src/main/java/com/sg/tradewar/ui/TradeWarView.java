/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tradewar.ui;

import com.sg.tradewar.dto.Card;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeWarView {

    private final UserIO io;
    private static final String DATEFORMAT = "yyyyMMdd";

    public TradeWarView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection(int min, int max) {
        io.printLine("\n////Throw It On The Ground Flooring Co.////");
        io.printLine("\n********MENU********");
        io.printLine("\n********Training Mode********");
        io.printLine("[1] Display Orders");
        io.printLine("[2] Add Order");
        io.printLine("[3] Edit Order");
        io.printLine("[4] Delete Order");
        io.printLine("[5] Save [DOES NOT SAVE IN TRAINING MODE]");
        io.printLine("[6] Quit");
        return io.readInt("Selection: ");
    }

    public void listAllCards(List<Card> cards) {
        
        
        
        if (!(cards.isEmpty())) {

            //a lambda that performs displayOrder for each order on the date specified, unless
            //orders is empty
            cards.forEach((card) -> this.displayCard(card));

        } else {
            //this happens when orders is empty on date given
            io.printLine("No orders on that date!");
        }

        io.readString("Please press enter to continue.");
    }
    private Map<Integer, String> rarities = new HashMap<>();

//    @Override
//    public Card addCard(Card card) {
//
//    }

    public String rarityString(Card card) {
       int rarity = card.getRarity();
       String rarityString = "Default";
       if (rarity == 0) {
           rarityString = "Common";}
       if (rarity == 1) {
           rarityString = "Uncommon";}
       else {
       rarityString = "failed";}
      
       return rarityString;
       }
    
       
       
       
        
    
    
    public void displayCard(Card card) {

        
        
       
        io.printLine(
                "*********");
        io.printLine(
                "**** " + card.getCardName() + " ****\n");
        io.printLine(
                "#: " + card.getCardNum()
                + "\n" + "Rarity: " + rarityString(card)
                + "\n" + "Type: " + card.getType());
 
        io.printLine(
                "\n");

    }

//    public Card getNewOrderVars(List<TaxRate> taxStates, List<Spell> products) throws InvalidTaxRateException, InvalidProductException {
//
//        String orderDate = this.getDate();
//        String client = this.getClient();
//        String taxState = this.getTaxState(taxStates);
//        String productType = this.getProductType(products);
//        BigDecimal area = this.getArea();
//        Card orderNew = new Card();
//        orderNew.setOrderDate(orderDate);
//        orderNew.setClient(client);
//        orderNew.setTaxState(taxState);
//        orderNew.setProductType(productType);
//        orderNew.setArea(area);
//
//        return orderNew;
//
//    }
//
//    public String getDate() {
//
//        String orderDate = "";
//        boolean valiDate = false;
//        String currentDateOption = "";
//        currentDateOption = io.readString("would you like to use today's date? [Y/N]");
//        if ("y".equalsIgnoreCase(currentDateOption)) {
//            LocalDate orderDateDate = LocalDate.now();
//            String date = orderDateDate.format(BASIC_ISO_DATE);
//
////          Attempting to fix the date parse from LocalDate.now(); so that I can flip the rest of the dates to match spec
////          DateTimeFormatter formatters = DateTimeFormatter.ofPattern("ddMMyyyy");
////          String text = date.format(formatters);
////          LocalDate orderDateDate = LocalDate.parse(text, formatters);
//            orderDate = date;
//        } else {
//            while (!valiDate) {
//
//                orderDate = io.readString("Please input date as yyyyMMdd such as (20171225) :");
//
//                // matches here contains regex b to ensure the beginning and ending of the string are null,
//                // and those null values surround 8 digits 0-9
//                if (!(orderDate == null) && !(orderDate.equals("")) && (orderDate.matches("\\b\\d{8}\\b"))) {
//                    valiDate = this.validateDate(orderDate, DATEFORMAT);
//                    if (!valiDate) {
//                        io.printLine("Please enter a valid date!");
//                    }
//
//                } else {
//                    io.printLine("please use format yyyyMMdd");
//                }
//
//            }
//        }
//        return orderDate;
//
//    }
//
//    public String getDateToView() {
//
//        io.printLine("Please enter the date of the orders: ");
//
//        String orderDate = "";
//        boolean validDate = false;
//        while (!validDate) {
//            orderDate = io.readString("Please input date as yyyyMMdd such as (20170928) :");
//            if (!(orderDate == null) && (orderDate.matches("\\b\\d{8}\\b"))) {
//                validDate = this.validateDate(orderDate, DATEFORMAT);
//                if (!validDate) {
//                    io.printLine("You must enter a valid date!");
//                }
//            } else {
//                io.printLine("please use format MMddyyyy");
//            }
//        }
//
//        return orderDate;
//
//    }
//
//    public boolean validateDate(String dateToValidate, String dateFormat) {
//
//        //checks the entry with SimpleDateFormat, and if it parses correctly,
//        //allows the date to continue through
//        SimpleDateFormat sdf;
//        sdf = new SimpleDateFormat(dateFormat);
//        sdf.setLenient(false);
//        try {
//            Date date = sdf.parse(dateToValidate);
//        } catch (ParseException e) {
//            return false;
//        }
//        return true;
//
//    }
//
//    public String getClient() {
//
//        String clientName = "";
//        boolean validClientName = false;
//        while (!validClientName) {
//            clientName = io.readString("Input the client's surname: ");
//            if (clientName == null || clientName.equals("")) {
//                io.printLine("Input a name!");
//            } else {
//                validClientName = true;
//
//            }
//        }
//        return clientName;
//    }
//
//    public String getTaxState(List<TaxRate> taxStates) throws InvalidTaxRateException {
//
//        String taxState = "";
//
//        //Read in taxRate String and validate that the taxRate exists
//        boolean validTaxState = false;
//
//        while (!validTaxState) {
//
//            taxState = io.readString("Input the state code (i.e. IN, KY): ");
//
//            for (TaxRate currentTaxState : taxStates) {
//
//                if (taxState.equalsIgnoreCase(currentTaxState.getTaxStateName())) {
//                    validTaxState = true;
//                    break;
//                }
//
//            }
//
//            if (validTaxState) {
//                break;
//            }
//
//            io.printLine("State not found. Please select one of the following: \n");
//            taxStates.forEach((currentTaxState) -> {
//                io.print(currentTaxState.getTaxStateName() + ", ");
//            });
//
//            String keepGoing = io.readString("Try a new entry? [Y/N]: ");
//
//            if (keepGoing.equals("N")) {
//                throw new InvalidTaxRateException("");
//            }
//        }
//
//        return taxState;
//
//    }
//
//    private String getProductType(List<Spell> products) throws InvalidProductException {
//
//        boolean validProduct = false;
//        String productType = "";
//
//        //Read in String productType and validate it
//        while (!validProduct) {
//            productType = io.readString("Please input the product you wish to order: ");
//
//            for (Spell currentProduct : products) {
//                if (currentProduct.getProductType().equalsIgnoreCase(productType)) {
//                    validProduct = true;
//                    break;
//                }
//            }
//
//            if (validProduct) {
//                break;
//            }
//
//            io.printLine("Product type not found.");
//
//            io.printLine("These are the products on offer:\n");
//            products.forEach((currentProduct) -> {
//                io.print(currentProduct.getProductType() + ", ");
//            });
//
//            String keepGoing = io.readString("Continue? [Y/N]: ");
//            if (keepGoing.equals("N")) {
//                throw new InvalidProductException("");
//            }
//        }
//
//        return productType;
//
//    }
//
//    private BigDecimal getArea() {
//
//        BigDecimal min = new BigDecimal("0");
//        BigDecimal area = io.readBigDecimal("enter the floor's area in feet: ", min);
//        area = area.setScale(2, HALF_UP);
//        return area;
//
//    }
//
//    public Card getEditInfo(Card order, List<TaxRate> taxRates, List<Spell> products)
//            throws InvalidTaxRateException, InvalidProductException {
//
//        io.printLine("****Edit Order****");
//
//        String clientName = this.getEditClientName(order);
//        if (clientName != null) {
//            order.setClient(clientName);
//        } else {
//
//        }
//
//        String taxState = this.getEditState(order, taxRates);
//        if (taxState != null) {
//            order.setTaxState(taxState);
//        }
//
//        String productType = this.getEditProductType(order, products);
//
//        if (productType != null) {
//            order.setProductType(productType);
//        } else {
//
//        }
//
//        BigDecimal area = this.getEditArea(order);
//
//        if (area != null) {
//            order.setArea(area);
//        } else {
//
//        }
//        return order;
//
//    }
//
//    private String getEditClientName(Card order) {
//
//        String clientName = "";
//        boolean validName = false;
//
//        while (!validName) {
//            clientName = io.readString("Please input the client's surname -- Currently: " + order.getClient());
//            if (!(clientName == null)) {
//                if (clientName.trim().length() == 0) {
//                    return null;
//                }
//                validName = true;
//            }
//        }
//
//        return clientName;
//    }
//
//    private String getEditState(Card order, List<TaxRate> taxStates) throws InvalidTaxRateException {
//
//        String taxState = "";
//        boolean validTaxState = false;
//        while (!validTaxState) {
//
//            taxState = io.readString("Please input state code (i.e. KY, IN) -- Currently: " + order.getState());
//            if (taxState.trim().length() == 0) {
//                return null;
//            }
//
//            for (TaxRate currentTaxState : taxStates) {
//
//                if (taxState.equalsIgnoreCase(currentTaxState.getTaxStateName())) {
//                    validTaxState = true;
//                    break;
//                }
//            }
//
//            if (validTaxState) {
//                break;
//            }
//
//            io.printLine("State not found. Please select one of the following: \n");
//            taxStates.forEach((currentState) -> {
//                io.print(currentState.getTaxStateName() + ", ");
//            });
//
//            String keepGoing = io.readString("Try a new entry? [Y/N]: ");
//
//            if (keepGoing.equals("N")) {
//                throw new InvalidTaxRateException("");
//            }
//        }
//
//        return taxState;
//
//    }
//
//    private BigDecimal getEditArea(Card order) {
//
//        BigDecimal min = new BigDecimal("0");
//
//        BigDecimal area = io.readBigDecimal("Please enter the area of the floor in feet: (" + order.getArea().toString() + ")", min);
//
//        if (area == null) {
//            return null;
//        }
//        area = area.setScale(2, HALF_UP);
//        return area;
//
//    }
//
//    private String getEditProductType(Card order, List<Spell> products) throws InvalidProductException {
//
//        boolean validProduct = false;
//
//        String productType = "";
//
//        while (!validProduct) {
//
//            productType = io.readString("Please input product type -- Currently: " + order.getProductType());
//            if (productType.trim().length() == 0) {
//                return null;
//            }
//
//            for (Spell currentProduct : products) {
//                if (currentProduct.getProductType().equalsIgnoreCase(productType)) {
//                    validProduct = true;
//                    break;
//                }
//
//            }
//            if (validProduct) {
//                break;
//            }
//
//            io.printLine("Product type not found.");
//
//            io.printLine("These are the products on offer:\n");
//            products.forEach((currentProduct) -> {
//                io.print(currentProduct.getProductType() + ", ");
//            });
//
//            String keepGoing = io.readString("Continue? [Y/N]: ");
//            if (keepGoing.equals("N")) {
//                throw new InvalidProductException("");
//            }
//        }
//        return productType;
//    }
//
//    public int getOrderNumber() {
//        return io.readInt("Input an order #: ");
//    }
//
//    public String confirmMssg(String prompt) {
//        return io.readString(prompt);
//    }
//
//    public String confirmChanges(Card order, String prompt) {
//        this.displayOrder(order);
//        return io.readString(prompt);
//    }
//
//    public void displayDeleteCancellation() {
//        io.readString("Order not removed.  Please press enter to continue.");
//
//    }
//
//    public void displayRemoveSuccessful() {
//        io.readString("Order removed! Please press enter to continue.");
//    }
//
//    public void displayOrderNotFound() {
//        io.printLine("Order not found!");
//    }
//
//    public void saveSuccess() {
//        io.readString("Data Saved!  Press enter to continue.");
//    }
//
//    public void displayOrderByDateNotFound() {
//        io.printLine("Order not Found, please make "
//                + "sure you enter the correct date.\n");
//    }
//
//    public void displayEditSuccess() {
//        io.printLine("Order Edited!\n");
//
//    }
//
    public void displayErrorMessage(Exception e) {
        io.printLine(e.getMessage());

    }
//
    public void displayUnknownEntry() {
        io.printLine("Please enter a valid input!");

    }

//    public void displayAddOrderBanner() {
//        io.printLine("------Add Order-----");
//    }
//
    public void displayExitMessage() {
        io.printLine("Quitting..");
    }

    public void displayErrorMssg(String something_went_wrong__Changes_not_saved) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String requestSave(String confirmation) {
        return io.readString(confirmation);
    }
}
