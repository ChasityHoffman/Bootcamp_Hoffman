package org.example;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
    List<Product> inventory = FileManager.getProducts();

        Scanner  scanner = new Scanner(System.in);

        boolean running = true;

        while(running) {
            System.out.println("\nHello & Welcome To the Online Store ");
            System.out.println(" ***  CHOOSE AN OPTION BELOW  *** ");
            System.out.println("1. Display Products");
            System.out.println("2. Display Cart");
            System.out.println("3. Exit");

                int choice = scanner.nextInt();

                switch(choice){
                    case 1:
                        for(int i = 0; i < inventory.size(); i++){
                            Product p = inventory.get(i);
                            System.out.println();
                        }
                        break;

                    case 2:
                        break;

                    case 3:
                        running = false;
                        System.out.println("Thanks so much for shopping with us!");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }


        }
    }
}