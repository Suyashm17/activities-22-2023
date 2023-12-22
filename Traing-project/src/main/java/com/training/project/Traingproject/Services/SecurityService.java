package com.training.project.Traingproject.Services;

public interface SecurityService {
    void logLoginAttempt(String email, boolean success);
    void logAudit(String details);
    
}

