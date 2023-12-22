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

import com.training.project.Traingproject.Entity.LoanApplication;
import com.training.project.Traingproject.Excepton.BusinessException;
import com.training.project.Traingproject.Services.LoanApplicationService;

@RestController
@RequestMapping("/api/loan-applications")
public class LoanApplicationController {

    @Autowired
    private LoanApplicationService loanApplicationService;

    @GetMapping("/all")
    public ResponseEntity<List<LoanApplication>> getAllLoanApplications() {
        List<LoanApplication> loanApplications = loanApplicationService.getAllLoanApplications();
        return new ResponseEntity<>(loanApplications, HttpStatus.OK);
    }

    @PostMapping("/update-status")
    public ResponseEntity<?> updateLoanApplicationStatus(@RequestParam Long loanApplicationId, @RequestParam String status) {
        try {
            loanApplicationService.updateLoanApplicationStatus(loanApplicationId, status);
            return new ResponseEntity<>("Loan application status updated successfully", HttpStatus.OK);
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
