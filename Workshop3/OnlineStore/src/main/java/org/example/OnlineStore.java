package org.example;

import java.util.List;
import java.util.Scanner;

public class OnlineStore
{
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String PURPLE = "\u001B[35m";

    private List<Product> inventory;
    private ShoppingCart cart;
    private Scanner scanner;

    public OnlineStore()
    {
        inventory = FileManager.getProducts();
        cart = new ShoppingCart();
        scanner = new Scanner(System.in);
    }

    public void run()
    {
        displayHomeScreen();
    }

    public void displayHomeScreen()
    {
        boolean running = true;

        while (running)
        {
            System.out.println(CYAN +
                    "\n╔══════════════════════════════╗\n" +
                    "║        ONLINE STORE          ║\n" +
                    "║       Shop With Ease         ║\n" +
                    "╚══════════════════════════════╝\n"
                    + RESET);

            System.out.println(PURPLE + "1)" + RESET + " Display Products");
            System.out.println(YELLOW + "2)" + RESET + " Display Cart");
            System.out.println(CYAN + "3)" + RESET + " Exit");

            System.out.print(CYAN + "\nSelect an option: " + RESET);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    displayProducts();
                    break;

                case 2:
                    displayCart();
                    break;

                case 3:
                    System.out.println(CYAN +
                            "\n╔══════════════════════════════════╗\n" +
                            "║   THANK YOU FOR VISITING THE     ║\n" +
                            "║         ONLINE STORE             ║\n" +
                            "╚══════════════════════════════════╝\n"
                            + RESET);

                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public void displayProducts()
    {
        System.out.println(PURPLE +
                "\n╔══════════════════════════════╗\n" +
                "║      STORE PRODUCTS          ║\n" +
                "╚══════════════════════════════╝\n"
                + RESET);

        for (Product product : inventory)
        {
            System.out.println(
                    product.getSKU() + " | " +
                            product.getProductName() + " | $" +
                            product.getPrice() + " | " +
                            product.getDepartment());
        }

        System.out.println(PURPLE +
                "\n╔══════════════════════════════╗\n" +
                "║       PRODUCT MENU           ║\n" +
                "╚══════════════════════════════╝\n"
                + RESET);

        System.out.println(PURPLE + "1)" + RESET + " Add Product To Cart");
        System.out.println(PURPLE + "2)" + RESET + " Search By Name");
        System.out.println(PURPLE + "3)" + RESET + " Search By Department");
        System.out.println(PURPLE + "4)" + RESET + " Search By Price Range");
        System.out.println(PURPLE + "5)" + RESET + " Back");

        System.out.print(CYAN + "\nSelect an option: " + RESET);

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice)
        {
            case 1:
                addProductToCart();
                break;

            case 2:
                searchByName();
                break;

            case 3:
                searchByDepartment();
                break;

            case 4:
                searchByPriceRange();
                break;

            case 5:
                return;

            default:
                System.out.println("Invalid option.");
        }
    }

    public void addProductToCart()
    {
        System.out.print("\nEnter SKU: ");

        String sku = scanner.nextLine();

        boolean found = false;

        for (Product product : inventory)
        {
            if (product.getSKU().equalsIgnoreCase(sku))
            {
                cart.addToCart(product);

                System.out.println(
                        "\n" + product.getProductName()
                                + " added to cart!");

                found = true;
                break;
            }
        }

        if (!found)
        {
            System.out.println("Product not found.");
        }

        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void displayCart()
    {
        System.out.println(YELLOW +
                "\n╔══════════════════════════════╗\n" +
                "║       SHOPPING CART         ║\n" +
                "╚══════════════════════════════╝\n"
                + RESET);

        if (cart.cart.isEmpty())
        {
            System.out.println("Your cart is empty.");
        }
        else
        {
            for (Product product : cart.cart)
            {
                System.out.println(
                        product.getSKU() + " | " +
                                product.getProductName() +
                                " | $" + product.getPrice());
            }

            System.out.println(
                    "\nCart Total: $" +
                            cart.getCartTotal());

            System.out.println();
            System.out.println(YELLOW + "1)" + RESET + " Remove Product");
            System.out.println(YELLOW + "2)" + RESET + " Back");

            System.out.print(CYAN + "\nSelect an option: " + RESET);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    removeProductFromCart();
                    break;

                case 2:
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }

        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void removeProductFromCart()
    {
        System.out.print("\nEnter SKU to remove: ");

        String sku = scanner.nextLine();

        boolean found = false;

        for (Product product : cart.cart)
        {
            if (product.getSKU().equalsIgnoreCase(sku))
            {
                cart.removeFromCart(product);

                System.out.println(
                        product.getProductName()
                                + " removed from cart.");

                found = true;
                break;
            }
        }

        if (!found)
        {
            System.out.println("Product not found in cart.");
        }
    }

    public void searchByName()
    {
        System.out.print("\nEnter Product Name: ");

        String searchName = scanner.nextLine();

        System.out.println(PURPLE + "\nSEARCH RESULTS\n" + RESET);

        for (Product product : inventory)
        {
            if (product.getProductName()
                    .toLowerCase()
                    .contains(searchName.toLowerCase()))
            {
                System.out.println(
                        product.getSKU() + " | " +
                                product.getProductName() +
                                " | $" + product.getPrice());
            }
        }

        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void searchByDepartment()
    {
        System.out.print("\nEnter Department: ");

        String departmentSearch = scanner.nextLine();

        System.out.println(PURPLE + "\nSEARCH RESULTS\n" + RESET);

        for (Product product : inventory)
        {
            if (product.getDepartment()
                    .toLowerCase()
                    .contains(departmentSearch.toLowerCase()))
            {
                System.out.println(
                        product.getSKU() + " | " +
                                product.getProductName() +
                                " | $" + product.getPrice() +
                                " | " + product.getDepartment());
            }
        }

        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void searchByPriceRange()
    {
        System.out.print("\nEnter Minimum Price: ");
        double minPrice =
                Double.parseDouble(scanner.nextLine());

        System.out.print("Enter Maximum Price: ");
        double maxPrice =
                Double.parseDouble(scanner.nextLine());

        System.out.println(PURPLE + "\nSEARCH RESULTS\n" + RESET);

        for (Product product : inventory)
        {
            if (product.getPrice() >= minPrice
                    && product.getPrice() <= maxPrice)
            {
                System.out.println(
                        product.getSKU() + " | " +
                                product.getProductName() +
                                " | $" + product.getPrice() +
                                " | " + product.getDepartment());
            }
        }

        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
}


