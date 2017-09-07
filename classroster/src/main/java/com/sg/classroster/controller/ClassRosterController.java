/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.controller;

import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;


/**
 *
 * @author dbb09
 */
	public class ClassRosterController {

	    ClassRosterView view = new ClassRosterView();
	    private UserIO io = new UserIOConsoleImpl();

	    public void run() {
	        boolean keepGoing = true;
	        int menuSelection = 0;
	        while (keepGoing) {
	            
	            menuSelection = getMenuSelection();

	            switch (menuSelection) {
	                case 1:
	                    io.print("LIST STUDENTS");
	                    break;
	                case 2:
	                    io.print("CREATE STUDENT");
	                    break;
	                case 3:
	                    io.print("VIEW STUDENT");
	                    break;
	                case 4:
	                    io.print("REMOVE STUDENT");
	                    break;
	                case 5:
	                    keepGoing = false;
	                    break;
	                default:
	                    io.print("UNKNOWN COMMAND");
	            }

	        }
	        io.print("GOOD BYE");
	    }
	    
	    private int getMenuSelection() {
	        return view.printMenuAndGetSelection();
	    }
	    
	}
	
  