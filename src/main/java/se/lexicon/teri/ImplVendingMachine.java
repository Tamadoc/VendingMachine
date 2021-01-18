package se.lexicon.teri;

import java.util.Arrays;

public class ImplVendingMachine implements VendingMachine {
    Product[] products = {
            new Snack(10, "Yoghurt", 50, 350),
            new Snack(11, "Sandwich", 50, 450),
            new Sweet(20, "Sport bar", 25, 26.3f),
            new Sweet(21, "Plopp bar", 30, 31.1f),
            new Drink(30, "Coca cola", 45, 500),
            new Drink(31, "Mer päron", 35, 330)
    };
    int depositPool;
    final int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};

    public void addProduct(Product product){
        products = Arrays.copyOf(products, products.length);
        products[products.length - 1] = product;
    }

    @Override
    public void addCurrency(int amount) {
        for (int i : denominations) {
            if (i == amount) {
                depositPool += amount;
                return;
            }
        }
        System.out.println("That is not a valid denomination.");
    }

    @Override
    public Product request(int productNumber) {
        for (Product product : products) {
            if (product.getProductNumber() == productNumber) {
                return product;
            }
        }
        return null;
    }

    @Override
    public int endSession() {
        int change = depositPool;
        depositPool = 0;
        return change;
    }

    @Override
    public String getDescription(int productNumber) {
        for (Product product : products) {
            if (product.getProductNumber() == productNumber) {
                return product.examine();
            }
        }

        System.out.println("Product number " + productNumber + " does not exist.");
        return null;
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public void reduceDepositPool(int price) {
        depositPool -= price;
    }

    @Override
    public String[] getProducts() {
        String[] productsList = new String[products.length];
        int index = 0;

        for (Product product : products) {
            String productInformation = "[" + product.getProductNumber() + "]" + " " + product.getName();
            productsList[index] = productInformation;
            index++;
        }

        return productsList;
    }
}