package com.training.project.Traingproject.Services;

import com.training.project.Traingproject.Entity.Customer;
import com.training.project.Traingproject.Excepton.BusinessException;

public interface CustomerService {
    Customer save(Customer customer) throws BusinessException;

	Customer registerCustomer(Customer registrationDto);

	Customer loginCustomer(String email, String password);
   
  
}

