package org.example;

//Extends Asset and stores house specific information.

import java.math.BigDecimal;

public class House extends Asset {

    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired,
                 BigDecimal originalCost,
                 String address,
                 int condition,
                 int squareFoot,
                 int lotSize) {

        super(description, dateAcquired, originalCost);

        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public BigDecimal getValue() {

        BigDecimal valuePerSquareFoot;

        switch (condition) {
            case 1:
                valuePerSquareFoot = new BigDecimal("180");
                break;
            case 2:
                valuePerSquareFoot = new BigDecimal("130");
                break;
            case 3:
                valuePerSquareFoot = new BigDecimal("90");
                break;
            default:
                valuePerSquareFoot = new BigDecimal("80");
        }

        BigDecimal houseValue =
                valuePerSquareFoot.multiply(BigDecimal.valueOf(squareFoot));

        BigDecimal lotValue =
                BigDecimal.valueOf(lotSize).multiply(new BigDecimal("0.25"));

        return houseValue.add(lotValue);
    }
}

