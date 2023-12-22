package com.training.project.Traingproject.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.project.Traingproject.Entity.CreditScore;
import com.training.project.Traingproject.Entity.Customer;

@Repository
public interface CreditScoreRepository extends JpaRepository<CreditScore, Long> {
    Optional<CreditScore> findByCustomer(Customer customer);
}

