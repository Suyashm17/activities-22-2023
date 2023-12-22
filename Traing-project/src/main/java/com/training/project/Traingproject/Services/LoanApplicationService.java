package com.training.project.Traingproject.Services;

import java.util.List;

import com.training.project.Traingproject.Entity.LoanApplication;
import com.training.project.Traingproject.Excepton.BusinessException;

public interface LoanApplicationService {
    List<LoanApplication> getAllLoanApplications();
    void updateLoanApplicationStatus(Long loanApplicationId, String status) throws BusinessException;
}

