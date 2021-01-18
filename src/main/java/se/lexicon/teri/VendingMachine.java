package se.lexicon.teri;

public interface VendingMachine {
    void addCurrency(int amount);

    Product request(int productNumber);

    int endSession();

    String getDescription(int productNumber);

    int getBalance();

    void reduceDepositPool(int price);

    String[] getProducts();

    void addProduct(Product product);
}
