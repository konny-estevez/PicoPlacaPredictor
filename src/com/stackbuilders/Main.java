package com.stackbuilders;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Variables
        String licensePlate, dateString, timeString;
        StringBuilder errorMessage;
        LocalDate date;
        LocalTime time;
        // Scanner object
        Scanner inputText = new Scanner(System.in);
        // Validator object
        Validators validator = new Validators();
        errorMessage = new StringBuilder();

        System.out.println("Pico & Placa Predictor");
        System.out.println();
        // Input and validation of License Plate
        do {
            System.out.println("Please enter a license plate number (format: xxx0000)");
            licensePlate = inputText.nextLine();
            errorMessage.delete(0, errorMessage.length());
            licensePlate = validator.ValidateLicensePlate(licensePlate, errorMessage);
            if (licensePlate == null) {
                System.out.println("Error: " + errorMessage);
                System.out.println("Incorrect license plate, please enter a valid format and value.");
                System.out.println();
            }
        } while (licensePlate == null);
        System.out.println();
        //Input and validation of Date of occurrence
        do {
            System.out.println("Please enter the date (format: yyyy-mm-dd)");
            dateString = inputText.nextLine();
            errorMessage.delete(0, errorMessage.length());
            date = validator.ValidateDate(dateString, errorMessage);
            if (date == null) {
                System.out.println("Error: " + errorMessage);
                System.out.println("Incorrect date, please enter a valid format and value.");
                System.out.println();
            }
        } while (date == null);
        System.out.println();
        // Input and validation of Time of occurrence
        do {
            System.out.println("Please enter the time (format: HH:MM)");
            timeString = inputText.nextLine();
            errorMessage.delete(0, errorMessage.length());
            time = validator.ValidateTime(timeString, errorMessage);
            if (time == null) {
                System.out.println("Error: " + errorMessage);
                System.out.println("Incorrect time, please enter a format and valid value.");
                System.out.println();
            }
        } while (time == null);
        System.out.println();
        Predictor predictor = new Predictor();
        errorMessage.delete(0, errorMessage.length());
        boolean probability = predictor.PredictVehiclePresence(licensePlate, date, time, errorMessage);
        if (errorMessage.length() == 0) {
            System.out.format("The vehicle with license plate %s on date %s at %s is%son the road",
                    licensePlate, date, time, probability ? " " : " NOT ");
        }
        else {
            System.out.println(errorMessage);
        }
        System.out.println();
        System.out.println();
        System.out.println("Process terminated...");
    }
}
