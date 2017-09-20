
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

    private VendingMachineDao nuDao = new VendingMachineDaoFileImpl();
    
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

        List<Product> products = nuDao.getAllProducts();
        
        for (Product currentProduct : products) {
            
            nuDao.removeProduct(currentProduct.getProductName());
            
        }
        
    }

    @After
    public void tearDown() {
    }

    /**
     *
     * Test of addProduct
     *
     * @throws java.lang.Exception
     */
    
    @Test
    public void testAddProduct() throws Exception {

        Product product = new Product("Dr Pepper");
        product.setProductPrice(new BigDecimal("2.00"));
        product.setNumberOfProducts(100);

        nuDao.addProduct(product.getProductName(), product);
        List<Product>testProduct = nuDao.getAllProducts();

        
        assertEquals(1, testProduct.size());
        assertEquals("Dr Pepper", testProduct.get(0).getProductName());

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

        nuDao.addProduct(prodOne.getProductName(), prodOne);

        Product prodTwo = new Product("Dr Thunder");
        prodTwo.setProductPrice(new BigDecimal("2.00"));
        prodTwo.setNumberOfProducts(100);

        nuDao.addProduct(prodTwo.getProductName(), prodTwo);

        Product prodThree = new Product("Mt Dew");
        prodThree.setProductPrice(new BigDecimal("2.00"));
        prodThree.setNumberOfProducts(100);

        nuDao.addProduct(prodOne.getProductName(), prodThree);

        assertEquals(3, nuDao.getAllProducts().size());

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

        nuDao.addProduct(prodOne.getProductName(), prodOne);

        Product prodTwo = new Product("Dr Thunder");
        prodTwo.setProductPrice(new BigDecimal("2.00"));
        prodTwo.setNumberOfProducts(100);

        nuDao.addProduct(prodTwo.getProductName(), prodTwo);
        
        nuDao.removeProduct("Dr Pepper");

        assertEquals(1, nuDao.getAllProducts().size());

        assertNull(nuDao.getProduct("Dr Pepper"));

        nuDao.removeProduct("Dr Thunder");

        assertEquals(0, nuDao.getAllProducts().size());

        assertNull(nuDao.getProduct("Dr Thunder"));

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

        nuDao.addProduct(prodOne.getProductName(), prodOne);

        Product prodTwo = new Product("Dr Pepper");
        prodTwo.setProductPrice(new BigDecimal("2.00"));
        prodTwo.setNumberOfProducts(1000);

        nuDao.editProduct(prodOne.getProductName(), prodTwo);

        assertEquals(prodTwo.getProductName(), prodOne.getProductName());

    }

}
