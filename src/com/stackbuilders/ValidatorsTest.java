package com.stackbuilders;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class ValidatorsTest {
    private Validators validator;

    @Before
    public void setup() {
        validator = new Validators();
    }

    @Test
    public void validateLicensePlate_shouldReturnValidated() {
        StringBuilder errors = new StringBuilder();
        String licensePlate = validator.ValidateLicensePlate("PBO1234", errors);
        Assert.assertEquals(licensePlate, "PBO1234");
    }

    @Test
    public void validateLicensePlate_shouldReturnNullForInvalidLicensePlate() {
        StringBuilder errors = new StringBuilder();
        String licensePlate = validator.ValidateLicensePlate("PBO1234", errors);
        Assert.assertNull(licensePlate);
    }

    @Test
    public void validateDate_shouldReturnValidated() {
        StringBuilder errors = new StringBuilder();
        LocalDate date = validator.ValidateDate("2020-05-05", errors);
        Assert.assertEquals(date, LocalDate.of(2020, 5,5));
    }

    @Test
    public void validateDate_shourlReturnNullForInvalidDate() {
        StringBuilder errors = new StringBuilder();
        LocalDate date = validator.ValidateDate("2020-15-15", errors);
        Assert.assertNull(date);
    }

    @Test
    public void  validateTime_shouldReturnValidated() {
        StringBuilder errors = new StringBuilder();
        LocalTime time = validator.ValidateTime("10:10", errors);
        Assert.assertEquals(time, LocalTime.of(10,10));
    }

    @Test
    public void  validateTime_shouldReturnNullForInvalidTime() {
        StringBuilder errors = new StringBuilder();
        LocalTime time = validator.ValidateTime("10:10", errors);
        Assert.assertNull(time);
    }
}
