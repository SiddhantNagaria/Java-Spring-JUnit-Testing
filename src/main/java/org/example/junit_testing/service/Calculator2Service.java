package org.example.junit_testing.service;

// Service we want to test
public class Calculator2Service {

    private  final  AuditService auditService;

    public Calculator2Service(AuditService auditService) {
        this.auditService = auditService;
    }

    public  int add(int a, int b) {
        int result = a + b;
        auditService.logOperation("add", a, b, result);
        return result;
    }

    public int subtract(int a, int b) {
        int result = a - b;
        auditService.logOperation("subtract", a, b, result);
        return result;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("b must not be zero");
        }
        int result = a / b;
        auditService.logOperation("divide", a, b, result);
        return result;
    }
}
