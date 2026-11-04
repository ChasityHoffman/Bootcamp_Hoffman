package org.example.ui;

import org.example.models.Transaction;
import org.example.services.FileManager;
import org.example.services.LedgerService;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

public class UserInterface {

    private LedgerService ledgerService;
    private Scanner scanner;
    private FileManager fileManager;

    public UserInterface() {
        ledgerService = new LedgerService();
        fileManager = new FileManager();
        scanner = new Scanner(System.in);
    }

    public void displayHomeScreen() {       //Shows the main menu
        System.out.println("Accounting Ledger\n");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment");
        System.out.println("L) Ledger");
        System.out.println("X) Exit");
        System.out.print("\nSelect an option: ");
        String choice = scanner.nextLine();

        switch (choice.toUpperCase()) {
            case "D":                        //Placeholder for deposit logic
                addDeposit();
                break;

            case "P":
                addPayment();              //Placeholder for payment logic
                break;

            case "L":
                displayLedgerMenu();     //Shows the ledger menu
                break;


            case "X":
                System.out.println("\nGoodbye!");
                break;

            default:
                System.out.println("\nInvalid option.");

        }
    }

    public void addDeposit() {

            System.out.println("\n===== ADD DEPOSIT =====\n");

            System.out.print("Enter Description: ");
            String description = scanner.nextLine();

            System.out.print("Enter Vendor: ");
            String vendor = scanner.nextLine();

        System.out.print("Enter Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        Transaction transaction = new Transaction(
                LocalDate.now(),
                LocalTime.now(),
                description,
                vendor,
                amount
        );

        fileManager.saveTransaction(transaction);

        System.out.println("\nDeposit saved successfully.");
    }

    public void addPayment()
    {
        System.out.println("Make Payment Screen");
    }

    public void displayLedgerMenu()
    {
        System.out.println("\n===== LEDGER =====\n");

        System.out.println("A) All Transactions");
        System.out.println("D) Deposits Only");
        System.out.println("P) Payments Only");
        System.out.println("R) Reports");
        System.out.println("H) Home");

        System.out.print("\nSelect an option: ");

        String choice = scanner.nextLine();

        switch (choice.toUpperCase())
        {
            case "A":
                displayAllTransactions();
                break;

            case "D":
                System.out.println("Deposits Selected");
                break;

            case "P":
                System.out.println("Payments Selected");
                break;

            case "R":
                System.out.println("Reports Selected");
                break;

            case "H":
                displayHomeScreen();
                break;

            default:
                System.out.println("Invalid Option");
        }
    }

    public void displayAllTransactions()     //Prints every transaction from the ArrayList
    {
        for (Transaction transaction : ledgerService.getAllTransactions())
        {
            System.out.println(transaction);

        }
    }




}













