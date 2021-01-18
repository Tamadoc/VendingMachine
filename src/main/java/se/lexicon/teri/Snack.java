package se.lexicon.teri;

public class Snack extends Product {
    private final int calories;

    Snack(int productNumber, String name, int price, int calories) {
        super(productNumber, name, price);
        this.calories = calories;
    }

    @Override
    public String examine() {
        String temp = super.examine();
        return temp + " " + calories + " kCal";
    }

    @Override
    public String use() {
        return "The snack is removed from the vending machine";
    }
}
