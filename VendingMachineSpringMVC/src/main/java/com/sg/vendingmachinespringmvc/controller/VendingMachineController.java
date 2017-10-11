package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.model.Item;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VendingMachineController {

    private VendingMachineDao dao;

    @Inject
    public VendingMachineController(VendingMachineDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayIndex(Model model) {
        
        List<Item> items = dao.getAllItems();

        model.addAttribute("items", items);

        return "index";
    }
    
    @RequestMapping(value = "/purchaseItem", method = RequestMethod.POST)
    public String purchaseItem(Model model) {
     
      //  int itemid = 
      //  dao.getItemById(itemid)
      
      //model.addAttribute("item", item);
      
         return null;
       
    }
    
    
}
