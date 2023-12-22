package com.training.project.Traingproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.Traingproject.Dao.CreditScoreRepository;
import com.training.project.Traingproject.Dao.LoanApplicationRepository;
import com.training.project.Traingproject.Dao.LoanOfficerRepository;
import com.training.project.Traingproject.Entity.CreditScore;
import com.training.project.Traingproject.Entity.LoanApplication;
import com.training.project.Traingproject.Entity.LoanOfficer;
import com.training.project.Traingproject.Excepton.BusinessException;
import com.training.project.Traingproject.Services.LoanOfficerService;

@Service
public class LoanOfficerServiceImpl implements LoanOfficerService {

    @Autowired
    private LoanOfficerRepository loanOfficerRepository;

    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    @Autowired
    private CreditScoreRepository creditScoreRepository;

    @Override
    public LoanApplication loginLoanOfficer(String employeeId, String password) throws BusinessException {
        try {
            // Find the loan officer by employee ID and password
            return loanOfficerRepository.findByEmployeeIdAndPassword(employeeId, password)
                    .orElseThrow(() -> new BusinessException("Invalid credentials for Loan Officer"));
        } catch (Exception e) {
            // Handle exceptions and throw BusinessException
            throw new BusinessException("Error occurred while logging in Loan Officer", e);
        }
    }

    @Override
    public List<LoanApplication> viewLoanApplications() {
        return loanApplicationRepository.findAll();
    }

    @Override
    public void updateLoanApplicationStatus(Long loanApplicationId, String status) throws BusinessException {
        try {
            LoanApplication loanApplication = loanApplicationRepository.findById(loanApplicationId)
                    .orElseThrow(() -> new BusinessException("Loan application not found with ID: " + loanApplicationId));

            loanApplication.setStatus(status);

            loanApplicationRepository.save(loanApplication);

        } catch (Exception e) {
            throw new BusinessException("Error occurred while updating loan application status", e);
        }
    }

	@Override
	public List<CreditScore> viewCreditScores(String customerPan) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

    
    }


    