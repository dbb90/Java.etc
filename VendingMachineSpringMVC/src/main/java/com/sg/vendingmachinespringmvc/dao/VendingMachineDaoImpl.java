/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineDaoImpl implements VendingMachineDao {
    
    private Map<Integer, Item> items = new HashMap<>();
//    private Change change = new Change();
    
    public VendingMachineDaoImpl() {
        Item item1 = new Item();
        item1.setId(1);
        item1.setName("Snickers");
        item1.setPrice(new BigDecimal("1.50"));
        item1.setQuantity(10);
        
        items.put(item1.getId(), item1);
        
        Item item2 = new Item();
        item2.setId(2);
        item2.setName("M&M's");
        item2.setPrice(new BigDecimal("1.25"));
        item2.setQuantity(8);
        
        items.put(item2.getId(), item2);
        
        Item item3 = new Item();
        item3.setId(3);
        item3.setName("Almond Joy");
        item3.setPrice(new BigDecimal("1.25"));
        item3.setQuantity(11);
        
        items.put(item3.getId(), item3);
        
        Item item4 = new Item();
        item4.setId(4);
        item4.setName("Milky Way");
        item4.setPrice(new BigDecimal("1.65"));
        item4.setQuantity(3);
        
        items.put(item4.getId(), item4);
        
        Item item5 = new Item();
        item5.setId(5);
        item5.setName("Payday");
        item5.setPrice(new BigDecimal("1.75"));
        item5.setQuantity(2);
        
        items.put(item5.getId(), item5);
        
        Item item6 = new Item();
        item6.setId(6);
        item6.setName("Reese's");
        item6.setPrice(new BigDecimal("1.50"));
        item6.setQuantity(5);
        
        items.put(item6.getId(), item6);
        
        Item item7 = new Item();
        item7.setId(7);
        item7.setName("Pringles");
        item7.setPrice(new BigDecimal("2.35"));
        item7.setQuantity(4);
        
        items.put(item7.getId(), item7);
        
        Item item8 = new Item();
        item8.setId(8);
        item8.setName("Cheez-its");
        item8.setPrice(new BigDecimal("2.00"));
        item8.setQuantity(6);
        
        items.put(item8.getId(), item8);
        
        Item item9 = new Item();
        item9.setId(9);
        item9.setName("Doritos");
        item9.setPrice(new BigDecimal("1.95"));
        item9.setQuantity(7);
        
        items.put(item9.getId(), item9);
    }

 @Override

   public Item addItem(Item item) {
       items.put(item.getId(), item);
       return item;
   }

    @Override
    public void removeItem(int itemId) {
        items.remove(itemId);
    }

    @Override
    public void updateItem(Item item) {
        items.put(item.getId(), item);
    }

    @Override
    public List<Item> getAllItems() {
        Collection<Item> itemsCollection = items.values();
        return new ArrayList(itemsCollection);
    }

    @Override
    public Item getItemById(int itemId) {
        return items.get(itemId);
    }
    
//    @Override
//    public int getChange(Change change) {
//        int quarters = change.getQuarters();
//        int dimes = change.getDimes();
//        int nickels = change.getNickels();
//        int pennies = change.getPennies();
//
//        
//    }
}




