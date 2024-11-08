package se.meteturkan.common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OptionController {
    private final Scanner scanner;

    public OptionController(Scanner scanner) {
        this.scanner = scanner;
    }

    public int checker(int minOption, int maxOption) {
        int userInput = -1;

        // Prompting user to input until valid option
        do {
            try {
                System.out.print("Choice:\t"); // Prompt user to input
                userInput = scanner.nextInt(); // Read user input
                System.out.println();
                scanner.nextLine(); // To consume the newline

                if (minOption <= userInput && userInput <= maxOption) { // Check if input is within range
                    break; // Exit loop if valid input
                } else {
                    System.out.printf("Invalid input. Please enter between [%d-%d]\n", minOption, maxOption); // Print error message
                }
            } catch (InputMismatchException e) { // Catch block to handle InputMismatchException
                System.out.println("Invalid input. Please enter only a valid integer value"); // Print error message
                scanner.next(); // Clear the invalid input from the scanner
            }
        } while (true); // Continue loop indefinitely until valid input

        return userInput; // Return user choice
    }
}

