package com.training.project.Traingproject.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.Traingproject.Dao.CustomerRepository;
import com.training.project.Traingproject.Entity.Customer;
import com.training.project.Traingproject.Excepton.BusinessException;
import com.training.project.Traingproject.Services.CustomerService;

import io.micrometer.common.util.StringUtils;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) throws BusinessException {
        try {
            
            validateCustomer(customer);

            
            return customerRepository.save(customer);
        } catch (Exception e) {
            
            throw new BusinessException("Error occurred while saving customer", e);
        }
    }

    
    private void validateCustomer(Customer customer) throws BusinessException {
        if (customer == null || StringUtils.isBlank(customer.getFirstName()) || StringUtils.isBlank(customer.getLastName())) {
            throw new BusinessException("Customer data is invalid");
        }
       
    }


	@Override
	public Customer registerCustomer(Customer registrationDto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Customer loginCustomer(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
