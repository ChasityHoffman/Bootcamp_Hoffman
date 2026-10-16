package Calculators;

import java.util.Scanner;

public class Calculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's take a look at how much " +
                "interest you'll gain and the tota balance.");

        System.out.println("How much are you depositing?");
            int deposit = scanner.nextInt();
        System.out.println("How much is the annual rate?");
            double interest = scanner.nextDouble();
        System.out.println("When does the account mature?");
            int years = scanner.nextInt();

        double rate = interest / 100;
        double dailyRate = rate / 365;
        double futureValue = deposit * Math.pow(1 + (rate / 365),
                 365 * years);
        double totalInterest = futureValue - deposit;

        System.out.printf("Future Value: $%.2f%n", futureValue);
        System.out.printf("Total Interest Earned: $%.2f%n", totalInterest);


    }
}
