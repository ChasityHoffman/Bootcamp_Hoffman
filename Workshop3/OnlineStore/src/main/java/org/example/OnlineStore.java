package org.example;

import java.util.List;
import java.util.Scanner;

public class OnlineStore {

    private List<Product> inventory;
    private ShoppingCart cart;
    private Scanner scanner;

    public OnlineStore() {
        inventory = FileManager.getProducts();
        cart = new ShoppingCart();
        scanner = new Scanner(System.in);

        public void run () {

            boolean running = true;

            while (running) {            //the beginning adds color, make sure to reset at the end of the line
                System.out.println("\u001B[35m" + "\nHello & Welcome To the Online Store " + "\u001b[0m");
                System.out.println(" ***  CHOOSE AN OPTION BELOW  *** ");
                System.out.println("1. Display Products");
                System.out.println("2. Display Cart");
                System.out.println("3. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("\u001B[35m" + "\nONLINE STORE PRODUCTS AVAILABLE " + "\u001b[0m");
                        for (int i = 0; i < inventory.size(); i++) {
                            Product p = inventory.get(i);
                            System.out.println("\nSKU: " +
                                    p.getSKU() + " | " + p.getProductName() + " | $" +
                                    p.getPrice() + " | DEPARTMENT: " + p.getDepartment()
                            );
                        }
                        System.out.println("\u001B[35m" + "\nPlease Choose An Option Below! " + "\u001b[0m");
                        System.out.println("\n1. Add Products To My Cart");
                        System.out.println("2. Search By Name");
                        System.out.println("3. Search By Department");
                        System.out.println("4. Search By Price Range");
                        System.out.println("5. Go Back");

                        int productChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (productChoice == 1) {
                            System.out.println("Enter Product SKU: ");
                            String SKU = scanner.nextLine();

                            boolean found = false;

                            for (int i = 0; i < inventory.size(); i++) {
                                Product p = inventory.get(i);

                                if (p.getSKU().equalsIgnoreCase(SKU)) {
                                    cart.addToCart(p);
                                    System.out.println(p.getProductName() + " Added To Cart! ");

                                    found = true;
                                    break;
                                }
                            }

                            if (productChoice == 2) {

                                System.out.println("Enter Product Name: ");
                                String searchName = scanner.nextLine();

                                for (int i = 0; i < inventory.size(); i++) {
                                    Product p = inventory.get(i);

                                    if (p.getProductName().toLowerCase().contains(searchName.toLowerCase())) {
                                        System.out.println(p.getSKU() + " | "
                                                + p.getProductName()
                                                + " | $" + p.getPrice());
                                    }
                                }
                            }


                            if (!found) {
                                System.out.println("\nINVALID SKU. Please Choose From The Products Below:\n");

                                for (int i = 0; i < inventory.size(); i++) {
                                    Product product = inventory.get(i);
                                    System.out.println("SKU: " + product.getSKU() + " | PRODUCT NAME: "
                                            + product.getProductName());
                                }
                            }
                            break;


                        }

                    case 2:
                        System.out.println("\n **SHOPPING CART** ");

                        if (cart.cart.size() == 0) {
                            System.out.println("Your Cart Is Currently Empty.");
                        } else {
                            for (int i = 0; i < cart.cart.size(); i++) {
                                Product p = cart.cart.get(i);
                                System.out.println("SKU: " + p.getSKU() + " | PRODUCT: " + p.getProductName()
                                        + " | PRICE: $" + p.getPrice());
                            }
                            System.out.println("\nCart Total: $" + cart.getCartTotal());

                            System.out.println("\u001B[35m" + "\nPLEASE CHOOSE AN OPTION BELOW: " + "\u001b[0m");
                            System.out.println(" 1. Remove Product ");
                            System.out.println(" 2. Go Back ");

                            int cartChoice = scanner.nextInt();
                            scanner.nextLine();

                            if (cartChoice == 1) {
                                System.out.println("Enter SKU to Remove Item: ");
                                String removeSKU = scanner.nextLine();

                                for (int i = 0; i < cart.cart.size(); i++) {

                                    Product p = cart.cart.get(i);
                                    if (p.getSKU().equalsIgnoreCase(removeSKU)) {
                                        cart.removeFromCart(p);
                                        System.out.println(p.getProductName() + " Item Has Been Removed From Cart");

                                        break;
                                    }
                                }
                            }
                        }
                        break;
                }
            }
        }
    }
}
