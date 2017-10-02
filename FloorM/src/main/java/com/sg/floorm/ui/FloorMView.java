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

    public int printTMenuAndGetSelection(int min, int max) {
        io.printLine("\n////Throw It On The Ground Flooring Co.////");
        io.printLine("\n********MENU********");
        io.printLine("\n********Training Mode********");
        io.printLine("[1] Display Orders");
        io.printLine("[2] Add Order");
        io.printLine("[3] Edit Order");
        io.printLine("[4] Delete Order");
        io.printLine("[5] Save");
        io.printLine("[6] Quit");
        return io.readInt("Selection: ");
    }
    
        public int printPMenuAndGetSelection(int min, int max) {
        io.printLine("\n////Throw It On The Ground Flooring Co.////");
        io.printLine("\n********MENU********");
        io.printLine("[1] Display Orders");
        io.printLine("[2] Add Order");
        io.printLine("[3] Edit Order");
        io.printLine("[4] Delete Order");
        io.printLine("[5] Save");
        io.printLine("[6] Quit");
        return io.readInt("Selection: ");
    }

    public void displayOrdersByDate(List<Order> orders, String date) {

        if (!(orders.isEmpty())) {
            io.printLine("**** " + date + " ****\n");
            //a lambda that performs displayOrder for each order on the date specified, unless
            //orders is empty
            orders.forEach((order) -> this.displayOrder(order));

        } else {
            //this happens when orders is empty on date given
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

    public Order getNewOrderVars(List<TaxRate> taxStates, List<Product> products) throws InvalidTaxRateException, InvalidProductException {

        String orderDate = this.getDate();
        String client = this.getClient();
        String taxState = this.getTaxState(taxStates);
        String productType = this.getProductType(products);
        BigDecimal area = this.getArea();
        Order orderNew = new Order();
        orderNew.setOrderDate(orderDate);
        orderNew.setClient(client);
        orderNew.setTaxState(taxState);
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
            
            
//          Attempting to fix the date parse from LocalDate.now(); so that I can flip the rest of the dates to match spec


//          DateTimeFormatter formatters = DateTimeFormatter.ofPattern("ddMMyyyy");
//          String text = date.format(formatters);
//          LocalDate orderDateDate = LocalDate.parse(text, formatters);
            
            orderDate = date;
        } else {
            while (!valiDate) {

                orderDate = io.readString("Please input date as yyyyMMdd such as (20171225) :");

                // matches here contains regex b to ensure the beginning and ending of the string are null,
                // and those null values surround 8 digits 0-9
                
                if (!(orderDate == null) && !(orderDate.equals("")) && (orderDate.matches("\\b\\d{8}\\b"))) {
                    valiDate = this.validateDate(orderDate, DATEFORMAT);
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
                validDate = this.validateDate(orderDate, DATEFORMAT);
                if (!validDate) {
                    io.printLine("You must enter a valid date!");
                }
            } else {
                io.printLine("please use format MMddyyyy");
            }
        }

        return orderDate;

    }

    public boolean validateDate(String dateToValidate, String dateFormat) {

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

    public String getTaxState(List<TaxRate> taxStates) throws InvalidTaxRateException {

        String taxState = "";

        //Read in taxRate String and validate that the taxRate exists
        boolean validTaxState = false;

        while (!validTaxState) {

            taxState = io.readString("Input the state code (i.e. IN, KY): ");

            for (TaxRate currentTaxState : taxStates) {

                if (taxState.equalsIgnoreCase(currentTaxState.getTaxStateName())) {
                    validTaxState = true;
                    break;
                }

            }

            if (validTaxState) {
                break;
            }

            io.printLine("State not found. Please select one of the following: \n");
            taxStates.forEach((currentTaxState) -> {
                io.print(currentTaxState.getTaxStateName() + ", ");
            });

            String keepGoing = io.readString("Try a new entry? [Y/N]: ");

            if (keepGoing.equals("N")) {
                throw new InvalidTaxRateException("");
            }
        }

        return taxState;

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

       public Order getEditInfo (Order order , List<TaxRate> taxStatesList , List<Product> productList) 
        throws InvalidTaxRateException , InvalidProductException {
        io.printLine("----EDIT----");
        String clientName = this.getEditClientName(order);
        if (clientName != null) {
            order.setClient(clientName);
        } else {

        }
        String state = this.getEditState(order, taxStatesList);
        if (state != null) {
            order.setTaxState(state);
        } else {
            
        }
        String productType = this.getEditProductType(order , productList);
        if (productType != null) {
            order.setProductType(productType);
        } else {
            
        }
        BigDecimal area = this.getEditArea(order);
        if (area != null) {
            order.setArea(area);
        } else {
            
        }
        return order;
    }
    

private String getEditClientName(Order order) {
       String clientName = "";
       boolean validClient = false;
       while (!validClient) {
           clientName = io.readString("Please input the client's name: (" + order.getClient() + ")");
           if (!(clientName == null)) {
               if (clientName.trim().length() == 0) {
                   return null;
               }
               validClient = true;
           }
       }
       return clientName;
   }
   
   private String getEditState(Order order , List<TaxRate> taxStatesList) throws InvalidTaxRateException {
       String taxState = "";
       boolean validTaxState = false;
       while (!validTaxState) 

           taxState = io.readString("Please input the state in which the customer is located: (" + order.getState()+ ")");
           if (taxState.trim().length() == 0) {
               return null;
           }
           
           for (TaxRate currentTaxState : taxStatesList) {
               if (taxState.equalsIgnoreCase(currentTaxState.getTaxStateName())) {
                   validTaxState = true;
                   break;
               }
           }
           if (validTaxState) {
            
           }
           io.printLine("State not found.");
           io.printLine("These are the state options : \n");
           for (TaxRate currentTaxState : taxStatesList ) {
               io.print(currentTaxState.getTaxStateName()+ ", ");
           }
           io.printLine("We don't operate there.");
           io.printLine("Prerss N to return to the menu.");
           String keepGoing = io.readString("Try Again? [Y/N]: ");
           if (keepGoing.equalsIgnoreCase("N")) {
               io.printLine("Sorry!");
               throw new InvalidTaxRateException("");
           }
       
       return taxState;
   }

   
   private BigDecimal getEditArea(Order order) {
       
       //create BigDecimal value of zero to set minimum input
       BigDecimal min = new BigDecimal("0");
       BigDecimal area = io.readBigDecimal("Please enter the area of the floor to be covered: (" + order.getArea().toString() + ")", min);
       if (area == null) {
           return null;
       }
       area = area.setScale(2, HALF_UP);
       return area;
   }
   
   private String getEditProductType(Order order , List<Product> productList) throws InvalidProductException {
       boolean validProduct = false;
       String productType = "";
       //Read in productType String and validate that the product is in our files
       while (!validProduct) {
           productType = io.readString("Please input the type of product to be ordered: (" + order.getProductType() + ")");
           if (productType.trim().length() == 0) {
               return null;
           }
           for (Product currentProduct : productList) {
               if (currentProduct.getProductType().equalsIgnoreCase(productType)) {
                   validProduct = true;
                   break;
               }
           }
           if (validProduct) {
               break;
           }
           io.printLine("The product you have entered was not found. Please check the spelling of the product type you have entered.");
           io.printLine("These are the products that we carry :\n");
           for (Product currentProduct : productList) {
               io.print(currentProduct.getProductType() + ", ");
           }
           io.printLine("\n\nIf the product you are looking for is not in this list, then we do not carry that type of flooring. Press N to return"
                   + "to the main menu. Press Y to try again!");
           String keepGoing = io.readString("Would you like to continue? Y or N : ");
           if (keepGoing.equalsIgnoreCase("N")) {
               
               io.printLine("Sorry for the inconvenience!!");throw new InvalidProductException("Sorry for the inconvenience!");
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

    public void displayErrorMssg(String something_went_wrong__Changes_not_saved) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String requestSave(String confirmation) {
        return io.readString(confirmation);
    }
}

