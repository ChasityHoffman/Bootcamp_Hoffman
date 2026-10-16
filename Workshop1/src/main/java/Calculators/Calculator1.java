package Calculators;

import java.util.Scanner;

public class Calculator1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello!! We are going to calculate your monthly payment for a loan.");

        System.out.println("What is the principle of your loan?");
            int principle = scanner.nextInt();
        System.out.println("What is your annual interest rate?");
            double interest = scanner.nextDouble();

                scanner.nextLine();

        System.out.println("How many years is your loan length?");
            int years = scanner.nextInt();

        double monthlyRate = interest / 100 / 12;
        int numberOfPayments = years * 12;
        double monthlyPayment = principle * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments))
                / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
        double totalpaid = monthlyPayment * numberOfPayments; double totalInterest = totalpaid - principle;

        System.out.printf("Monthly payment: $%.2f%n", monthlyPayment);
        System.out.printf("Total Interest paid: $%.2f%n" , totalInterest);
    }
}
