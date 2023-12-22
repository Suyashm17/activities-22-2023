package com.training.project.Traingproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.Traingproject.Dao.CustomerRepository;
import com.training.project.Traingproject.Dao.LoanRepository;
import com.training.project.Traingproject.Entity.Customer;
import com.training.project.Traingproject.Entity.Loan;
import com.training.project.Traingproject.Excepton.BusinessException;
import com.training.project.Traingproject.Services.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public Loan applyForLoan(Long customerId, int loanType) throws BusinessException {
        try {
            Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new BusinessException("Customer not found with ID: " + customerId));

            Loan newLoan = new Loan();
            newLoan.setLoanType(loanType);
            newLoan.setCustomer(customer);

            
            return loanRepository.save(newLoan);

        } catch (Exception e) {
            throw new BusinessException("Error occurred while applying for a loan", e);
        }
    }

}

