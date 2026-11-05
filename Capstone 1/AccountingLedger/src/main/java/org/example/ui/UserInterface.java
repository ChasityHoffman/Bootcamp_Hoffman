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
    private static final String PURPLE = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";


    public UserInterface() {
        ledgerService = new LedgerService();
        fileManager = new FileManager();
        scanner = new Scanner(System.in);
    }

    public void displayHomeScreen() {       //Shows the main menu
        System.out.println(CYAN +
                "\n╔══════════════════════════════════════╗\n" +
                "║          BUDGET TRACKER              ║\n" +
                "║     Personal Finance Manager         ║\n" +
                "╚══════════════════════════════════════╝\n"
                + RESET);
        System.out.println(GREEN + "D)" + RESET + " Add Deposit");
        System.out.println(PURPLE + "P)" + RESET + " Make Payment");
        System.out.println(YELLOW + "L)" + RESET + " Ledger");
        System.out.println(CYAN + "X)" + RESET + " Exit");
        System.out.print(CYAN + "\nSelect an option: " + RESET);

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
                System.out.println(CYAN +
                        "\n╔════════════════════════════════════════════╗\n" +
                        "║          THANK YOU FOR USING               ║\n" +
                        "║            BUDGET TRACKER                  ║\n" +
                        "╠════════════════════════════════════════════╣\n" +
                        "║ Your transactions have been saved.         ║\n" +
                        "║                                            ║\n" +
                        "║ Your Personal Finance Manager hopes        ║\n" +
                        "║ to see you back again soon!                ║\n" +
                        "╚════════════════════════════════════════════╝\n"
                        + RESET);
                break;

            default:
                System.out.println(PURPLE +
                        "\nInvalid option. Please try again."  //brings User back to homescreen
                        + RESET);

                displayHomeScreen();

        }
    }

    public void addDeposit() {

        System.out.println(GREEN +
                "\n╔══════════════════════╗\n" +
                "║     ADD DEPOSIT      ║\n" +
                "╚══════════════════════╝\n"
                + RESET);

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

        System.out.println(GREEN +
                "\n✓ Deposit saved successfully!"
                + RESET);

        displayHomeScreen();                                  //keeps the program running
    }

    public void addPayment()
    {
        System.out.println(PURPLE +
                "\n╔══════════════════════╗\n" +
                "║    MAKE PAYMENT      ║\n" +
                "╚══════════════════════╝\n"
                + RESET);

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

        System.out.println(PURPLE +
                "\n✓ Payment saved successfully!"
                + RESET);

        displayHomeScreen();                               //keeps the program running

    }


    public void displayLedgerMenu()
    {
        System.out.println(YELLOW +
                "\n╔══════════════════════╗\n" +
                "║       LEDGER         ║\n" +
                "╚══════════════════════╝\n"
                + RESET);

        System.out.println(YELLOW + "A)" + RESET + " All Transactions");
        System.out.println(YELLOW + "D)" + RESET + " Deposits");
        System.out.println(YELLOW + "P)" + RESET + " Payments");
        System.out.println(YELLOW + "R)" + RESET + " Reports");
        System.out.println(YELLOW + "H)" + RESET + " Home");

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
                System.out.println(PURPLE +
                        "\nInvalid option. Please try again."
                        + RESET);

                displayLedgerMenu();
        }
    }

    public void displayReportsMenu()
    {
        System.out.println(CYAN +
                "\n╔══════════════════════╗\n" +
                "║       REPORTS        ║\n" +
                "╚══════════════════════╝\n"
                + RESET);

        System.out.println(CYAN + "1)" + RESET + " Month To Date");
        System.out.println(CYAN + "2)" + RESET + " Previous Month");
        System.out.println(CYAN + "3)" + RESET + " Year To Date");
        System.out.println(CYAN + "4)" + RESET + " Previous Year");
        System.out.println(CYAN + "5)" + RESET + " Search By Vendor");
        System.out.println(CYAN + "6)" + RESET + " Custom Search");
        System.out.println(CYAN + "0)" + RESET + " Back");

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
                System.out.println(PURPLE +
                        "\nInvalid option. Please try again."
                        + RESET);

                displayReportsMenu();
        }
    }

    public void searchByVendor()
    {
        System.out.print("\nEnter Vendor Name: ");
        String vendorSearch = scanner.nextLine();

        for (Transaction transaction : ledgerService.getAllTransactions())
        {
            if (transaction.getVendor()
                    .toLowerCase()
                    .contains(vendorSearch.toLowerCase()))
            {
                System.out.println(transaction);
            }
        }

        displayLedgerMenu();
    }

    public void customSearch()                         //filter transactions by start date, end date,
    {                                                  //description, vendor, and amount.
        System.out.println(CYAN +
                "\n╔══════════════════════════════╗\n" +
                "║       CUSTOM SEARCH          ║\n" +
                "╚══════════════════════════════╝\n"
                + RESET);

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
        displayReportsMenu();
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
        }
        displayLedgerMenu();
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
        }
        displayLedgerMenu();
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
        }
        displayLedgerMenu();
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
        }
        displayLedgerMenu();

    }

    public void displayAllTransactions()     //Prints every transaction from the ArrayList
    {
        for (Transaction transaction : ledgerService.getAllTransactions())
        {
            if (transaction.getAmount() > 0)
            {
                System.out.println(GREEN + transaction + RESET);      //color coded deposit adding
            }                                                         //subtracting money
            else
            {
                System.out.println(PURPLE + transaction + RESET);
            }

        }

        displayLedgerMenu();

    }

    public void displayDeposits()

    {
        for (Transaction transaction : ledgerService.getDeposits())
        {
            System.out.println(GREEN + transaction + RESET);
        }

        displayLedgerMenu();
    }

    public void displayPayments()
    {
        for (Transaction transaction : ledgerService.getPayments())
        {
            System.out.println(PURPLE + transaction + RESET);
        }

        displayLedgerMenu();
    }



}













