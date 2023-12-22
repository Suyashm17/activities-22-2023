package com.training.project.Traingproject.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.project.Traingproject.Entity.Login;
import com.training.project.Traingproject.Entity.LoginLog;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

	void save(LoginLog loginLog);
}

