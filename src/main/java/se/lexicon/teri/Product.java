package se.lexicon.teri;

public abstract class Product {
    private String name;
    private int price;
    private int productNumber;

    Product(int productNumber, String name, int price ) {
        this.name = name;
        this.price = price;
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public String examine() {
        return name + ": " + price + "kr.";
    }

    abstract String use();
}
