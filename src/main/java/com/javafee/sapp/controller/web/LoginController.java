package com.javafee.sapp.controller.web;

import java.security.NoSuchAlgorithmException;

import javax.security.auth.login.LoginException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javafee.sapp.model.domain.UserData;
import com.javafee.sapp.service.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Controller
@RequestMapping("/web/login")
@RequiredArgsConstructor
@Log
public class LoginController {
	private final CustomUserDetailsService userDetailsService;

	@GetMapping("/login-page")
	public String showLoginPage() {
		return "login-form";
	}

	@GetMapping("/register-page")
	public String showRegistrationPage(Model model) {
		model.addAttribute("user", new UserData());
		return "registration-form";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("user") UserData userData) throws NoSuchAlgorithmException {
		String response = "redirect:/web/login/login-page";
		try {
			userDetailsService.createUser(userData.getLogin(), userData.getPassword());
			response += "?registered";
		} catch (LoginException e) {
			log.severe(e.getMessage());
			response = "redirect:/web/login/register-page?loginAlreadyExists";
		} catch (Exception e) {
			log.severe(e.getMessage());
			response = "redirect:/web/login/register-page?error";
		}
		return response;
	}
}
