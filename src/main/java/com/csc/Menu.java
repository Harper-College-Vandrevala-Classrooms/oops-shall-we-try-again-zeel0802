package com.csc;

import java.util.Scanner;

public class Menu {

    public static int prompt(Integer lowerBound, Integer upperBound, String promptMessage, String errorMessage) {
        int value; // Variable to store user input

        try (Scanner scanner = new Scanner(System.in)) { // Using try-with-resources to auto-close the scanner
            while (true) { // Loop until valid input is received
                System.out.println(promptMessage); // Display prompt message

                // Check if the input is an integer
                if (scanner.hasNextInt()) {
                    value = scanner.nextInt(); // Read the input value

                    // Validate input based on optional bounds
                    if ((lowerBound == null || value >= lowerBound) && (upperBound == null || value <= upperBound)) {
                        return value; // Return valid input
                    } else {
                        System.out.println(errorMessage); // Display error message if input is out of bounds
                    }
                } else {
                    System.out.println(errorMessage); // Display error message if input is not an integer
                    scanner.next(); // Clear invalid input
                }
            }
        } // Scanner will automatically be closed here
    }

    public static void main(String[] args) {
        // Example of how to use the prompt function
        int result = prompt(0, 100, "Please enter a value between 0 and 100:", "Your value is invalid. Please try again.");
        System.out.println("The value chosen by the user is " + result);
    }
}