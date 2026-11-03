package org.example.services;

import org.example.models.Transaction;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileManager {
    public ArrayList<Transaction> loadTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();

        String fileName = "transactions.csv";             //variable that stores file name

        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(fileName));

            String line;

            while ((line = bufferedReader.readLine()) != null)   //reads the file
            {

                String[] parts = line.split("\\|");     //break each line into individual values

                LocalDate date = LocalDate.parse(parts[0]);
                LocalTime time = LocalTime.parse(parts[1]);
                String description = parts[2];
                String vendor = parts[3];
                double amount = Double.parseDouble(parts[4]); //can do math with it later

                Transaction transaction = new Transaction(
                        date,
                        time,
                        description,
                        vendor,
                        amount);

                transactions.add(transaction);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading transaction file.");
        }

        return transactions;

    }


    public void saveTransaction(Transaction transaction) {

        String fileName = "transactions.csv";

        try {
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new FileWriter(fileName, true));

            bufferedWriter.write(
                    transaction.getDate() + "|" +
                            transaction.getTime() + "|" +
                            transaction.getDescription() + "|" +
                            transaction.getVendor() + "|" +
                            transaction.getAmount()
            );
                    bufferedWriter.newLine();             //every transaction gets its own line.

                    bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Error saving transaction.");
        }
    }
}
