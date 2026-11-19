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
            System.out.println("1) Find Vehicles By Price Range");
            System.out.println("2) Find Vehicles By Make / Model");
            System.out.println("3) Find Vehicles By Year Range");
            System.out.println("4) Find Vehicles By Color");
            System.out.println("5) Find Vehicles By Mileage Range");
            System.out.println("6) Find Vehicles By Type");
            System.out.println("7) List All Vehicles");
            System.out.println("99) Quit");

            System.out.print("\nSelect an option: ");

            int choice =
                    Integer.parseInt(
                            scanner.nextLine());

            switch (choice)
            {
                case 1:
                    processGetByPriceRequest();
                    break;

                case 2:
                    processGetByMakeModelRequest();
                    break;

                case 3:
                    processGetByYearRequest();
                    break;

                case 4:
                    processGetByColorRequest();
                    break;

                case 5:
                    processGetByMileageRequest();
                    break;

                case 6:
                    processGetByTypeRequest();
                    break;

                case 7:
                    processGetAllVehiclesRequest();
                    break;

                case 99:
                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid option.");
            }
        }
    }

    private void init()
    {
        DealershipFileManager fileManager =
                new DealershipFileManager();

        dealership =
                fileManager.getDealership();
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

    private void processGetByPriceRequest()
    {
        System.out.print(
                "Minimum Price: ");

        double min =
                Double.parseDouble(
                        scanner.nextLine());

        System.out.print(
                "Maximum Price: ");

        double max =
                Double.parseDouble(
                        scanner.nextLine());

        ArrayList<Vehicle> vehicles =
                dealership.getVehiclesByPrice(
                        min,
                        max);

        displayVehicles(vehicles);
    }

    private void processGetByMakeModelRequest()
    {
        System.out.print(
                "Enter Make: ");

        String make =
                scanner.nextLine();

        System.out.print(
                "Enter Model: ");

        String model =
                scanner.nextLine();

        ArrayList<Vehicle> vehicles =
                dealership.getVehiclesByMakeModel(
                        make,
                        model);

        displayVehicles(vehicles);
    }

    private void processGetByYearRequest()
    {
        System.out.print("Minimum Year: ");

        int min =
                Integer.parseInt(
                        scanner.nextLine());

        System.out.print("Maximum Year: ");

        int max =
                Integer.parseInt(
                        scanner.nextLine());

        ArrayList<Vehicle> vehicles =
                dealership.getVehiclesByYear(
                        min,
                        max);

        displayVehicles(vehicles);
    }

    private void processGetByColorRequest()
    {
        System.out.print("Enter Color: ");

        String color =
                scanner.nextLine();

        ArrayList<Vehicle> vehicles =
                dealership.getVehiclesByColor(
                        color);

        displayVehicles(vehicles);
    }

    private void processGetByMileageRequest()
    {
        System.out.print("Minimum Mileage: ");

        int min =
                Integer.parseInt(
                        scanner.nextLine());

        System.out.print("Maximum Mileage: ");

        int max =
                Integer.parseInt(
                        scanner.nextLine());

        ArrayList<Vehicle> vehicles =
                dealership.getVehiclesByMileage(
                        min,
                        max);

        displayVehicles(vehicles);
    }

    private void processGetByTypeRequest()
    {
        System.out.print("Enter Vehicle Type: ");

        String vehicleType =
                scanner.nextLine();

        ArrayList<Vehicle> vehicles =
                dealership.getVehiclesByType(
                        vehicleType);

        displayVehicles(vehicles);
    }
}