package org.example.junit_testing.service;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        Calculator2ServiceTest.class
})
public class CalculatorTestSuite {
    // no code needed
}
