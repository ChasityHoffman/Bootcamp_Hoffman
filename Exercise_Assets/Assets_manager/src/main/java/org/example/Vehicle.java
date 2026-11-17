package org.example;

//Extends Asset and stores vehicle specific information.

import java.math.BigDecimal;
import java.time.Year;

public class Vehicle extends Asset {

    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description,
                   String dateAcquired,
                   BigDecimal originalCost,
                   String makeModel,
                   int year,
                   int odometer) {

        super(description, dateAcquired, originalCost);

        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue() {

        int currentYear = Year.now().getValue();
        int age = currentYear - year;

        BigDecimal value = getOriginalCost();

        if (age <= 3) {
            value = value.multiply(
                    BigDecimal.valueOf(1 - (age * 0.03))
            );
        } else if (age <= 6) {
            value = value.multiply(
                    BigDecimal.valueOf(1 - (age * 0.06))
            );
        } else if (age <= 10) {
            value = value.multiply(
                    BigDecimal.valueOf(1 - (age * 0.08))
            );
        } else {
            value = new BigDecimal("1000");
        }

        boolean hondaOrToyota =
                makeModel.toLowerCase().contains("honda")
                        || makeModel.toLowerCase().contains("toyota");

        if (odometer > 100000 && !hondaOrToyota) {
            value = value.multiply(new BigDecimal("0.75"));
        }

        return value;
    }
}