package org.example.junit_testing.service;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorServiceTest {



    //test methods
    @Test
    public void addTest(){
        int result = CalculatorService.add(12,13);
        int expected = 25;

        Assert.assertEquals(expected,result);
    }

    @Test
    public void sumTest(){
        int result = CalculatorService.sum(1,2,3);
        int expected = 6;

        Assert.assertEquals(expected,result);
    }
}
