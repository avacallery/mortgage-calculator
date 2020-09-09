package com.avacallery;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int principal = 0;
        float annualInterest = 0;
        byte years = 0;

	    Scanner scanner = new Scanner(System.in);

	    while (true) {
            System.out.println("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("You must enter a between 1000 and 1000000.");
        }

	    while (true) {
            System.out.println("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30)
                break;

            System.out.println("Please enter a value between 1 and 30.");
        }

	    while (true) {
            System.out.println("Years: ");
            years = scanner.nextByte();
            if (years >= 1 && years <= 30)
                break;

            System.out.println("Please enter a value between 1 and 30.");
        }


	    double mortgage = calculateMortgage(principal, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

    }

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years) {

        final byte MONTHS_PER_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = annualInterest / PERCENT / MONTHS_PER_YEAR;
        short numberOfPayments = (short)(years * MONTHS_PER_YEAR);
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1 );

        return mortgage;
    }
}
