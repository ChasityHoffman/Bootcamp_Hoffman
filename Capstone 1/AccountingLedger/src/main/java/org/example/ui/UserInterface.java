package org.example.ui;

import org.example.services.LedgerService;

public class UserInterface {

    private LedgerService ledgerService;

    public UserInterface()
    {
        ledgerService = new LedgerService();
    }

    public void displayHomeScreen()
    {
        System.out.println("Accounting Ledger\n");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment");
        System.out.println("L) Ledger");
        System.out.println("X) Exit");
        System.out.print("\nSelect an option: ");
    }






}