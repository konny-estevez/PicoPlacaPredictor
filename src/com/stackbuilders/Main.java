package com.stackbuilders;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Variables
        String licensePlate, date, time;

        // Scanner object
        Scanner inputText = new Scanner(System.in);
        System.out.println("Pico & Placa Predictor");
        System.out.println();
        do {
            System.out.println("Please enter a license plate number (format: Pxx0000)");
            licensePlate = inputText.nextLine();
            if (licensePlate.length() != 7)
                System.out.println("Incorrect license plate, please enter a valid value.");
        } while (licensePlate.length() != 7);
        do {
            System.out.println("Please enter the date (format: yyyy/mm/dd)");
            date = inputText.nextLine();
            if (date.length() != 10)
                System.out.println("Incorrect date, please enter a valid value.");
        } while (date.length() != 10);
        do {
            System.out.println("Please enter the time (format: HH:MM)");
            time = inputText.nextLine();
            if (time.length() != 5)
                System.out.println("Incorrect time, please enter a valid value.");
        } while (time.length() != 5);
    }
}
