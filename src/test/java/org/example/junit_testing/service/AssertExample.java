package org.example.junit_testing.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AssertExample {

    //  Assertion - validating actual result with expected result
    //  Assertions class

    @Test
    public void test1() {
        System.out.println("Testing some assertion methods");
        int actual = 12;
        int expected = 12;
        //overloaded methods
        Assertions.assertEquals(expected, actual);

        int[] actualArr = {1, 2, 3, 4};
        int[] expectedArr = {1, 2, 3, 4};
        Assertions.assertArrayEquals(expectedArr, actualArr);

//        String name= new String("Rahul");
//        String expectedName = new String("Rahul");
//        Assertions.assertEquals(expectedName, name);
//        Assertions.assertSame(expectedName, name);
        String name = "Rahul";
        String expectedName = "Rahul";
        Assertions.assertEquals(expectedName, name);
        Assertions.assertSame(expectedName, name);

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);
        Assertions.assertIterableEquals(list2, list1);

        Assertions.assertThrows(RuntimeException.class, () -> {
            System.out.println("this is testing executable");
            throw new RuntimeException("This is testing execution");
        });
    }

}
