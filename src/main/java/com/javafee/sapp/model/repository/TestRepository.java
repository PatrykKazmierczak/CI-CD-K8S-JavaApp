package com.javafee.sapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javafee.sapp.model.domain.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {
}
