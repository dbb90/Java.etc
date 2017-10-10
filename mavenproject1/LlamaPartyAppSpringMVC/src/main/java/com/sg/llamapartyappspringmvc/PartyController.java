/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.llamapartyappspringmvc;

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
public class PartyController {

        @RequestMapping(value = "/rsvpForm",
            method = RequestMethod.GET)
    
    public String rsvpForm(HttpServletRequest request,
            Map<String, Object> model) {
          
        return "rsvpForm";}
    
    @RequestMapping(value = "/rsvpAnswer",
            method = RequestMethod.POST)
    
    public String rsvpAnswer(HttpServletRequest request,
            Map<String, Object> model) {
                String rsvpYes
                = request.getParameter("rsvpYes");
                String rsvpName
                = request.getParameter("rsvpName");
          //      int rsvpYesNo = Integer.parseInt(rsvpYes);
  

        model.put("rsvpYes", rsvpYes);
        model.put("rsvpName", rsvpName);
        return "rsvp";
    }
}
