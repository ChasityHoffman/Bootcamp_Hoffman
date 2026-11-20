package org.example;

public class SalesContract extends Contract
{
    private boolean finance;

    public SalesContract(
            String date,
            String customerName,
            String customerEmail,
            Vehicle vehicleSold,
            boolean finance)
    {
        super(
                date,
                customerName,
                customerEmail,
                vehicleSold);

        this.finance = finance;
    }

    public double getSalesTaxAmount()
    {
        return getVehicleSold().getPrice() * .05;
    }

    public double getRecordingFee()
    {
        return 100;
    }

    public double getProcessingFee()
    {
        if (getVehicleSold().getPrice() < 10000)
        {
            return 295;
        }

        return 495;
    }

    @Override
    public double getTotalPrice()
    {
        return getVehicleSold().getPrice()
                + getSalesTaxAmount()
                + getRecordingFee()
                + getProcessingFee();
    }

    @Override
    public double getMonthlyPayment()
    {
        if (!finance)
        {
            return 0;
        }

        double loanAmount =
                getTotalPrice();

        double annualInterestRate;
        int loanLength;

        if (loanAmount >= 10000)
        {
            annualInterestRate = .0425;
            loanLength = 48;
        }
        else
        {
            annualInterestRate = .0525;
            loanLength = 24;
        }

        double monthlyInterestRate =
                annualInterestRate / 12;

        return (loanAmount *
                monthlyInterestRate)
                /
                (1 - Math.pow(
                        1 + monthlyInterestRate,
                        -loanLength));
    }

    public boolean isFinance()
    {
        return finance;
    }

    public void setFinance(boolean finance)
    {
        this.finance = finance;
    }
}