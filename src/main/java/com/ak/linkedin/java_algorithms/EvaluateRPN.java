package com.ak.linkedin.java_algorithms;

// Write your answer here, and then test your code.
// Your job is to implement the evaluateRPN() method.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class EvaluateRPN {

    public static void main(String[] args) {
        // This is how your code will be called.
        // You can edit this code to try different testing cases.
        String expression = "3 4 + 2 *";
        double result = Answer.evaluateRPNwithStack(expression);
        System.out.println(result);
    }

    class Answer {

        // Change these boolean values to control whether you see
        // the expected result and/or hints.
        static boolean showExpectedResult = false;
        static boolean showHints = false;

        private static boolean isNumber(String token) {
            try {
                Double.parseDouble(token);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        private static boolean isOperator(String token) {
            return "+-*/".contains(token);
        }

        private static double performOperation(String operator, double operand1, double operand2) {
            switch (operator) {
                case "+":
                    return operand1 + operand2;
                case "-":
                    return operand1 - operand2;
                case "*":
                    return operand1 * operand2;
                case "/":
                    return operand1 / operand2;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }
        }

        // Return the result of the Reverse Polish notation expression
        static double evaluateRPNwithStack(String expression) {
            // Split the expression into tokens
            String[] tokens = expression.split(" ");
            Stack<Double> stack = new Stack<>();//TODO: replace with Deque ?

            // Iterate through each token
            for (String token : tokens) {
                if (isNumber(token)) {
                    // Push the number onto the stack
                    stack.push(Double.parseDouble(token));
                } else if (isOperator(token)) {
                    // If it's an operator, pop the top two numbers from the stack
                    if (stack.size() < 2) {
                        throw new IllegalArgumentException("Invalid EvaluateRPN expression: Insufficient values for operation");
                    }
                    double b = stack.pop();
                    double a = stack.pop();

                    // Perform the operation and push the result back onto the stack
                    double result = performOperation(token, a, b);
                    stack.push(result);
                } else {
                    throw new IllegalArgumentException("Invalid EvaluateRPN expression: Unknown token '" + token + "'");
                }
            }

            // At the end, the stack should contain exactly one element (the result)
            if (stack.size() != 1) {
                throw new IllegalArgumentException("Invalid EvaluateRPN expression: Excessive values or insufficient operators");
            }
            return stack.pop();
        }

        // Return the result of the Reverse Polish notation expression
        static double evaluateRPNwithArray(String expression) {
            // Your code goes here.

            ArrayList<String> array = new ArrayList<>(Arrays.asList(expression.split(" ")));
            array.stream().forEach(System.out::println);

            double element1 = 0.0;
            if(array.size() >= 3) {
                for (int i = 0; i < array.size(); i++) {
                    System.out.println(i);
                    String element1Str = array.get(i);
                    System.out.println(element1Str);
                    if (isNumber(element1Str)) {
                        String element2Str = array.get(i + 1);
                        if (isNumber(element2Str)) {
                            String element3 = array.get(i + 2);
                            if(isOperator(element3)) {
                                element1 = performOperation(element3, Double.parseDouble(element2Str), Double.parseDouble(element1Str));
                                i = i + 2;
                            }
                        } else
                        if(isOperator(element2Str)) {
                            element1 = performOperation(element2Str, element1, Double.parseDouble(element1Str));
                            i = i + 1;
                        }
                    }
                }
            }

            return element1;
        }
    }

}