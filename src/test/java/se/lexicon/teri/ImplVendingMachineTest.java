package se.lexicon.teri;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImplVendingMachineTest {
    private VendingMachine vendingMachine;
    private Product product;

    @Before
    public void setUp() {
        vendingMachine = new ImplVendingMachine();
        product = new Snack(50, "Yoghurt", 50, 350);
        vendingMachine.addProduct(product);
    }

    @Test
    public void testAddCurrency() {
        int expectedDepositPool = 500;
        vendingMachine.addCurrency(500);
        assertEquals(expectedDepositPool, vendingMachine.getBalance());
    }

    @Test
    public void testAddCurrency_NegativeDeposit() {
        int expectedDepositPool = 0;
        vendingMachine.addCurrency(-500);
        assertEquals(expectedDepositPool, vendingMachine.getBalance());
    }

    @Test
    public void testAddCurrency_InvalidDeposit() {
        int expectedDepositPool = 0;
        vendingMachine.addCurrency(13);
        assertEquals(expectedDepositPool, vendingMachine.getBalance());
    }


    @Test
    public void testRequest() {
        Product expectedProduct = product;
        int productNumber = 50;
        assertEquals(expectedProduct, vendingMachine.request(productNumber));
    }

    @Test
    public void testRequest_Null() {
        Product expectedProduct = null;
        int productNumber = 60;
        assertEquals(expectedProduct, vendingMachine.request(productNumber));
    }

    @Test
    public void testEndSession() {
        int deposit = 100;
        int expectedChange = 50;
        vendingMachine.addCurrency(deposit);
        vendingMachine.reduceDepositPool(product.getPrice());
        assertEquals(expectedChange, vendingMachine.endSession());
    }

    @Test
    public void testGetDescription() {
        String expectedDescription = "Yoghurt: 50kr. 350 kCal";
        int productNumber = 50;
        assertEquals(expectedDescription, vendingMachine.getDescription(productNumber));
    }

    @Test
    public void testGetDescription_Null() {
        String expectedDescription = null;
        int productNumber = 60;
        assertEquals(expectedDescription, vendingMachine.getDescription(productNumber));
    }

    @Test
    public void testGetBalance() {
        int expectedBalance = 100;
        int deposit = 100;
        vendingMachine.addCurrency(deposit);
        assertEquals(expectedBalance, vendingMachine.getBalance());
    }
}