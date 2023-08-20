package com.javafee.sapp.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javafee.sapp.model.domain.Password;

public interface PasswordRepository extends JpaRepository<Password, Integer> {
	List<Password> findAllByUserData_Id(Integer userId);

	List<Password> findAllByUserData_IdAndWebPageContains(Integer userId, String webPage);
}
