package com.javafee.sapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javafee.sapp.model.domain.Test;
import com.javafee.sapp.model.repository.TestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {
	private final TestRepository testRepository;

	public List<Test> getAll() {
		return testRepository.findAll();
	}
}
