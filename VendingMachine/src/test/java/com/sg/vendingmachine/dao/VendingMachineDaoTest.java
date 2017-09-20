
package com.sg.vendingmachine.dao;

 

import com.sg.vendingmachine.dto.Product;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

 

/**
 *
 * @author dbb09
 */

public class VendingMachineDaoTest {

    private VendingMachineDao dao = new VendingMachineDaoFileImpl();
    
    public VendingMachineDaoTest() {

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() throws Exception {

        List<Product> products = dao.getAllProducts();
        for (Product product : products) {
            dao.removeProduct(product.getProductName());
        }
    }

    @After

    public void tearDown() {
    }

    /**
     *
     * Test of addProduct
     *
     */
    @Test
    public void testAddProduct() throws Exception {

        Product product = new Product("Dr Pepper");
        product.setProductPrice(new BigDecimal("2.00"));
        product.setNumberOfProducts(100);

        dao.addProduct(product.getProductName(), product);
        Product newDao = dao.getProduct(product.getProductName());
        assertEquals(product, newDao);

    }

    /**
     *
     * Test of getAll
     *
     */
    @Test

    public void testGetAll() throws Exception {

        Product prodOne = new Product("Dr Pepper");
        prodOne.setProductPrice(new BigDecimal("2.00"));
        prodOne.setNumberOfProducts(100);

        dao.addProduct(prodOne.getProductName(), prodOne);

        Product prodTwo = new Product("Dr Thunder");
        prodTwo.setProductPrice(new BigDecimal("2.00"));
        prodTwo.setNumberOfProducts(100);

        dao.addProduct(prodTwo.getProductName(), prodTwo);

        Product prodThree = new Product("Mt Dew");
        prodThree.setProductPrice(new BigDecimal("2.00"));
        prodThree.setNumberOfProducts(100);

        dao.addProduct(prodOne.getProductName(), prodThree);

        assertEquals(3, dao.getAllProducts().size());

    }

    /**
     *
     * Test of removeProduct
     */
    
    
    @Test
    public void testRemove() throws Exception {

        Product prodOne = new Product("Dr Pepper");
        prodOne.setProductPrice(new BigDecimal("2.00"));
        prodOne.setNumberOfProducts(100);

        dao.addProduct(prodOne.getProductName(), prodOne);

        Product prodTwo = new Product("Dr Thunder");
        prodTwo.setProductPrice(new BigDecimal("2.00"));
        prodTwo.setNumberOfProducts(100);

        dao.addProduct(prodTwo.getProductName(), prodTwo);
        
        dao.removeProduct("Dr Pepper");

        assertEquals(1, dao.getAllProducts().size());

        assertNull(dao.getProduct("Dr Pepper"));

        dao.removeProduct("Dr Thunder");

        assertEquals(0, dao.getAllProducts().size());

        assertNull(dao.getProduct("Dr Thunder"));

    }

    /**
     *
     * Test of editProduct
     *
     */
    
    @Test
    public void testEditProduct() throws Exception {

        Product prodOne = new Product("Dr Pepper");
        prodOne.setProductPrice(new BigDecimal("2.00"));
        prodOne.setNumberOfProducts(100);

        dao.addProduct(prodOne.getProductName(), prodOne);

        Product prodTwo = new Product("Dr Pepper");
        prodTwo.setProductPrice(new BigDecimal("2.00"));
        prodTwo.setNumberOfProducts(1000);

        dao.editProduct(prodOne.getProductName(), prodTwo);

        Product prodToTest = dao.getProduct("Dr Pepper");

        assertEquals(prodTwo, prodToTest);

    }

}
