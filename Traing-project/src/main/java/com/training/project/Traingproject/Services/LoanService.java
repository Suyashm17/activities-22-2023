package com.training.project.Traingproject.Services;

import java.util.List;

import com.training.project.Traingproject.Entity.Loan;
import com.training.project.Traingproject.Excepton.BusinessException;

public interface LoanService {
    List<Loan> getAllLoans();
    Loan applyForLoan(Long customerId, int loanType) throws BusinessException;
 
}

