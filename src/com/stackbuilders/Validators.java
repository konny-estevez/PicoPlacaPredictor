package com.stackbuilders;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Validators {
    // Vraiables
    private static String licensePlateExpression;
    private static Pattern licensePlatePattern;
    private static Character[] provinceLetters = { 'A', 'B', 'U', 'C', 'X', 'H', 'O', 'E', 'W', 'G', 'I', 'L', 'R', 'M', 'V', 'N', 'S', 'P', 'Q', 'K', 'T', 'Z', 'Y', 'J'};

    // Constructor
    Validators() {
        licensePlateExpression = "^\\(?([A-Z]{3})\\)?([0-9]{4})$";
        licensePlatePattern = Pattern.compile(licensePlateExpression);
    }

    // License Plate Validation Method
    String ValidateLicensePlate(String licensePlate, StringBuilder errorMessage) {
        String result = null;
        licensePlate = licensePlate.trim();
        Matcher m = licensePlatePattern.matcher(licensePlate);
        if (m.find()) {
            if (!Arrays.asList(provinceLetters).contains(licensePlate.charAt(0)))
                errorMessage.append("Not valid province letter on License Plate");
            else
                result = licensePlate;
        }
        else
            errorMessage.append("License Plate not match");
        return  result;
    }

    // Date Validation Method
    LocalDate ValidateDate(String dateString, StringBuilder errorMessage) {
        try {
            return LocalDate.parse(dateString);
        }
        catch (Exception ex) {
            errorMessage.append(ex.getMessage());
        }
        return null;
    }

    // Time Validation Method
     LocalTime ValidateTime(String timeString, StringBuilder errorMessage) {
        try {
            return LocalTime.parse(timeString);
        }
        catch (Exception ex) {
            errorMessage.append(ex.getMessage());
        }
        return null;
    }
}
