package com.ak.linkedin.java_algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EvaluateRPNTest {

    @ParameterizedTest
    @CsvSource({
        "3 4 +, 7.0",
        "10 5 -, 5.0",
        "2 3 *, 6.0",
        "8 2 /, 4.0",
        "5 1 2 + 4 * + 3 -, 14.0",
        "42, 42.0"
    })
    void testValidRPNExpressions(String expression, double expected) {
        double result = EvaluateRPN.Answer.evaluateRPNwithStack(expression);
        assertEquals(expected, result, 0.0001);
    }

    @ParameterizedTest
    @CsvSource({
        "'3 +', Invalid RPN expression: Insufficient values for operation",
        "'5 5 5 +', Invalid RPN expression: Excessive values or insufficient operators",
        "'4 x +', Invalid RPN expression: Unknown token 'x'",
        "'', Invalid RPN expression: Excessive values or insufficient operators"
    })
    void testInvalidRPNExpressions(String expression, String expectedMessage) {
        Exception exception;
        // General case for other invalid situations
        exception = assertThrows(IllegalArgumentException.class, () -> {
            EvaluateRPN.Answer.evaluateRPNwithStack(expression);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void testDivisionByZero() {
        String expression = "4 0 /";
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            EvaluateRPN.Answer.evaluateRPNwithStack(expression);
        });
        assertEquals("/ by zero", exception.getMessage());
    }
}