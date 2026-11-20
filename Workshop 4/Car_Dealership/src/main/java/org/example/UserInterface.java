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
        {System.out.println(CYAN +
                "\n╔════════════════════════════════════╗\n" +
                "║        CAR DEALERSHIP SYSTEM       ║\n" +
                "║       Inventory Management         ║\n" +
                "╚════════════════════════════════════╝\n"
                + RESET);
            System.out.println(PURPLE + "1)" + RESET +
                    " Find Vehicles By Price Range");
            System.out.println(PURPLE + "2)" + RESET +
                    " Find Vehicles By Make / Model");

            System.out.println(PURPLE + "3)" + RESET +
                    " Find Vehicles By Year Range");

            System.out.println(PURPLE + "4)" + RESET +
                    " Find Vehicles By Color");

            System.out.println(PURPLE + "5)" + RESET +
                    " Find Vehicles By Mileage Range");

            System.out.println(PURPLE + "6)" + RESET +
                    " Find Vehicles By Type");

            System.out.println(YELLOW + "7)" + RESET +
                    " List All Vehicles");

            System.out.println(GREEN + "8)" + RESET +
                    " Add Vehicle");

            System.out.println(YELLOW + "9)" + RESET +
                    " Remove Vehicle");

            System.out.println(CYAN + "10)" + RESET +
                    " Sell / Lease Vehicle");

            System.out.println(CYAN + "99)" + RESET +
                    " Quit");

            System.out.print(CYAN +
                    "\nSelect an option: "
                    + RESET);
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

                case 8:
                    processAddVehicleRequest();
                    break;

                case 9:
                    processRemoveVehicleRequest();
                    break;

                case 10:
                    processSellOrLeaseVehicleRequest();
                    break;

                case 99:
                    System.out.println(CYAN +
                            "\n╔════════════════════════════════════╗\n" +
                            "║ THANK YOU FOR USING THE            ║\n" +
                            "║ CAR DEALERSHIP SYSTEM              ║\n" +
                            "╠════════════════════════════════════╣\n" +
                            "║ Your changes have been saved.      ║\n" +
                            "║ Have a great day!                  ║\n" +
                            "╚════════════════════════════════════╝\n"
                            + RESET);

                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid option.");
            }
        }
    }

    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String PURPLE = "\u001B[35m";


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
        { System.out.println(YELLOW +
                "\n===== VEHICLE RESULTS =====\n"
                + RESET);
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

    private void processAddVehicleRequest()
    {
        System.out.print("VIN: ");
        int vin =
                Integer.parseInt(
                        scanner.nextLine());

        System.out.print("Year: ");
        int year =
                Integer.parseInt(
                        scanner.nextLine());

        System.out.print("Make: ");
        String make =
                scanner.nextLine();

        System.out.print("Model: ");
        String model =
                scanner.nextLine();

        System.out.print("Vehicle Type: ");
        String vehicleType =
                scanner.nextLine();

        System.out.print("Color: ");
        String color =
                scanner.nextLine();

        System.out.print("Odometer: ");
        int odometer =
                Integer.parseInt(
                        scanner.nextLine());

        System.out.print("Price: ");
        double price =
                Double.parseDouble(
                        scanner.nextLine());

        Vehicle vehicle =
                new Vehicle(
                        vin,
                        year,
                        make,
                        model,
                        vehicleType,
                        color,
                        odometer,
                        price);

        dealership.addVehicle(vehicle);

        DealershipFileManager fileManager =
                new DealershipFileManager();

        fileManager.saveDealership(dealership);

        System.out.println(
                "\nVehicle added successfully.");
    }

    private void processRemoveVehicleRequest()
    {
        System.out.print("Enter VIN: ");

        int vin =
                Integer.parseInt(
                        scanner.nextLine());

        Vehicle vehicleToRemove = null;

        for (Vehicle vehicle :
                dealership.getAllVehicles())
        {
            if (vehicle.getVin() == vin)
            {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove != null)
        {
            dealership.removeVehicle(
                    vehicleToRemove);

            DealershipFileManager fileManager =
                    new DealershipFileManager();

            fileManager.saveDealership(
                    dealership);

            System.out.println(
                    "\nVehicle removed successfully.");
        }
        else
        {
            System.out.println(
                    "\nVehicle not found.");
        }
    }

    private void processSellOrLeaseVehicleRequest()
    {
        System.out.print("Enter VIN: ");

        int vin =
                Integer.parseInt(
                        scanner.nextLine());

        Vehicle selectedVehicle = null;

        for (Vehicle vehicle :
                dealership.getAllVehicles())
        {
            if (vehicle.getVin() == vin)
            {
                selectedVehicle = vehicle;
                break;
            }
        }

        if (selectedVehicle == null)
        {
            System.out.println(
                    "Vehicle not found.");

            return;
        }

        System.out.print(
                "Customer Name: ");

        String customerName =
                scanner.nextLine();

        System.out.print(
                "Customer Email: ");

        String customerEmail =
                scanner.nextLine();

        System.out.print(
                "Sale or Lease (S/L): ");

        String choice =
                scanner.nextLine();

        Contract contract = null;

        if (choice.equalsIgnoreCase("S"))
        {
            System.out.print(
                    "Finance? (Y/N): ");

            boolean finance =
                    scanner.nextLine()
                            .equalsIgnoreCase("Y");

            contract =
                    new SalesContract(
                            String.valueOf(
                                    java.time.LocalDate.now()),
                            customerName,
                            customerEmail,
                            selectedVehicle,
                            finance);
        }

        else if (choice.equalsIgnoreCase("L"))
        {
            contract =
                    new LeaseContract(
                            String.valueOf(
                                    java.time.LocalDate.now()),
                            customerName,
                            customerEmail,
                            selectedVehicle);
        }

        if (contract != null)
        {
            ContractDataManager contractDataManager =
                    new ContractDataManager();

            contractDataManager
                    .saveContract(contract);

            dealership.removeVehicle(selectedVehicle);

            DealershipFileManager dealershipFileManager =
                    new DealershipFileManager();

            dealershipFileManager.saveDealership(
                    dealership);

            System.out.println(
                    "\nContract saved successfully.");
        }

        System.out.println();
        System.out.println(
                selectedVehicle.getYear() +
                        " " +
                        selectedVehicle.getMake() +
                        " " +
                        selectedVehicle.getModel());
    }
}