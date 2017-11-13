/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.phonereplacer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dbb09
 */
public class PhoneReplacer {

    public class MatcherExample {

        public static void main(String[] args) {

            String text
                    = "This is the text to be searched "
                    + "for occurrences of the http:// pattern.";

            String patternString = ".*http://.*";

            Pattern pattern = Pattern.compile(patternString);

            Matcher matcher = pattern.matcher(text);
            boolean matches = matcher.matches();
        }
    }

    public void readOData() throws ODataPersistenceException {
//instantiates scanner
        Scanner sc;
// defines object container as the folder containing orders
        File container = new File(".\\Data\\HTMLs");
// creates a File-type array and populates each box with a file from .\\data\\orders
        File[] files = container.listFiles();
// for each file obj of type File in the array "files"...
        for (File file : files) {
            try {
                // creates a new buffered input stream that reads in the filename using 
                //file.getname by way of our scanner
                sc = new Scanner(new BufferedReader(new FileReader(".\\Data\\Orders\\" + file.getName())));
                //catches the exception that occurs when there are no files for that scanner to read in
            } catch (FileNotFoundException ex) {
                // throws that exception as a persistence exception (String type)
                throw new ODataPersistenceException("Hey!");
            }
            //initializes our String and String Arrays for use in the next segment
            String lineToParse;
            String[] countingBeads;

            //what follows is a while loop that will run until our scanner does not have another line 
            //left to parse
            while (sc.hasNextLine()) {
                //the line to parse in each loop of this while loop will be 
                //the next line in the given orders document
                lineToParse = sc.nextLine();
                //splits the line we passed in into a StringArray of format {"#", "clientName", "taxRate",...


    //instantiates orderNum and sets it equal to 
    //the integer it parses from the first field in our array,
    //which should contain our order number
    int orderNum = Integer.parseInt(countingBeads[0]);
    // calls on Order to construct a new Order object called, 
    //for now, newOrder,
    // using orderNum as the required initial int field of the constructer
    Order newOrder = new Order(orderNum);
    //sets the clientName field of this new Order object to the 2nd substring
    //lineToSplit String

    newOrder.setClient (countingBeads 

    [1]);
                //sets the taxRate field the same way
    newOrder.setTaxState (countingBeads 
    [2]);
                //sets taxRate, but done this way because BigDecimals are immutable and
                //thus must be new
                BigDecimal taxRate = new BigDecimal(countingBeads[3]);

    newOrder.setTaxRate (taxRate);
    //the rest of our attributes are set in the same fashion

    newOrder.setProductType (countingBeads 
    [4]);

                BigDecimal area = new BigDecimal(countingBeads[5]);

    newOrder.setArea (area);

    BigDecimal costSqFoot = new BigDecimal(countingBeads[6]);

    newOrder.setCostSqFt (costSqFoot);

    BigDecimal laborSqFoot = new BigDecimal(countingBeads[7]);

    newOrder.setLaborCostSqFt (laborSqFoot);

    BigDecimal materialTotal = new BigDecimal(countingBeads[8]);

    newOrder.setMatCost (materialTotal);

    BigDecimal totalLabor = new BigDecimal(countingBeads[9]);

    newOrder.setLabCost (totalLabor);

    BigDecimal totalTax = new BigDecimal(countingBeads[10]);

    newOrder.settTax (totalTax);

    BigDecimal totalCost = new BigDecimal(countingBeads[11]);

    newOrder.settCost (totalCost);

    //sets orderDate as the date we culled from the filename above
    newOrder.setOrderDate (date);
    //puts this order in the Map orders, with key of orderNum and value
    //of the newly defined object attributes now set in newOrder

    orders.put (orderNum, newOrder);
    // this will loop until every line of every file has been parsed and put into 
    //the map "orders"
}
//closes out our Scanner
sc.close();

        }
    }

    private List<String> getAllDates() {
        List<String> dateList = new ArrayList<>();
        List<Order> orderList = new ArrayList(orders.values());
        orderList.stream()
                .filter((currentOrder) -> (!(dateList.contains(currentOrder.getOrderDate()))))
                .forEachOrdered((currentOrder) -> {
                    dateList.add(currentOrder.getOrderDate());
                });
        return dateList;
    }

    @Override
        public void writeOData() throws FloorMPersistenceException {
        File folder = new File(".\\Data\\Orders");
        File[] fileList = folder.listFiles();

        List<String> dateList = new ArrayList<>();
        for (File currentFile : fileList) {
            try {
                Files.delete(currentFile.toPath());
            } catch (IOException ex) {
                System.err.println("invalid path: " + currentFile.getAbsolutePath());
            }
        }
        dateList = this.getAllDates();
        Map<String, List<Order>> ordersByDate = new HashMap<>();
        List<Order> allOrders = new ArrayList(orders.values());

        PrintWriter out;

        for (String currentDate : dateList) {
            List<Order> currentList = new ArrayList<>();
            allOrders.stream()
                    .filter((currentOrder) -> (currentOrder.getOrderDate()
                    .equals(currentDate)))
                    .forEachOrdered((currentOrder) -> {
                        currentList.add(currentOrder);
                    });
            ordersByDate.put(currentDate, currentList);
        }

        Set<String> keySet = ordersByDate.keySet();
        for (String key : keySet) {

            try {
                out = new PrintWriter(new FileWriter(".\\Data\\Orders\\Orders_" + key + ".txt"));
            } catch (IOException e) {
                throw new FloorMPersistenceException("Could not save Order Data!");
            }
            List<Order> currentOrders = ordersByDate.get(key);
            for (Order currentOrder : currentOrders) {
                out.println(currentOrder.getOrderNum()
                        + "," + currentOrder.getClient()
                        + "," + currentOrder.getState()
                        + "," + currentOrder.getTaxRate()
                        + "," + currentOrder.getProductType()
                        + "," + currentOrder.getArea()
                        + "," + currentOrder.getCostSqFt()
                        + "," + currentOrder.getLaborCostSqFt()
                        + "," + currentOrder.getMatCost()
                        + "," + currentOrder.getLabCost()
                        + "," + currentOrder.gettTax()
                        + "," + currentOrder.gettCost());
                out.flush();
            }
            out.close();
        }
    }

}
