package com.javafee.sapp.controller.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javafee.sapp.model.domain.Password;
import com.javafee.sapp.model.domain.UserData;
import com.javafee.sapp.service.PasswordService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/web/app/password")
@RequiredArgsConstructor
public class PasswordController {
	private final PasswordService passwordService;

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("passwords", passwordService.findAllByUserId(
				((UserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()
		));
		return "password-list";
	}

	@PostMapping("/search")
	public String search(@RequestParam("searchText") String searchText, Model model) {
		model.addAttribute("passwords",
				passwordService.findAllByUserIdAndWebPage(
						((UserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId(), searchText));
		return "password-list";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("pass") Password password) throws Exception {
		passwordService.save(password, ((UserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
		return "redirect:/web/app/password/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("pass", new Password());
		return "password-form";
	}

	@GetMapping("/view")
	public String view(@RequestParam("passwordId") Integer id, Model model) {
		model.addAttribute("passwords",
				passwordService.findAllByUserIdWithDecrypted(
						((UserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId(), id));
		return "password-list";
	}

	@GetMapping("/update")
	public String update(@RequestParam("passwordId") Integer id, Model model) {
		model.addAttribute("pass", passwordService.getById(id));
		return "password-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("passwordId") Integer id) {
		passwordService.delete(id);
		return "redirect:/web/app/password/list";
	}
}
