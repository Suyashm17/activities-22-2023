package com.training.project.Traingproject.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.project.Traingproject.Entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
}

