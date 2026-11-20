package org.example;

public class LeaseContract extends Contract
{
    public LeaseContract(
            String date,
            String customerName,
            String customerEmail,
            Vehicle vehicleSold)
    {
        super(
                date,
                customerName,
                customerEmail,
                vehicleSold);
    }

    @Override
    public double getTotalPrice()
    {
        return 0;
    }

    @Override
    public double getMonthlyPayment()
    {
        return 0;
    }
}