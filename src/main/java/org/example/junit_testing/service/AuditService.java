package org.example.junit_testing.service;

// A dependency: maybe talks to DB, external API, etc.
public interface AuditService {
    void logOperation(String operation, int a, int b, int result);
}
