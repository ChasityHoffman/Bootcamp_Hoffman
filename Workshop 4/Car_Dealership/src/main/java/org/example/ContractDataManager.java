package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager
{
    public void saveContract(Contract contract)
    {
        try
        {
            BufferedWriter bufferedWriter =
                    new BufferedWriter(
                            new FileWriter(
                                    "src/main/resources/contracts.csv",
                                    true));

            // Contract Type
            if (contract instanceof SalesContract)
            {
                bufferedWriter.write("SALE");
            }
            else if (contract instanceof LeaseContract)
            {
                bufferedWriter.write("LEASE");
            }

            // Common Contract Fields
            bufferedWriter.write(
                    "|" + contract.getDate()
                            + "|" + contract.getCustomerName()
                            + "|" + contract.getCustomerEmail()
            );

            // Vehicle Fields
            Vehicle vehicle =
                    contract.getVehicleSold();

            bufferedWriter.write(
                    "|" + vehicle.getVin()
                            + "|" + vehicle.getYear()
                            + "|" + vehicle.getMake()
                            + "|" + vehicle.getModel()
                            + "|" + vehicle.getVehicleType()
                            + "|" + vehicle.getColor()
                            + "|" + vehicle.getOdometer()
                            + "|" + vehicle.getPrice()
            );

            // Sales Contract
            if (contract instanceof SalesContract)
            {
                SalesContract salesContract =
                        (SalesContract) contract;

                bufferedWriter.write(
                        "|" + salesContract.getSalesTaxAmount()
                                + "|" + salesContract.getRecordingFee()
                                + "|" + salesContract.getProcessingFee()
                                + "|" + salesContract.getTotalPrice()
                                + "|" + salesContract.isFinance()
                                + "|" + salesContract.getMonthlyPayment()
                );
            }

            // Lease Contract
            else if (contract instanceof LeaseContract)
            {
                LeaseContract leaseContract =
                        (LeaseContract) contract;

                bufferedWriter.write(
                        "|" + leaseContract.getExpectedEndingValue()
                                + "|" + leaseContract.getLeaseFee()
                                + "|" + leaseContract.getTotalPrice()
                                + "|" + leaseContract.getMonthlyPayment()
                );
            }

            bufferedWriter.newLine();

            bufferedWriter.close();
        }
        catch (IOException e)
        {
            System.out.println(
                    "Error writing contract.");
        }
    }
}
