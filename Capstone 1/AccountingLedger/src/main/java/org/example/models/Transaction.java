package org.example.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {                                      //Fields
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    public Transaction(LocalDate date, LocalTime time,           //Constructor
                       String description,
                       String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public LocalDate getDate() {                                //Getters
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString()              //printing the transaction
    {
        return date + " | " +
                time.getHour() + ":" +
                String.format("%02d", time.getMinute()) +
                " | " +
                description + " | " +
                vendor + " | " +
                amount;
    }
}

