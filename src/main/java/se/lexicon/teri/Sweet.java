package se.lexicon.teri;

public class Sweet extends Product {
    private final float totalSugars;

    Sweet(int productNumber, String name, int price, float totalSugars) {
        super(productNumber, name, price);
        this.totalSugars = totalSugars;
    }

    @Override
    public String examine() {
        String temp = super.examine();
        return temp + " Total sugars: " + totalSugars + "g";
    }

    @Override
    public String use() {
        return "The sweet is removed from the vending machine";
    }
}
