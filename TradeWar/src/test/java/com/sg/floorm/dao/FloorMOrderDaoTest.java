/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm.dao;

public class FloorMOrderDaoTest {

//    private IndexDao dao = new IndexDaoImpl();
//
//    public FloorMOrderDaoTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        List<Card> orderList = dao.getAllOrders();
//        for (Card currentOrder : orderList) {
//            dao.deleteOrder(currentOrder);
//        }
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void testAddAndGetOrder() {
//
//        int orderNum = 1;
//        Card newOrder = new Card(orderNum);
//
//        newOrder.setOrderDate("01012017");
//        newOrder.setClient("David");
//        newOrder.setTaxState("KY");
//        newOrder.setTaxRate(new BigDecimal("1.10"));
//        newOrder.setProductType("Argesium");
//        newOrder.setArea(new BigDecimal("10.00"));
//        newOrder.setCostSqFt(new BigDecimal("1.00"));
//        newOrder.setLaborCostSqFt(new BigDecimal("2.00"));
//        newOrder.setMatCost(new BigDecimal("300.00"));
//        newOrder.setLabCost(new BigDecimal("400.00"));
//        newOrder.settTax(new BigDecimal("30.00"));
//        newOrder.settCost(new BigDecimal("600.00"));
//
//        dao.addOrder(newOrder);
//
//        Card orderFromDao = dao.getOrderByNumber(1);
//        assertEquals(orderFromDao.getClient(), (newOrder.getClient()));
//        assertEquals(orderFromDao.getOrderNum(), newOrder.getOrderNum());
//        assertEquals(orderFromDao.getArea(), newOrder.getArea());
//
//        orderFromDao = dao.getOrderByNumber(2);
//        assertNull(orderFromDao);
//    }
//
//    @Test
//    public void testDeleteOrder() {
//
//        int orderNum = 1;
//        Card newOrder = new Card(orderNum);
//
//        newOrder.setOrderDate("01012017");
//        newOrder.setClient("David");
//        newOrder.setTaxState("KY");
//        newOrder.setTaxRate(new BigDecimal("1.10"));
//        newOrder.setProductType("Argesium");
//        newOrder.setArea(new BigDecimal("10.00"));
//        newOrder.setCostSqFt(new BigDecimal("1.00"));
//        newOrder.setLaborCostSqFt(new BigDecimal("2.00"));
//        newOrder.setMatCost(new BigDecimal("300.00"));
//        newOrder.setLabCost(new BigDecimal("400.00"));
//        newOrder.settTax(new BigDecimal("30.00"));
//        newOrder.settCost(new BigDecimal("600.00"));
//
//        dao.addOrder(newOrder);
//
//        assertEquals(dao.getAllOrders().size(), 1);
//        dao.deleteOrder(newOrder);
//        assertEquals(dao.getAllOrders().size(), 0);
//
//    }
//
//    @Test
//    public void testGetOrdersByDate() {
//        Card newOrder = new Card(1);
//        newOrder.setOrderDate("01012017");
//        newOrder.setClient("David");
//        newOrder.setTaxState("KY");
//        newOrder.setTaxRate(new BigDecimal("1.10"));
//        newOrder.setProductType("Argesium");
//        newOrder.setArea(new BigDecimal("10.00"));
//        newOrder.setCostSqFt(new BigDecimal("1.00"));
//        newOrder.setLaborCostSqFt(new BigDecimal("2.00"));
//        newOrder.setMatCost(new BigDecimal("300.00"));
//        newOrder.setLabCost(new BigDecimal("400.00"));
//        newOrder.settTax(new BigDecimal("30.00"));
//        newOrder.settCost(new BigDecimal("600.00"));
//        dao.addOrder(newOrder);
//
//        Card twoOrder = new Card(2);
//        twoOrder.setOrderDate("01022017");
//        twoOrder.setClient("David");
//        twoOrder.setTaxState("KY");
//        twoOrder.setTaxRate(new BigDecimal("1.10"));
//        twoOrder.setProductType("Argesium");
//        twoOrder.setArea(new BigDecimal("10.00"));
//        twoOrder.setCostSqFt(new BigDecimal("1.00"));
//        twoOrder.setLaborCostSqFt(new BigDecimal("2.00"));
//        twoOrder.setMatCost(new BigDecimal("300.00"));
//        twoOrder.setLabCost(new BigDecimal("400.00"));
//        twoOrder.settTax(new BigDecimal("30.00"));
//        twoOrder.settCost(new BigDecimal("600.00"));
//        dao.addOrder(twoOrder);
//                
//        Card threeOrder = new Card(3);
//        threeOrder.setOrderDate("01032017");
//        threeOrder.setClient("David");
//        threeOrder.setTaxState("KY");
//        threeOrder.setTaxRate(new BigDecimal("1.10"));
//        threeOrder.setProductType("Argesium");
//        threeOrder.setArea(new BigDecimal("10.00"));
//        threeOrder.setCostSqFt(new BigDecimal("1.00"));
//        threeOrder.setLaborCostSqFt(new BigDecimal("2.00"));
//        threeOrder.setMatCost(new BigDecimal("300.00"));
//        threeOrder.setLabCost(new BigDecimal("400.00"));
//        threeOrder.settTax(new BigDecimal("30.00"));
//        threeOrder.settCost(new BigDecimal("600.00"));
//        dao.addOrder(threeOrder);
//
//        assertEquals(dao.getAllOrders().size(), 3);
//
//        List<Card> ordersByDate = dao.getOrdersByDate("01012017");
//
//        assertEquals(ordersByDate.size(), 1);
//
//    }

}
