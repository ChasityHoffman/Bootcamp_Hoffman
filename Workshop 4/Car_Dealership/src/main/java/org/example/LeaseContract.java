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

    public double getExpectedEndingValue()
    {
        return getVehicleSold().getPrice() * .50;
    }

    public double getLeaseFee()
    {
        return getVehicleSold().getPrice() * .07;
    }

    @Override
    public double getTotalPrice()
    {
        return getExpectedEndingValue()
                + getLeaseFee();
    }

    @Override
    public double getMonthlyPayment()
    {
        double leaseAmount =
                getTotalPrice();

        double monthlyInterestRate =
                .04 / 12;

        return (leaseAmount *
                monthlyInterestRate)
                /
                (1 - Math.pow(
                        1 + monthlyInterestRate,
                        -36));
    }
}