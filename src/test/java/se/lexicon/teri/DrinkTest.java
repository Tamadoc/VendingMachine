package se.lexicon.teri;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrinkTest {
    private Product product;

    @Before
    public void setUp() {
        product = new Drink(10, "Fanta", 25, 500);
    }

    @Test
    public void testExamine() {
        String expectedString = "Fanta: 25kr. 500ml";
        assertEquals(expectedString, product.examine());
    }

    @Test
    public void testUse() {
        String expectedString = "The drink is removed from the vending machine";
        assertEquals(expectedString, product.use());
    }
}