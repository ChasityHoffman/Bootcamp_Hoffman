package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DealershipFileManager
{
    public Dealership getDealership()
    {
        Dealership dealership = null;

        String fileName = "src/main/resources/inventory.csv";

        try
        {
            BufferedReader bufferedReader =
                    new BufferedReader(
                            new FileReader(fileName));

            String dealershipLine =
                    bufferedReader.readLine();

            String[] dealershipParts =
                    dealershipLine.split("\\|");

            String name = dealershipParts[0];
            String address = dealershipParts[1];
            String phone = dealershipParts[2];

            dealership = new Dealership(
                    name,
                    address,
                    phone);

            String line;

            while ((line = bufferedReader.readLine()) != null)
            {
                String[] parts = line.split("\\|");

                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);

                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];

                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                Vehicle vehicle = new Vehicle(
                        vin,
                        year,
                        make,
                        model,
                        vehicleType,
                        color,
                        odometer,
                        price);

                dealership.addVehicle(vehicle);
            }

            bufferedReader.close();
        }
        catch (IOException e)
        {
            System.out.println(
                    "Error reading inventory file.");
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership)
    {
        String fileName =
                "src/main/resources/inventory.csv";

        try
        {
            BufferedWriter bufferedWriter =
                    new BufferedWriter(
                            new FileWriter(fileName));

            bufferedWriter.write(
                    dealership.getName() + "|" +
                            dealership.getAddress() + "|" +
                            dealership.getPhone());

            bufferedWriter.newLine();

            for (Vehicle vehicle :
                    dealership.getAllVehicles())
            {
                bufferedWriter.write(
                        vehicle.getVin() + "|" +
                                vehicle.getYear() + "|" +
                                vehicle.getMake() + "|" +
                                vehicle.getModel() + "|" +
                                vehicle.getVehicleType() + "|" +
                                vehicle.getColor() + "|" +
                                vehicle.getOdometer() + "|" +
                                vehicle.getPrice());

                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        }
        catch (IOException e)
        {
            System.out.println(
                    "Error saving inventory file.");
        }
    }
}