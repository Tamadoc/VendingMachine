package se.lexicon.teri;

public class Drink extends Product {
    private final int volumeMl;

    Drink(int productNumber, String name, int price, int volumeMl) {
        super(productNumber, name, price);
        this.volumeMl = volumeMl;
    }

    @Override
    public String examine() {
        String temp = super.examine();
        return temp + " " + volumeMl + "ml";
    }

    @Override
    public String use() {
        return "The drink is removed from the vending machine";
    }
}
