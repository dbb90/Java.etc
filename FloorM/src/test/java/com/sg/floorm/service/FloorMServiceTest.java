
package com.sg.floorm.service;

import com.sg.floorm.dto.Order;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FloorMServiceTest {
    
    private FloorMServiceLayer service;
    
    public FloorMServiceTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("tApplicationContext.xml");
        service = ctx.getBean("service" , FloorMServiceLayerImpl.class);
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


    
    //TESTS ADD ORDER METHOD
    
    @Test
    public void testAddOrder() {
        int orderNum = 1;
        Order newOrder = new Order(orderNum);
        newOrder.setOrderDate("20170101");
        newOrder.setClient("David");
        newOrder.setTaxState("KY");
        newOrder.setTaxRate(new BigDecimal("1.10"));
        newOrder.setProductType("Argesium");
        newOrder.setArea(new BigDecimal("10.00"));
        newOrder.setCostSqFt(new BigDecimal("1.00"));
        newOrder.setLaborCostSqFt(new BigDecimal("2.00"));
        newOrder.setMatCost(new BigDecimal("300.00"));
        newOrder.setLabCost(new BigDecimal("400.00"));
        newOrder.settTax(new BigDecimal("30.00"));
        newOrder.settCost(new BigDecimal("600.00"));
        
        assertNull(service.addOrder(newOrder));
        
        int twoOrderNum = 2;
        Order twoOrder = new Order(twoOrderNum);
        twoOrder.setOrderDate("20170101");
        twoOrder.setClient("David");
        twoOrder.setTaxState("KY");
        twoOrder.setTaxRate(new BigDecimal("1.10"));
        twoOrder.setProductType("Argesium");
        twoOrder.setArea(new BigDecimal("10.00"));
        twoOrder.setCostSqFt(new BigDecimal("1.00"));
        twoOrder.setLaborCostSqFt(new BigDecimal("2.00"));
        twoOrder.setMatCost(new BigDecimal("300.00"));
        twoOrder.setLabCost(new BigDecimal("400.00"));
        twoOrder.settTax(new BigDecimal("30.00"));
        twoOrder.settCost(new BigDecimal("600.00"));
        
        assertNotNull(service.addOrder(twoOrder));
    }


    @Test
    public void testGet() {
        int orderNum = 1;
        Order newOrder = new Order(orderNum);
        newOrder.setOrderDate("20170101");
        newOrder.setClient("David");
        newOrder.setTaxState("KY");
        newOrder.setTaxRate(new BigDecimal("1.10"));
        newOrder.setProductType("Argesium");
        newOrder.setArea(new BigDecimal("10.00"));
        newOrder.setCostSqFt(new BigDecimal("1.00"));
        newOrder.setLaborCostSqFt(new BigDecimal("2.00"));
        newOrder.setMatCost(new BigDecimal("300.00"));
        newOrder.setLabCost(new BigDecimal("400.00"));
        newOrder.settTax(new BigDecimal("30.00"));
        newOrder.settCost(new BigDecimal("600.00"));
        
        Order daoOrder = service.getOrder(orderNum);
        
        assertEquals(newOrder, daoOrder);
    }
    
//TEST CALCORDERNUM()
    
    @Test
    public void testCalcOrderNum() {
        Order newOrder = new Order();
        newOrder.setOrderDate("20170101");
        newOrder.setClient("David");
        newOrder.setTaxState("KY");
        newOrder.setTaxRate(new BigDecimal("1.10"));
        newOrder.setProductType("Argesium");
        newOrder.setArea(new BigDecimal("10.00"));
        newOrder.setCostSqFt(new BigDecimal("1.00"));
        newOrder.setLaborCostSqFt(new BigDecimal("2.00"));
        newOrder.setMatCost(new BigDecimal("300.00"));
        newOrder.setLabCost(new BigDecimal("400.00"));
        newOrder.settTax(new BigDecimal("30.00"));
        newOrder.settCost(new BigDecimal("600.00"));
        
        int orderNumCalced = service.calcOrderNum(newOrder).getOrderNum();
        
        assertEquals(orderNumCalced , 1);
        
    }


// TEST OF CALCCOSTS
        
    @Test
    public void testCalcCosts() throws InvalidTaxRateException, InvalidProductException {

        
        Order orderTest = new Order();
        orderTest.setOrderDate("20170101");
        orderTest.setClient("David");
        orderTest.setTaxState("KY");
        orderTest.setProductType("Argesium");
        orderTest.setArea(new BigDecimal("33.00"));
        
        orderTest = service.calcCosts(orderTest);
        
        assertEquals(new BigDecimal("2.00") , orderTest.getTaxRate());
        assertEquals(new BigDecimal("2.00") , orderTest.getCostSqFt());
        assertEquals(new BigDecimal("2.00") , orderTest.getLaborCostSqFt());
        assertEquals(new BigDecimal("66.00") , orderTest.getMatCost());
        assertEquals(new BigDecimal("66.00") , orderTest.getLabCost());
        assertEquals(new BigDecimal("2.64") , orderTest.gettTax());
        assertEquals(new BigDecimal("134.64") , orderTest.gettCost());
    }

    

    //GET TESTS
    
    @Test
    public void testGetAllTaxRates() {
        assertEquals(1 , service.getAllTaxRates().size());
    }


    @Test
    public void testGetAllProducts() {
        assertEquals(1 , service.getAllProducts().size());
    }


    @Test
    public void testGetConfig() {
        assertEquals(service.getConfig() , "Training");
    }

    
}
