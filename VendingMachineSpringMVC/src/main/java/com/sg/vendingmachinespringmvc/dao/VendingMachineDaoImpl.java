/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineDaoImpl implements VendingMachineDao {
    
    private Map<Integer, Item> items = new HashMap<>();
    private Change change = new Change();
    private static int idCounter = 1;
    
    public VendingMachineDaoImpl() {
        Item item1 = new Item();
        item1.setId(1);
        item1.setName("Snickers");
        item1.setPrice(new BigDecimal("1.50"));
        item1.setQuantity(10);
        
        items.put(item1.getId(), item1);
    
    }

    @Override
    public Item addItem(Item item) {
        item.setId(idCounter);
        items.put(item.getId(), item);
        idCounter++;
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
//insert code
return null;
    }

    @Override
    public Item getItemById(int itemId) {
        return items.get(itemId);
    }
}
