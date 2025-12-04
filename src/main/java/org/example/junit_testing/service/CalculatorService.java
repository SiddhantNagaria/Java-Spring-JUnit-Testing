package org.example.junit_testing.service;

public class CalculatorService {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int product(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        return a / b;
    }

    public static int sum(int... numbers) { // The 'numbers' parameter is treated as an array inside the method
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }
}
