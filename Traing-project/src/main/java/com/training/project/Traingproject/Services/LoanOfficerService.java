package com.training.project.Traingproject.Services;

import java.util.List;

import com.training.project.Traingproject.Entity.CreditScore;
import com.training.project.Traingproject.Entity.LoanApplication;
import com.training.project.Traingproject.Entity.LoanOfficer;
import com.training.project.Traingproject.Excepton.BusinessException;

public interface LoanOfficerService {
    LoanApplication loginLoanOfficer(String employeeId, String password) throws BusinessException;
    List<LoanApplication> viewLoanApplications();
    void updateLoanApplicationStatus(Long loanApplicationId, String status) throws BusinessException;
    List<CreditScore> viewCreditScores(String customerPan) throws BusinessException;
}

