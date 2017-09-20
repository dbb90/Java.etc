/*
 	 * To change this license header, choose License Headers in Project Properties.
 	 * To change this template file, choose Tools | Templates
 	 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Product;
import java.util.List;

/**
 *
 * @author dbb09
 */
public class VendingMachineView {

    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public void displayChoicePrompt() {
        io.print("The following products are in stock: ");
    }

    public int displayProducts(List<Product> listOfStockedProducts) {

        for (int i = 0; i < listOfStockedProducts.size(); i++) {
            Product product = listOfStockedProducts.get(i);
            io.print((i+ 1) + ": " + product.getProductName() + " - $" + product.getProductPrice());
        }

        io.print("\nSelect a number to the left of the product, or "
                + "enter 0 to quit.");

        return io.readInt("\nEnter selection: ", 0, (listOfStockedProducts.size()));
    }
    
    public Product displayUserProductChoice(int userChoice, List<Product> products) {
        Product product = products.get(userChoice);
        io.print("\nSELECTION: " + product.getProductName());
        io.print("\n");
        return product;
    }

    public String getCashInput() {
        return io.readString("Insert bill/coins at this time!");
    }

    public void displayRemainingProductInv(Product product) {
        product.setNumberOfProducts((product.getNumOfProductsStocked() - 1));
        io.readString(product.getNumOfProductsStocked() + " " + product.getProductName() + "(s) remaining."
        + "\n\n Please press enter.\n");
    }


    public void displayChange(Change change) {
        
    {
            io.print("Quarter(s): " + change.getQuarters());
            io.print("Dime(s): " + change.getDimes());
            io.print("Nickel(s): " + change.getNickels());
            io.print("Penny(s): " + change.getPennies());
        }}

    public void displaySuccessBanner() {
        io.print("Enjoy your purchase!\n\n");
    }

    public void displayIntroBanner() {
        io.print("-----VENDING MACHINE-----\n\n"); }

    public void displayErrorMessage(String errorMsg) {
        io.print("Error:" + errorMsg);
        io.readString("Press enter to continue, or enter 0 to quit.");
 
    }
    
  //  public void checkErrorResponse() {
  //
  //  }
    
    
    public void displayExitBanner() {
        io.print("Thank you for your patronage!");
    }
}