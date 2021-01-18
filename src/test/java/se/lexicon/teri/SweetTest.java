package se.lexicon.teri;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SweetTest {
    private Product product;

    @Before
    public void setUp() {
        product = new Sweet(10, "Sport bar", 25, 365);
    }

    @Test
    public void testExamine() {
        String expectedString = "Sport bar: 25kr. Total sugars: 365.0g";
        assertEquals(expectedString, product.examine());
    }

    @Test
    public void testUse() {
        String expectedString = "The sweet is removed from the vending machine";
        assertEquals(expectedString, product.use());
    }
}