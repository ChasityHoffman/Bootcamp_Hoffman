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

    public boolean isFinance()
    {
        return finance;
    }

    public void setFinance(boolean finance)
    {
        this.finance = finance;
    }
}