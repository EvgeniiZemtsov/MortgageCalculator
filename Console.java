package com.company;

import java.util.Scanner;

public class Console {

    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value > min && value <= max)
                break;
            System.out.println("Enter a value greater than " + min + " and less or equal to " + max + ".");
        }
        return value;
    }
}
