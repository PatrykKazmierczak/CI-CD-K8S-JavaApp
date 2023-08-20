package com.javafee.sapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.javafee.sapp.model.domain.Password;
import com.javafee.sapp.model.repository.PasswordRepository;
import com.javafee.sapp.model.repository.UserDataRepository;
import com.javafee.sapp.service.CryptographicService;
import com.javafee.sapp.service.PasswordService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Service
@RequiredArgsConstructor
@Log
public class PasswordServiceImpl implements PasswordService {
	private final PasswordRepository passwordRepository;
	private final UserDataRepository userDataRepository;
	private final CryptographicService cryptographicService;

	@Override
	public List<Password> findAllByUserId(Integer userId) {
		return passwordRepository.findAllByUserData_Id(userId);
	}

	@Override
	public void save(Password password, Integer userId) throws Exception {
		password.setUserData(userDataRepository.getById(userId));
		password.setPassword(cryptographicService.encrypt(password.getPassword(),
				cryptographicService.generateKey(password.getUserData().getPasswordToken())));
		passwordRepository.save(password);
	}

	@Override
	public Password getById(Integer passwordId) {
		return passwordRepository.getById(passwordId);
	}

	@Override
	public void delete(Integer passwordId) {
		passwordRepository.deleteById(passwordId);
	}

	@Override
	public List<Password> findAllByUserIdWithDecrypted(Integer userId, Integer passwordId) {
		return findAllByUserId(userId).stream().map(e -> {
			if (passwordId.equals(e.getId()))
				try {
					e.setPassword(cryptographicService.decrypt(e.getPassword(),
							cryptographicService.generateKey(e.getUserData().getPasswordToken())));
				} catch (Exception ex) {
					log.severe(ex.getMessage());
				}
			return e;
		}).collect(Collectors.toList());
	}

	@Override
	public List<Password> findAllByUserIdAndWebPage(Integer userId, String webPAge) {
		return passwordRepository.findAllByUserData_IdAndWebPageContains(userId, webPAge);
	}
}
