package com.training.project.Traingproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.project.Traingproject.Entity.CreditScore;
import com.training.project.Traingproject.Entity.LoanApplication;
import com.training.project.Traingproject.Excepton.BusinessException;
import com.training.project.Traingproject.Services.LoanOfficerService;

@RestController
@RequestMapping("/api/loan-officers")
public class LoanOfficerController {

    @Autowired
    private LoanOfficerService loanOfficerService;

    @PostMapping("/login")
    public ResponseEntity<?> loginLoanOfficer(@RequestParam String employeeId, @RequestParam String password) {
        try {
            LoanApplication loanOfficer = loanOfficerService.loginLoanOfficer(employeeId, password);
            return new ResponseEntity<>(loanOfficer, HttpStatus.OK);
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/view-applications")
    public ResponseEntity<List<LoanApplication>> viewLoanApplications() {
        List<LoanApplication> loanApplications = loanOfficerService.viewLoanApplications();
        return new ResponseEntity<>(loanApplications, HttpStatus.OK);
    }

    @PostMapping("/update-application-status")
    public ResponseEntity<?> updateLoanApplicationStatus(@RequestParam Long loanApplicationId, @RequestParam String status) {
        try {
            loanOfficerService.updateLoanApplicationStatus(loanApplicationId, status);
            return new ResponseEntity<>("Loan application status updated successfully", HttpStatus.OK);
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    
    }

    // Add other loan officer-related endpoints


