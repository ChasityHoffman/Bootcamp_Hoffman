package org.example.services;

import org.example.models.Transaction;
import java.util.ArrayList;
import org.example.services.FileManager;

public class LedgerService {

    private ArrayList<Transaction> transactions;

    public LedgerService()
    {
        FileManager fileManager = new FileManager();

        transactions = fileManager.loadTransactions();
    }

    public ArrayList<Transaction> getAllTransactions()          //Returns the complete list of
                                                               // transactions loaded from the CSV file
    {
        return transactions;
    }

    public ArrayList<Transaction> getDeposits()            //Loops through all transactions and returns
                                                          // only the transactions with positive amounts.
    {
        ArrayList<Transaction> deposits = new ArrayList<>();

        for (Transaction transaction : transactions)
        {
            if (transaction.getAmount() > 0)
            {
                deposits.add(transaction);
            }
        }

        return deposits;
    }

    public ArrayList<Transaction> getPayments()        //Loops through all transactions and returns
                                                      // only the transactions with negative amounts.
    {
        ArrayList<Transaction> payments = new ArrayList<>();

        for (Transaction transaction : transactions)
        {
            if (transaction.getAmount() < 0)
            {
                payments.add(transaction);
            }
        }

        return payments;
    }




}


