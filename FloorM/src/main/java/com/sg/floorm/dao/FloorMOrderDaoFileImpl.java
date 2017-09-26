/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.dao;

import com.sg.floorm.dto.Order;
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

 

public class FloorMOrderDaoFileImpl implements FloorMOrderDao {

 

   private final Map<Integer, Order> orders = new HashMap<>();

 

   @Override

   public Order addOrder(Order order) {

       int orderNum = order.getOrderNum();
       return orders.put(orderNum, order);
   }

 

   @Override

   public Order deleteOrder(Order order) {

       int orderNum = order.getOrderNum();
       Order deletedOrder = orders.remove(orderNum);
       return deletedOrder;
   }

 

   @Override

   public Order editOrder(Order orderOld, Order orderNew) {
       int orderNum = orderOld.getOrderNum();
       return orders.put(orderNum, orderNew);

   }

 

   @Override

   public Order getOrderByNumber(int orderNum) {
       return orders.get(orderNum);
   }

 

   @Override

   public List<Order> getOrdersByDate(String date) {
       List<Order> allOrders = new ArrayList<>(orders.values());
       List<Order> orderListByDate = new ArrayList<>();

 

       allOrders.stream().filter((order) -> 
               (order.getOrderDate().equals(date))).forEachOrdered((order) -> {
           orderListByDate.add(order);
       });
       return orderListByDate;

 
   }

 
   @Override
   public List<Order> getAllOrders() {
       List<Order> orderListToReturn = new ArrayList(orders.values());
       return orderListToReturn;
   }
 
   @Override
   public Set<Integer> getAllOrderNums() {
       Set<Integer> keySet = orders.keySet();
       return keySet;
   }
 
   @Override
   public void readOData() throws FloorMPersistenceException {
       Scanner sc;
       File folder = new File(".\\Data\\Orders");
       File[] fileList = folder.listFiles();
       for (File file : fileList) {
           try {
               sc = new Scanner(new BufferedReader(new FileReader(".\\Data\\Orders\\" + file.getName())));
           } catch (FileNotFoundException e) {
               throw new FloorMPersistenceException("Error: Could not load data!");
           }
           String currentLine;
           String[] currentTokens;
           while (sc.hasNextLine()) {
               //
               currentLine = sc.nextLine();
//               currentLine = currentLine.replaceAll("[^A-Za-z0-9., ]", "");
               currentTokens = currentLine.split(",");
               int i = 0;
               for (String currentString : currentTokens) {
                   currentTokens[i] = currentString.trim();
                   i++;
               }
               int orderNum;
               orderNum = Integer.parseInt(currentTokens[0]);
               Order newOrder = new Order(orderNum);
               newOrder.setClient(currentTokens[1]);
               
               newOrder.setTaxRate(currentTokens[2]);
               
               BigDecimal taxRate = new BigDecimal(currentTokens[3]);
               newOrder.setTaxRate(taxRate);
               
               newOrder.setProductType(currentTokens[4]);
               
               BigDecimal area = new BigDecimal(currentTokens[5]);
               newOrder.setArea(area);
               
               BigDecimal costSqFoot = new BigDecimal(currentTokens[6]);
               newOrder.setCostSqFt(costSqFoot);
               
               BigDecimal laborSqFoot = new BigDecimal(currentTokens[7]);
               newOrder.setLaborCostSqFt(laborSqFoot);
               
               BigDecimal materialTotal = new BigDecimal(currentTokens[8]);
               newOrder.setMatCost(materialTotal);
               
               BigDecimal totalLabor = new BigDecimal(currentTokens[9]);
               newOrder.setLabCost(totalLabor);
               
               BigDecimal totalTax = new BigDecimal(currentTokens[10]);
               newOrder.settTax(totalTax);
               
               BigDecimal totalCost = new BigDecimal(currentTokens[11]);
               newOrder.settCost(totalCost);
 
               
               //parse once per file, not once per order per file
               String[] fileNameTokens;
               fileNameTokens = file.getName().split("_");
               String dateAndExtension = fileNameTokens[1];
               String date = dateAndExtension.substring(0, 8);
               newOrder.setOrderDate(date);
               orders.put(orderNum, newOrder);
           }
           sc.close();

 
       }
   }
 
   private List<String> getAllDates() {
       List<String> dateList = new ArrayList<>();
       List<Order> orderList = new ArrayList(orders.values());
       orderList.stream().filter((currentOrder) -> 
               (!(dateList.contains(currentOrder.getOrderDate())))).forEachOrdered((currentOrder) -> {
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
           List<Order> tempList = new ArrayList<>();
           allOrders.stream().filter((currentOrder) -> 
                   (currentOrder.getOrderDate().equals(currentDate))).forEachOrdered((currentOrder) -> {
               tempList.add(currentOrder);
           });
           ordersByDate.put(currentDate, tempList);
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