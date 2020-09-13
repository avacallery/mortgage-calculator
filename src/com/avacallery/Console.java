package com.avacallery;

import java.util.Scanner;

public class Console {
    // every time we call readNumber, it creates a new instance of the Scanner class
    // so, we declare Scanner as a private static field
    // it is only used when this method(s) are called
    // WE CAN USE THIS CLASS WHENEVER WE WANT TO READ A VALUE FROM THE CONSOLE
    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt) {
        return scanner.nextDouble();
    }

    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.println(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Please enter a value between " + min + " and " + max);
        }
        return value;
    }
}
