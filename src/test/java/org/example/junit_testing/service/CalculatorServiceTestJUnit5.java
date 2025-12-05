package org.example.junit_testing.service;

import org.junit.jupiter.api.*;

public class CalculatorServiceTestJunit5 {

    //  execute a test logic before all test cases

    @BeforeAll
    public static void init() {
        System.out.println("This is initial test case before all test case");
    }


    @BeforeEach
    public void beforeEachTestCase() {
        System.out.println("Before Each test method");
    }

    @AfterEach
    public void afterEachTestCase() {
        System.out.println("After Each test method");
    }

    @Test
    @DisplayName("This is custom made test")
    public void addTest() {
        System.out.println("This is first test case - add method");
        int actual = CalculatorService.add(12, 12);
        int expectedResult = 24;
        Assertions.assertEquals(expectedResult, actual, "test failed");
    }

    @Test
    //@Disabled
    public void sumTest() {
        System.out.println("this is second test method - sum method");
        int actual = CalculatorService.sum(2, 2, 2);
        int expected = 6;
        Assertions.assertEquals(expected, actual, "Test Failed");
    }

    //execute a test before after all test case

    @AfterAll
    public static void cleanup() {
        System.out.println("After all the test cases");
    }
}