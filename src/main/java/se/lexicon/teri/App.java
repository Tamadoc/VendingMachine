package se.lexicon.teri;

import java.util.Scanner;

public class App {
    public static final VendingMachine vendingMachine = new ImplVendingMachine();
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(" ##### Vending Machine #####");

        while (true) {
            showInstructions();
            String input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "A":
                    System.out.println();
                    int amount = requestDeposit();
                    if (amount == -1) {
                        System.out.println("Back to menu...");
                        break;
                    } else {
                        vendingMachine.addCurrency(amount);
                    }
                    break;
                case "B":
                    System.out.println("Current balance: " + vendingMachine.getBalance() + "kr");
                    break;
                case "C":
                    selectProduct("purchase");
                    break;
                case "D":
                    selectProduct("details");
                    break;
                case "E":
                    int change = vendingMachine.endSession();
                    System.out.println("You have " + change + "kr in change.");
                    System.out.println("Thank you for your custom.");
                    break;
                case "M":
                    break;
                case "X":
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("That is not a valid option");
            }
        }
    }

    private static void showInstructions() {
        System.out.println();
        System.out.println("Choose an option to continue");
        System.out.println("[A] Add Money");
        System.out.println("[B] Check Balance");
        System.out.println("[C] Choose Product");
        System.out.println("[D] View Product Details");
        System.out.println("[E] End Session");
        System.out.println("[M] Return to this menu");
        System.out.println("[X] Exit program");
    }

    private static int validateInteger(String input) {
        int number = 0;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            if (input.equals("X")) {
                System.out.println("Exiting...");
                System.exit(0);
            } else if (input.equals("M")) {
                System.out.println("Back to menu...");
                number = -1;
            } else {
                System.out.println("That is not a valid selection.");
            }
        }
        return number;
    }

    private static int requestDeposit() {
        System.out.println("How much do you want to deposit?");
        System.out.println("Valid denominations: 1kr, 2kr, 5kr, 10kr, 20kr, 50kr, 100kr, 500kr, 1000kr");
        String input = scanner.nextLine().toUpperCase();

        return validateInteger(input);
    }

    private static void selectProduct(String operation) {
        String[] productsList = vendingMachine.getProducts();

        while (true) {
            System.out.println();

            if (operation.equals("purchase")) {
                System.out.println("Purchase product");
            } else {
                System.out.println("View product details");
            }

            for (String s : productsList) {
                System.out.println(s);
            }
            System.out.println("Enter product number or press M to return to Menu");

            String input = scanner.nextLine().toUpperCase();
            if (input.equals("M")) {
                break;
            }

            int selection = validateInteger(input);
            if (selection == 0) {
                continue;
            }

            Product productSelected = vendingMachine.request(selection);

            if (productSelected == null) {
                System.out.println("The product number " + selection + " does not exist");
                continue;
            }

            if (operation.equals("purchase")) {
                if (vendingMachine.getBalance() > productSelected.getPrice()) {
                    System.out.println("You purchased " + productSelected.getName() + " for " + productSelected.getPrice() + "kr.");
                    System.out.println(productSelected.use());
                    vendingMachine.reduceDepositPool(productSelected.getPrice());
                } else {
                    System.out.println("You can't afford that. Please deposit more money.");
                    break;
                }
            } else {
                System.out.println(vendingMachine.getDescription(selection));
            }
        }
    }
}


