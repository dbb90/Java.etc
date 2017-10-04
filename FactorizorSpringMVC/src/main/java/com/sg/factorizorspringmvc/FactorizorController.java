/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizorspringmvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dbb09
 */
@Controller
public class FactorizorController {

    @RequestMapping(value = "/factorNumber",
            method = RequestMethod.POST)
    public String factorNumber(HttpServletRequest request,
            Map<String, Object> model) {
        //list to hold our factors
        List<Integer> factorList = new ArrayList<>();
        //sum to help calc whether or not num is perfect
        int factorSum = 0;
        boolean isPrime = false;
        boolean isPerfect = false;
        //get input from user n convert it to int
       
        String input
                = request.getParameter("numberToFactor");
        int numberToFactor = Integer.parseInt(input);
        
        //Factor that number!
        for (int i = 1; i < numberToFactor; i++) {
            if (numberToFactor % i == 0) {
                //i goes into num evenly so it is a factor, adds to list
                factorList.add(i);
                factorSum += i;
            }
        }
        
        if (factorSum == numberToFactor) {
            isPerfect = true;
        }
        
        if (factorSum == 1) {
            isPrime = true;
        }
        
        
        model.put("numberToFactor", numberToFactor);
        model.put("factors", factorList);
        model.put("isPrime", isPrime);
        model.put("isPerfect", isPerfect);
        return "result";
    }
}
