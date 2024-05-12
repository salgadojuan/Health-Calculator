package com.example.individualhealthassessmentgui;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;



public class IndividualHealthAssessmentProgram {

    private static Scanner UserInput = new Scanner(System.in);

    // PROMPTS THE USER FOR THEIR NAME:
    private static String promptUserForName() {

        System.out.println("Enter your name: ");
        return UserInput.nextLine();
    }

    private static double promptUserForDouble(String message) {
        double input = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println(message);
                input = UserInput.nextDouble();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid number or numbers.");
                UserInput.next();
            }
        }

        return input;
    }
}
