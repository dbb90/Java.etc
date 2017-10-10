/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tradewar.dao;

import com.sg.tradewar.dto.Card;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class IndexDaoImpl implements IndexDao {

    private Map<Integer, Card> cards = new HashMap<>();

    @Override
    public Card addCard (Card card) {

        int cardNum = card.getCardNum();
        return cards.put(cardNum, card);
    }

 
    @Override
    public Card deleteCard (Card card) {

        int cardNum = card.getCardNum();
        Card deletedCard = cards.remove(cardNum);
        return deletedCard;
    }



    @Override

    public Card getCardByNumber(int cardNum) {
        return cards.get(cardNum);
    }
    
      
    @Override

    public List<Card> getCardsByType(String type) {
        List<Card> allCards = new ArrayList<>(cards.values());
        List<Card> cardListByType = new ArrayList<>();

        allCards.stream()
                .filter((card) -> (card.getType().equals(type)))
                .forEachOrdered(card -> {
                    cardListByType.add(card);
                });

        return cardListByType;

    }

    @Override
    public List<Card> getAllCards() {
        return cards.values().stream().collect(Collectors.toList());
    }

    @Override
    public Set<Integer> getAllCardNums() {
        Set<Integer> keySet = cards.keySet();
        return keySet;
    }

    @Override
    public void readData() throws TradeWarPersistenceException {
//instantiates scanner
        Scanner sc = null;
// defines object container as the folder containing orders
// creates a File-type array and populates each box with a file from .\\data\\orders
// for each file obj of type File in the array "files"...
        try {
            // creates a new buffered input stream that reads in the filename using
            //file.getname by way of our scanner
            sc = new Scanner(new BufferedReader(new FileReader(".\\Data\\Cards\\cards.txt")));
            //catches the exception that occurs when there are no files for that scanner to read in
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IndexDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

            //what follows is a while loop that will run until our scanner does not have another line 
            //left to parse
            while (sc.hasNextLine()) {
                
            //the line to parse in each loop of this while loop will be
            //the next line in the given orders document
            String lineToParse = sc.nextLine();
            //splits the line we passed in into a StringArray of format {"#", "clientName", "taxRate",...}
            String[] countingBeads = lineToParse.split("::");

                //instantiates orderNum and sets it equal to 
                //the integer it parses from the first field in our array,
                //which should contain our order number
                int cardNum = Integer.parseInt(countingBeads[0]);
                // calls on Card to construct a new Card object called, 
                //for now, newOrder,
                // using orderNum as the required initial int field of the constructer
                Card newCard = new Card(cardNum);
                //sets the clientName field of this new Card object to the 2nd substring
                //lineToSplit String
                newCard.setCardName(countingBeads[1]);
                //sets the taxRate field the same way
                newCard.setType(countingBeads[2]);
                //sets taxRate, but done this way because BigDecimals are immutable and
                //thus must be new
                // cardnum::cardname::cardtype::desc::flavor::basevalue::elasticity::rarity#
                newCard.setDescription(countingBeads[3]);
                //the rest of our attributes are set in the same fashion
                newCard.setFlavorText(countingBeads[4]);

                BigDecimal baseValue = new BigDecimal(countingBeads[5]);
                newCard.setBaseValue(baseValue);

                BigDecimal elasticityFactor = new BigDecimal(countingBeads[6]);
                newCard.setElasticityFactor(elasticityFactor);
                
                int rarity = Integer.parseInt(countingBeads[7]);
                newCard.setRarity(rarity);


                //sets orderDate as the date we culled from the filename above
//                newOrder.setOrderDate(date);
                //puts this order in the Map orders, with key of orderNum and value
                //of the newly defined object attributes now set in newOrder
                cards.put(cardNum, newCard);
                // this will loop until every line of every file has been parsed and put into 
                //the map "orders"
            }
            //closes out our Scanner
            sc.close();

        }
    }


//    @Override
//    public void writeData() throws TradeWarPersistenceException {
//        File folder = new File(".\\Data\\Orders");
//        File[] fileList = folder.listFiles();
//
//        List<String> dateList = new ArrayList<>();
//        for (File currentFile : fileList) {
//            try {
//                Files.delete(currentFile.toPath());
//            } catch (IOException ex) {
//                System.err.println("invalid path: " + currentFile.getAbsolutePath());
//            }
//        }
//        dateList = this.getAllDates();
//        Map<String, List<Card>> ordersByDate = new HashMap<>();
//        List<Card> allOrders = new ArrayList(orders.values());
//
//        PrintWriter out;
//
//        for (String currentDate : dateList) {
//            List<Card> currentList = new ArrayList<>();
//            allOrders.stream()
//                    .filter((currentOrder) -> (currentOrder.getOrderDate()
//                    .equals(currentDate)))
//                    .forEachOrdered((currentOrder) -> {
//                        currentList.add(currentOrder);
//                    });
//            ordersByDate.put(currentDate, currentList);
//        }
//
//        Set<String> keySet = ordersByDate.keySet();
//        for (String key : keySet) {
//
//            try {
//                out = new PrintWriter(new FileWriter(".\\Data\\Orders\\Orders_" + key + ".txt"));
//            } catch (IOException e) {
//                throw new TradeWarPersistenceException("Could not save Order Data!");
//            }
//            List<Card> currentOrders = ordersByDate.get(key);
//            for (Card currentOrder : currentOrders) {
//                out.println(currentOrder.getOrderNum()
//                        + "," + currentOrder.getClient()
//                        + "," + currentOrder.getState()
//                        + "," + currentOrder.getTaxRate()
//                        + "," + currentOrder.getProductType()
//                        + "," + currentOrder.getArea()
//                        + "," + currentOrder.getCostSqFt()
//                        + "," + currentOrder.getLaborCostSqFt()
//                        + "," + currentOrder.getMatCost()
//                        + "," + currentOrder.getLabCost()
//                        + "," + currentOrder.gettTax()
//                        + "," + currentOrder.gettCost());
//                out.flush();
//            }
//            out.close();
//        }
//    }


