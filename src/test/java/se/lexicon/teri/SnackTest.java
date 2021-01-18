package se.lexicon.teri;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SnackTest {
    private Product product;

    @Before
    public void setUp() {
        product = new Snack(10, "Yoghurt", 25, 365);
    }

    @Test
    public void testExamine() {
        String expectedString = "Yoghurt: 25kr. 365 kCal";
        assertEquals(expectedString, product.examine());
    }

    @Test
    public void testUse() {
        String expectedString = "The snack is removed from the vending machine";
        assertEquals(expectedString, product.use());
    }
}