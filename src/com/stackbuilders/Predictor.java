package com.stackbuilders;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Dictionary;
import java.util.Hashtable;

public class Predictor {
    // Variables
    private LocalTime beginRange1, endRange1, beginRange2, endRange2;
    private final Dictionary<Integer, DayOfWeek> restrictedDays;

    // Constructor
    Predictor() {
        beginRange1 = LocalTime.of(7, 30);
        endRange1 = LocalTime.of(9, 30);
        beginRange2 = LocalTime.of(16, 0);
        endRange2 = LocalTime.of(19, 30);
        restrictedDays = new Hashtable<>();
        restrictedDays.put(1, DayOfWeek.MONDAY);
        restrictedDays.put(2, DayOfWeek.MONDAY);
        restrictedDays.put(3, DayOfWeek.TUESDAY);
        restrictedDays.put(4, DayOfWeek.TUESDAY);
        restrictedDays.put(5, DayOfWeek.WEDNESDAY);
        restrictedDays.put(6, DayOfWeek.WEDNESDAY);
        restrictedDays.put(7, DayOfWeek.THURSDAY);
        restrictedDays.put(8, DayOfWeek.THURSDAY);
        restrictedDays.put(9, DayOfWeek.FRIDAY);
        restrictedDays.put(0, DayOfWeek.FRIDAY);
    }

    boolean PredictVehiclePresence(String licensePlate, LocalDate date, LocalTime time, StringBuilder messages) {
        boolean result = false;

        // Verify that the license plate is in the day of restricted circulation based on last digit
        int lastDigit = Integer.parseInt(licensePlate.substring(6, 7));
        DayOfWeek plateWeekDay = restrictedDays.get(lastDigit);
        DayOfWeek weekDay = date.getDayOfWeek();
        if (!plateWeekDay.equals(date.getDayOfWeek())) {
            messages.append("That license plate is not restricted on the day you fingered.");
        }
        else {
            // Verify that the fingered time match with the restriction ranges
            if (!(time.isAfter( beginRange1) && time.isBefore(endRange1) || time.isAfter(beginRange2) && time.isBefore(endRange2))) {
                messages.append("That license plate is not restricted on the time you fingered");
            }
            else {
                if (Math.random() >= 0.5)
                    result = true;
            }
        }
        return result;
    }
}
