package org.example.junit_testing.service;

import org.junit.*;

import java.util.Date;

public class CalculatorServiceTest {

    int counter = 0;

    @BeforeClass     //executes before all test case
    public static void init() {
        System.out.println("Before all test cases : ");
        System.out.println("Started test : " + new Date());
    }


    @Before     //executes the method before each test case
    public void beforeEach() {
        System.out.println("Before each test case");
    }

    //test methods
    @Test(timeout = 2000)
    public void addTest() throws InterruptedException{
        for (int i = 1; i <= 100; i++) {
            counter += i;
        }
        Thread.sleep(3000);
        System.out.println("test for Add Method");
        int result = CalculatorService.add(12, 13);
        int expected = 25;

        System.out.println("counter in first test case : " + counter);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void sumTest() {
        for (int i = 1; i <= 100; i++) {
            counter += i;
        }
        System.out.println("test for Sum method");
        int result = CalculatorService.sum(1, 2, 3);
        int expected = 6;

        System.out.println("counter in second test case : " + counter);
        Assert.assertEquals(expected, result);
    }

    @After  //executes the method after each test case
    public void afterEach() {
        System.out.println("After each test case");
    }

    @AfterClass     // executes after all the test case.
    public static void cleanup() {
        System.out.println("After all test cases");
        System.out.println("End test cases" + new Date());
    }
}
