package com.javafee.sapp.service;

import java.util.List;

import com.javafee.sapp.model.domain.Password;

public interface PasswordService {
	List<Password> findAllByUserId(Integer userId);

	void save(Password password, Integer userId) throws Exception;

	Password getById(Integer passwordId);

	void delete(Integer passwordId);

	List<Password> findAllByUserIdWithDecrypted(Integer userId, Integer passwordId);

	List<Password> findAllByUserIdAndWebPage(Integer userId, String webPAge);
}
