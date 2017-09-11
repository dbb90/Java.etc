/*
 	 * To change this license header, choose License Headers in Project Properties.
 	 * To change this template file, choose Tools | Templates
 	 * and open the template in the editor.
 */
package com.sg.vendingmachine;

import com.sg.vendingmachine.controller.VendingMachineController;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.sg.vendingmachine.service.VendingMachineService;
import com.sg.vendingmachine.service.VendingMachineServiceFileImpl;
import com.sg.vendingmachine.ui.UserIo;
import com.sg.vendingmachine.ui.UserIoConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;

/**
 *
 * @author dbb09
 */
public class App {

    public static void main(String[] args) {

        VendingMachineDao dao = new VendingMachineDaoFileImpl();
        VendingMachineService service = new VendingMachineServiceFileImpl(dao);
        UserIo io = new UserIoConsoleImpl();
        VendingMachineView view = new VendingMachineView(io);
        VendingMachineController controller = new VendingMachineController(
                service, view);

        controller.run();
    }
}
