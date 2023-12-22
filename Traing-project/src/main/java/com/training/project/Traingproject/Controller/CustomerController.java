package com.training.project.Traingproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.project.Traingproject.Entity.Customer;
import com.training.project.Traingproject.Excepton.BusinessException;
import com.training.project.Traingproject.Services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer registrationDto) {
        Customer customer = customerService.registerCustomer(registrationDto);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestParam String email, @RequestParam String password) {
        Customer customer = customerService.loginCustomer(email, password);
		return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}

