package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface
{
    private Dealership dealership;
    private Scanner scanner;

    public UserInterface()
    {
        scanner = new Scanner(System.in);
    }

    public void display()
    {
        init();

        boolean running = true;

        while (running)
        {
            System.out.println("\n===== DEALERSHIP MENU =====");
            System.out.println("7) List All Vehicles");
            System.out.println("99) Quit");

            System.out.print("\nSelect an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice)
            {
                case 7:
                    processGetAllVehiclesRequest();
                    break;

                case 99:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void init()
    {
        DealershipFileManager fileManager =
                new DealershipFileManager();

        dealership = fileManager.getDealership();
    }

    private void displayVehicles(
            ArrayList<Vehicle> vehicles)
    {
        for (Vehicle vehicle : vehicles)
        {
            System.out.println(
                    vehicle.getVin() + " | " +
                            vehicle.getYear() + " | " +
                            vehicle.getMake() + " | " +
                            vehicle.getModel() + " | " +
                            vehicle.getVehicleType() + " | " +
                            vehicle.getColor() + " | " +
                            vehicle.getOdometer() + " | $" +
                            vehicle.getPrice());
        }
    }

    private void processGetAllVehiclesRequest()
    {
        displayVehicles(
                dealership.getAllVehicles());
    }
}