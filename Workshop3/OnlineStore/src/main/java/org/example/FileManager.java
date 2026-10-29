package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static List<Product> getProducts(){
        List<Product> products = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("src/main/resources/products.csv");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine(); //this skips header

            String input;

            while((input = bufferedReader.readLine()) != null){
                String[] parts = input.split("\\|");

                String SKU = parts[0];
                String productName = parts[1];
                double price = Double.parseDouble(parts[2]);
                String department = parts[3];

                Product product = new Product(SKU, productName, price, department);
                products.add(product);
            }
                bufferedReader.close();
        }
        catch (Exception ex){
           ex.printStackTrace();
        }

        return products;
    }




}
