package org.example.junit_testing.service;

import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Timeout;

@ExtendWith(MockitoExtension.class) // Use Mockito with JUnit 5
class Calculator2ServiceTest {

    @Mock
    AuditService auditService;          // Mock dependency

    @InjectMocks
    Calculator2Service calculator2Service;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Runs once before all tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Runs once after all tests");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Runs before each test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Runs after each test");
    }

    @Test
    @DisplayName("Add method should return sum and log operation")
    void testAdd() {
        System.out.println("Add method - testing");
        int result = calculator2Service.add(2, 3);
        int expected = 5;
        assertEquals(expected, result); // assertion

        // verify that mock was used
        verify(auditService).logOperation("add", 2, 3, 5);
    }

    @Test
    void testSubtractAssertions() {
        System.out.println("Testing subtract method");
        int result = calculator2Service.subtract(10, 4);

        assertAll("subtract",
                () -> assertEquals(6, result),
                () -> assertTrue(result > 0),
                () -> assertNotEquals(0, result)
        );
    }

    @Test
    void testOnlyOnDev() {
        String env = System.getenv("APP_ENV");
        assumeTrue("DEV".equals(env), "Test only valid in DEV environment");

        int result = calculator2Service.add(1, 2);
        assertEquals(3, result);
    }

    @Test
    void testWithInfo(TestInfo testInfo, TestReporter testReporter) {
        testReporter.publishEntry("TestName", testInfo.getDisplayName());

        int result = calculator2Service.add(3, 4);
        assertEquals(7, result);
    }

//    @Test
//    void testAddWithAuditFailure() {
//        when(auditService.logOperation(anyString(), anyInt(), anyInt(), anyInt()))
//                .thenThrow(new RuntimeException("Audit failed")); // just example
//
//        assertThrows(RuntimeException.class,
//                () -> calculator2Service.add(1, 2)
//        );
//    }

    @Test
    @DisplayName("Divide should throw IllegalArgumentException when divisor is zero")
    void divideByZero_shouldThrowException() {
        // Arrange: nothing special

        // Act + Assert
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calculator2Service.divide(10, 0)
        );

        assertEquals("b must not be zero", ex.getMessage());
    }

    @Test
    void add_multipleChecks() {
        int result = calculator2Service.add(7, 8);

        assertAll("add checks",
                () -> assertEquals(15, result),
                () -> assertTrue(result > 10),
                () -> assertNotEquals(0, result)
        );

        verify(auditService).logOperation("add", 7, 8, 15);
    }

    @Test
    void add_shouldBeFast() {
        assertTimeout(java.time.Duration.ofMillis(100), () -> {
            calculator2Service.add(10, 20);
        });
    }

    @Test
    @Disabled("Not implemented yet")
    void testMultiply_notYetImplemented() {
        fail("Multiply not implemented");
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void add_shouldCompleteWithin100ms() {
        calculator2Service.add(1, 2);
    }

}
