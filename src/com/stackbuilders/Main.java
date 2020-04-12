package com.stackbuilders;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Variables
        String licensePlate, date, time;

        // Scanner object
        Scanner inputText = new Scanner(System.in);
        System.out.println("Pico & Placa Predicotr");
        System.out.println();
        System.out.println("Please enter a license plate number");
        licensePlate = inputText.nextLine();
        System.out.println("Please enter the date");
        date = inputText.nextLine();
        System.out.println("Please enter the time");
        time = inputText.nextLine();
    }
}
