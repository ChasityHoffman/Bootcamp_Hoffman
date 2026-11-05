package org.example.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    public Transaction(LocalDate date, LocalTime time,
                       String description,
                       String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;                                       //Stores the transaction date.
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

    @Override                           // Transaction objects are displayed when printed.
    public String toString()
    {
        return date + " | " +
                time.getHour() + ":" +
                String.format("%02d", time.getMinute()) +    //Always display two digits.
                " | " +
                description + " | " +
                vendor + " | " +
                amount;
    }
}

