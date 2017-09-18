/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoFileImpl;
import com.sg.classroster.dto.Student;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;
import java.util.List;


/**
 *
 * @author dbb09
 */
	public class ClassRosterController {

	    ClassRosterView view = new ClassRosterView();
            ClassRosterDao dao = new ClassRosterDaoFileImpl();
	    private UserIO io = new UserIOConsoleImpl();

	    public void run() {
	        boolean keepGoing = true;
	        int menuSelection = 0;
	        while (keepGoing) {
	            
	            menuSelection = getMenuSelection();

	            switch (menuSelection) {
	                case 1:
	                    listStudents();
	                    break;
	                case 2:
	                    createStudent();
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
            
            private void createStudent() {
	    view.displayCreateStudentBanner();
	    Student newStudent = view.getNewStudentInfo();
	    dao.addStudent(newStudent.getStudentId(), newStudent);
	    view.displayCreateSuccessBanner();
	}
	 
            private void listStudents() {
                view.displayDisplayAllBanner();
                List<Student> studentList = dao.getAllStudents();
                view.displayStudentList(studentList);
            }
            
            
            
            
            
	}
	
  