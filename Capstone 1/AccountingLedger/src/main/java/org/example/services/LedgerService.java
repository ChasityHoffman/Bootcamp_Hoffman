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
        ArrayList<Transaction> reversedTransactions = new ArrayList<>();   //Makes the list newest to oldest

        for (int i = transactions.size() - 1; i >= 0; i--)
        {
            reversedTransactions.add(transactions.get(i));
        }

        return reversedTransactions;
    }

    public ArrayList<Transaction> getDeposits()            //Loops through all transactions and returns
                                                          // only the transactions with positive amounts.
    {
        ArrayList<Transaction> deposits = new ArrayList<>();

        for (int i = transactions.size() - 1; i >= 0; i--)
        {
            Transaction transaction = transactions.get(i);

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

        for (int i = transactions.size() - 1; i >= 0; i--)
        {
            Transaction transaction = transactions.get(i);

            if (transaction.getAmount() < 0)
            {
                payments.add(transaction);
            }
        }

        return payments;
    }




}


