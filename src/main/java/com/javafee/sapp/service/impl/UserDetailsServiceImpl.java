package com.javafee.sapp.service.impl;

import java.security.NoSuchAlgorithmException;

import javax.security.auth.login.LoginException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javafee.sapp.model.domain.UserData;
import com.javafee.sapp.model.repository.UserDataRepository;
import com.javafee.sapp.service.CryptographicService;
import com.javafee.sapp.service.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements CustomUserDetailsService {
	private final UserDataRepository userDataRepository;
	private final CryptographicService cryptographicService;

	@Override
	public UserDetails loadUserByUsername(String login) {
		return userDataRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("User not present"));
	}

	@Override
	public void createUser(String login, String password) throws NoSuchAlgorithmException, LoginException {
		//TODO: Handle salt
		if (!userDataRepository.findAllByLogin(login).isEmpty())
			throw new LoginException("User with given login already exists");
		String passwordToken = cryptographicService.generateRandomText(16);
		userDataRepository.save(
				UserData.builder()
						.login(login)
						.passwordToken(passwordToken)
						.password(cryptographicService.calculateSHA512(password))
						.build());
	}
}
