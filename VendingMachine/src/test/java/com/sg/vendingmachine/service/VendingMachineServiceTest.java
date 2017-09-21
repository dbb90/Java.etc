/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Product;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author dbb09
 */
public class VendingMachineServiceTest {
    
    
   private VendingMachineService service;
   

    // wire the Service Layer with stub implementations of the Dao and
    // Audit Dao
//    VendingMachineDao dao = new VendingMachineDaoStubImpl();
//    VendingMachineAuditDao auditDao = 
//              new VendingMachineAuditDaoStubImpl();
//   
//    service = new VendingMachineServiceImpl(dao, auditDao);
 
    
    
    public VendingMachineServiceTest() {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    service = 
        ctx.getBean("service", VendingMachineService.class);
    }

@BeforeClass
   public static void setUpClass() {
}

   
   @AfterClass
   public static void tearDownClass() {
   }

   

   @Before
   public void setUp() {
   }

   

   @After
   public void tearDown() {
   }

 

   /**

     * ProcessPurchase exceptions test

     * 

     */

   

   @Test
   public void testException() throws Exception {

       List<Product> products = service.getProductsInStock();
       BigDecimal NotEnoughFunds = new BigDecimal("0.01");
       
       

       try {
           service.processPurchase(NotEnoughFunds, products.get(0));
           fail("Expected NotEnoughMoneyException");
       } catch (NotEnoughMoneyException e) {

       }
   }

 

   /**

     * Test of checkItemInventory method, of class VendingMachineService.

     */

   @Test

   public void testGetProducts() throws Exception {

       List<Product> products = service.getProductsInStock();

       

       service.checkInv(products.get(0));

       

       Product product = new Product("Shasta");
       product.setProductPrice(new BigDecimal("1.00"));
       product.setNumberOfProducts(0);

       

       try {
           service.checkInv(product);
           fail("Expected ProductNotStockedException");
       } catch (ProductNotStockedException e){
       }
   }

 

   /**

     * Test of checkUserChoice

     */

   @Test

   public void testCheckUserChoice() throws Exception {

       List<Product> products = service.getProductsInStock();
       int rightChoice = 1;
       int wrongChoice = 66;

       

       service.processUserChoice(rightChoice);

       

//       try {
//           service.processUserChoice(wrongChoice);
//           fail("Expected ArrayOOBException");
//
//       } catch (ArrayOOBException e) {
//       }


}}

       

 