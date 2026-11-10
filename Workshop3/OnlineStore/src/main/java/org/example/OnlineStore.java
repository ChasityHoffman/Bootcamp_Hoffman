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
    private List<Product> inventory;                //Stores all products loaded from
    private ShoppingCart cart;
    private Scanner scanner;

    public OnlineStore()                        //Constructor
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
                    "║      Shop With Ease          ║\n" +
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
                    System.out.println("Display Cart Selected");
                    break;

                case 3:
                    System.out.println(CYAN +
                            "\n╔══════════════════════════════════╗\n" +
                            "║   THANK YOU FOR VISITING THE     ║\n" +
                            "║          ONLINE STORE            ║\n" +
                            "╠══════════════════════════════════╣\n" +
                            "║ We hope to see you again soon!   ║\n" +
                            "╚══════════════════════════════════╝\n"
                            + RESET);

                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
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
                            product.getDepartment()
            );
        }

        System.out.println(PURPLE +
                "\n╔══════════════════════════════╗\n" +
                "║       PRODUCT MENU          ║\n" +
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
                System.out.println("Add To Cart Selected");
                break;

            case 2:
                System.out.println("Search By Name Selected");
                break;

            case 3:
                System.out.println("Search By Department Selected");
                break;

            case 4:
                System.out.println("Search By Price Range Selected");
                break;

            case 5:
                return;

            default:
                System.out.println("Invalid option.");
        }
    }
}


