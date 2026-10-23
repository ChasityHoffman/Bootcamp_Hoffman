package org.example;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book[] books = new Book[20];

        books[0] = new Book(1, "9780547928227", "The Hobbit", false, "");
        books[1] = new Book(2, "9780439708180", "Harry Potter and the Sorcerer's Stone", true, "John");
        books[2] = new Book(3, "9780061120084", "To Kill a Mockingbird", false, "");
        books[3] = new Book(4, "9781982137274", "The Silent Patient", true, "Emma");
        books[4] = new Book(5, "9780307277671", "The Road", false, "");
        books[5] = new Book(6, "9780553386790", "A Game of Thrones", true, "Michael");
        books[6] = new Book(7, "9780141439600", "Pride and Prejudice", false, "");
        books[7] = new Book(8, "9780385490818", "The Alchemist", false, "");
        books[8] = new Book(9, "9780062316097", "The Four Agreements", true, "Sarah");
        books[9] = new Book(10, "9780590353427", "Matilda", false, "");

        books[10] = new Book(11, "9781451673319", "Fahrenheit 451", true, "David");
        books[11] = new Book(12, "9780345803481", "The Great Gatsby", false, "");
        books[12] = new Book(13, "9780060850524", "Brave New World", false, "");
        books[13] = new Book(14, "9780307588371", "Gone Girl", true, "Ashley");
        books[14] = new Book(15, "9780316769488", "The Catcher in the Rye", false, "");
        books[15] = new Book(16, "9781501128035", "It", true, "Chris");
        books[16] = new Book(17, "9780140449266", "The Odyssey", false, "");
        books[17] = new Book(18, "9780735211292", "Atomic Habits", true, "Jessica");
        books[18] = new Book(19, "9781449474256", "Milk and Honey", false, "");
        books[19] = new Book(20, "9780399590504", "Educated", false, "");

        System.out.println(" Hello! Welcome to the ****  Mystical Library  ****  Choose an option below! yay!");

        boolean running = true;

        while (running) {
            System.out.println(" ****  Options  ****");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked out Books");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n**** Available Books ****");
                    for (Book book : books) {
                        if (!book.isCheckedOut()) {
                            System.out.println(book.getId() + " - "
                                    + book.getIsbn() + " - " + book.getTitle());
                        }
                    }

                    System.out.println("\nEnter Book ID to check out a book");
                    System.out.println("0 to go back to the home screen");

                    int bookId = scanner.nextInt();

                    if (bookId == 0) {
                        break;
                    }

                    for (Book book : books) {
                        if (book.getId() == bookId) {
                            scanner.nextLine();
                            System.out.println("Enter your name: ");
                            String name = scanner.nextLine();
                            ;

                            book.checkOut(name);
                            System.out.println("\"" + book.getTitle() + "\" has been checked out to "
                                    + name + " . ");
                        }
                    }
                    break;

                case 2:
                    System.out.println("\nChecked Out Books:");

                    for (Book book : books) {
                        if (book.isCheckedOut()) {
                            System.out.println(book.getId() + " - " + book.getIsbn()
                                    + " - " + book.getTitle() + " (" + book.getCheckedOutTo() + ")");

                        }
                    }
                    System.out.println("\nC - Check In a Book");
                    System.out.println("x - Return to the Home Screen");

                    String option = scanner.next();

                    if (option.equalsIgnoreCase("X")) {
                        break;
                    }

                    if (option.equalsIgnoreCase("C")) {
                        System.out.println("Enter Book Id to Check In");

                        int checkInBookId = scanner.nextInt();

                        for (Book book : books) {
                            if (book.getId() == checkInBookId) {
                                book.checkIn();
                                System.out.println("\"" + book.getTitle() + "\" has been checked in.");
                            }
                        }
                    }

                    break;

                case 3:
                    System.out.println("Goodbye and remember knowledge is power!");
                    running = false;
                    break;

            }
        }
    }
}
