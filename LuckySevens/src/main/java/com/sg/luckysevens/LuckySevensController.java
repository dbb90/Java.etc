/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevens;

import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dbb09
 */
@Controller
public class LuckySevensController {

    @RequestMapping(value = "/bankroll",
            method = RequestMethod.POST)
    public String bankroll(HttpServletRequest request,
            Map<String, Object> model) {
        int totalRolls = 0;
        int rollsAtMax = 0;
        Random r = new Random();

        String input
                = request.getParameter("bankrollAmount");
        int chipstack = Integer.parseInt(input);
        int max = chipstack;
        int initialStack = chipstack;

        //Play Lucky Sevens!
        while (chipstack > 0) {
            totalRolls++;
            if (1 + r.nextInt(6) == 1 + r.nextInt(6)) {
                chipstack += 4;
                if (max < chipstack) {
                    max = chipstack;
                    rollsAtMax = totalRolls;
                }

            } else {
                chipstack--;
            }
        }

        model.put("chipstack", chipstack);
        model.put("max", max);
        model.put("rollsAtMax", rollsAtMax);
        model.put("totalRolls", totalRolls);
        model.put("initialStack", initialStack);
        return "result";
    }
}
