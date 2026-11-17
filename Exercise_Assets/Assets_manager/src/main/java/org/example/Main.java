package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {

        ArrayList<Asset> assets = new ArrayList<>();

        assets.add(new House(
                "My House",
                "2018-05-15",
                new BigDecimal("250000"),
                "123 Main St",
                1,
                1800,
                12000));

        assets.add(new House(
                "Vacation Home",
                "2021-07-20",
                new BigDecimal("300000"),
                "456 Beach Rd",
                2,
                2200,
                15000));

        assets.add(new Vehicle(
                "Tom's Truck",
                "2020-03-10",
                new BigDecimal("40000"),
                "Ford F-150",
                2020,
                125000));

        assets.add(new Vehicle(
                "My Car",
                "2023-01-12",
                new BigDecimal("28000"),
                "Toyota Camry",
                2023,
                110000));

        for (Asset asset : assets) {

            String message = "";

            if (asset instanceof House) {

                House house = (House) asset;
                message = "House at " + house.getAddress();

            } else if (asset instanceof Vehicle) {

                Vehicle vehicle = (Vehicle) asset;
                message = "Vehicle: "
                        + vehicle.getYear()
                        + " "
                        + vehicle.getMakeModel();
            }

            System.out.println("----------------------------------");
            System.out.println(asset.getDescription());
            System.out.println("Acquired: " + asset.getDateAcquired());
            System.out.println("Original Cost: $" + asset.getOriginalCost());
            System.out.println("Current Value: $" + asset.getValue());
            System.out.println(message);
        }
    }
}