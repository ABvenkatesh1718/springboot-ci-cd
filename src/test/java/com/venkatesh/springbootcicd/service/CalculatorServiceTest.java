package com.venkatesh.springbootcicd.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    @DisplayName("Should return correct sum for two positive integers")
    void testAdd() {
        int result = calculatorService.add(10, 20);
        assertEquals(30, result, "10 + 20 should equal 30");
    }

    @Test
    @DisplayName("Should return correct division result")
    void testDivideSuccess() {
        double result = calculatorService.divide(10, 2);
        assertEquals(5.0, result, "10 / 2 should equal 5.0");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when dividing by zero")
    void testDivideByZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculatorService.divide(10, 0)
        );
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}