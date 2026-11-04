package org.example.ui;

import org.example.models.Transaction;
import org.example.services.FileManager;
import org.example.services.LedgerService;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

public class UserInterface {

    private LedgerService ledgerService;               //Fields
    private Scanner scanner;
    private FileManager fileManager;

    private static final String RESET = "\u001B[0m";         //Changes the font color for the user
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";


    public UserInterface() {
        ledgerService = new LedgerService();
        fileManager = new FileManager();
        scanner = new Scanner(System.in);
    }

    public void displayHomeScreen() {       //Shows the main menu
        System.out.println(CYAN +
                "=====================================\n" +
                "         BUDGET TRACKER\n" +
                "=====================================\n"
                + RESET);
        System.out.println(GREEN + "D) Add Deposit" + RESET);
        System.out.println(RED + "P) Make Payment" + RESET);
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

        double amount;

        try                                              //helps prevent the code from breaking
        {                                               //in case the user puts an invalid submission
            System.out.print("Enter Amount: ");
            amount = Double.parseDouble(scanner.nextLine());
        }
        catch (NumberFormatException e)
        {
            System.out.println("\nInvalid amount entered.");
            displayHomeScreen();
            return;
        }

        Transaction transaction = new Transaction(
                LocalDate.now(),
                LocalTime.now(),
                description,
                vendor,
                amount
        );

        fileManager.saveTransaction(transaction);

        System.out.println("\nDeposit saved successfully.");

        displayHomeScreen();                                  //keeps the program running
    }

    public void addPayment()
    {
        System.out.println("\n===== MAKE PAYMENT =====\n");

            System.out.print("Enter Description: ");
            String description = scanner.nextLine();

            System.out.print("Enter Vendor: ");
            String vendor = scanner.nextLine();

        double amount;

        try
        {
            System.out.print("Enter Amount: ");
            amount = Double.parseDouble(scanner.nextLine());
        }
        catch (NumberFormatException e)
        {
            System.out.println("\nInvalid amount entered.");
            displayHomeScreen();
            return;
        }

            amount = -Math.abs(amount);

            Transaction transaction = new Transaction(
                    LocalDate.now(),
                    LocalTime.now(),
                    description,
                    vendor,
                    amount
            );

            fileManager.saveTransaction(transaction);

            System.out.println("\nPayment saved successfully.");

        displayHomeScreen();                               //keeps the program running

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
                displayDeposits();
                break;

            case "P":
                displayPayments();
                break;

            case "R":
                displayReportsMenu();
                break;

            case "H":
                displayHomeScreen();
                break;

            default:
                System.out.println("Invalid Option");
        }
    }

    public void displayReportsMenu()
    {
        System.out.println("\n===== REPORTS =====\n");

        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search By Vendor");
        System.out.println("6) Custom Search");
        System.out.println("0) Back");

        System.out.print("\nSelect an option: ");

        String choice = scanner.nextLine();

        switch (choice)
        {
            case "1":
                displayMonthToDate();
                break;

            case "2":
                displayPreviousMonth();
                break;

            case "3":
                displayYearToDate();
                break;

            case "4":
                displayPreviousYear();
                break;

            case "5":
                searchByVendor();
                break;

            case "6":
                customSearch();
                break;

            case "0":
                displayLedgerMenu();
                break;

            default:
                System.out.println("Invalid Option");
        }
    }

    public void searchByVendor()
    {
        System.out.print("\nEnter Vendor Name: ");
        String vendorSearch = scanner.nextLine();

        for (Transaction transaction : ledgerService.getAllTransactions())
        {
            if (transaction.getVendor().equalsIgnoreCase(vendorSearch))
            {
                System.out.println(transaction);
            }
            displayLedgerMenu();
        }
    }

    public void customSearch()                         //filter transactions by start date, end date,
    {                                                  //description, vendor, and amount.
        System.out.println("\n===== CUSTOM SEARCH =====\n");

        System.out.print("Start Date (YYYY-MM-DD): ");
        String startDateInput = scanner.nextLine();

        System.out.print("End Date (YYYY-MM-DD): ");
        String endDateInput = scanner.nextLine();

        System.out.print("Description: ");
        String descriptionInput = scanner.nextLine();

        System.out.print("Vendor: ");
        String vendorInput = scanner.nextLine();

        System.out.print("Amount: ");
        String amountInput = scanner.nextLine();

        LocalDate startDate = null;
        LocalDate endDate = null;

        if (!startDateInput.isBlank())                 //Any fields left blank are ignored
        {
            startDate = LocalDate.parse(startDateInput);
        }

        if (!endDateInput.isBlank())
        {
            endDate = LocalDate.parse(endDateInput);
        }

        for (Transaction transaction : ledgerService.getAllTransactions())
        {
            boolean matches = true;

            if (!descriptionInput.isBlank())
            {
                matches = matches &&
                        transaction.getDescription()
                                .toLowerCase()
                                .contains(descriptionInput.toLowerCase());
            }

            if (!vendorInput.isBlank())
            {
                matches = matches &&
                        transaction.getVendor()
                                .toLowerCase()
                                .contains(vendorInput.toLowerCase());
            }

            if (!amountInput.isBlank())
            {
                double searchAmount = Double.parseDouble(amountInput);

                matches = matches &&
                        transaction.getAmount() == searchAmount;
            }
            if (startDate != null)
            {
                matches = matches &&
                        !transaction.getDate().isBefore(startDate);
            }

            if (endDate != null)
            {
                matches = matches &&
                        !transaction.getDate().isAfter(endDate);
            }
            if (matches)
            {
                System.out.println(transaction);
            }
        }
    }



    public void displayMonthToDate()
    {
        LocalDate today = LocalDate.now();

        for (Transaction transaction : ledgerService.getAllTransactions())
        {
            if (transaction.getDate().getMonth() == today.getMonth()
                    && transaction.getDate().getYear() == today.getYear())
            {
                System.out.println(transaction);
            }
            displayLedgerMenu();
        }
    }

    public void displayPreviousMonth()
    {
        LocalDate previousMonth = LocalDate.now().minusMonths(1);

        for (Transaction transaction : ledgerService.getAllTransactions())
        {
            if (transaction.getDate().getMonth() == previousMonth.getMonth()
                    && transaction.getDate().getYear() == previousMonth.getYear())
            {
                System.out.println(transaction);
            }
            displayLedgerMenu();
        }
    }

    public void displayYearToDate()
    {
        int currentYear = LocalDate.now().getYear();

        for (Transaction transaction : ledgerService.getAllTransactions())
        {
            if (transaction.getDate().getYear() == currentYear)
            {
                System.out.println(transaction);
            }
            displayLedgerMenu();
        }
    }

    public void displayPreviousYear()
    {
        int previousYear = LocalDate.now().minusYears(1).getYear();

        for (Transaction transaction : ledgerService.getAllTransactions())
        {
            if (transaction.getDate().getYear() == previousYear)
            {
                System.out.println(transaction);
            }
            displayLedgerMenu();
        }

    }

    public void displayAllTransactions()     //Prints every transaction from the ArrayList
    {
        for (Transaction transaction : ledgerService.getAllTransactions())
        {
            System.out.println(transaction);

        }

        displayLedgerMenu();

    }

    public void displayDeposits()
    {
        for (Transaction transaction : ledgerService.getDeposits())
        {
            System.out.println(transaction);
        }

        displayLedgerMenu();

    }

    public void displayPayments()
    {
        for (Transaction transaction : ledgerService.getPayments())
        {
            System.out.println(transaction);
        }

        displayLedgerMenu();

    }



}













