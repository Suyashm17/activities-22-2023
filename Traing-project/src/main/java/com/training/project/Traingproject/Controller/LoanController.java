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

import com.training.project.Traingproject.Entity.Loan;
import com.training.project.Traingproject.Excepton.BusinessException;
import com.training.project.Traingproject.Services.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/all")
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = loanService.getAllLoans();
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @PostMapping("/apply")
    public ResponseEntity<?> applyForLoan(@RequestParam Long customerId, @RequestParam int loanType) {
        try {
            Loan loan = loanService.applyForLoan(customerId, loanType);
            return new ResponseEntity<>(loan, HttpStatus.CREATED);
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

