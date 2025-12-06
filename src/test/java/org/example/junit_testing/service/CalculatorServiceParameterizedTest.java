package org.example.junit_testing.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)  // ✅ VERY IMPORTANT
class CalculatorServiceParameterizedTest {

    @Mock
    AuditService auditService;        // ✅ Mock dependency

    @InjectMocks
    Calculator2Service calculator2Service;  // ✅ Class under test, constructed by Mockito

    @ParameterizedTest(name = "0 + {0} should be {0}")
    @ValueSource(ints = {0, 1, 10, 100})
    @DisplayName("Add: 0 + x = x")
    void add_zeroPlusX_shouldReturnX(int x) {
        // Act
        int result = calculator2Service.add(0, x);

        // Assert
        assertEquals(x, result);
        verify(auditService).logOperation("add", 0, x, x);
    }
}
