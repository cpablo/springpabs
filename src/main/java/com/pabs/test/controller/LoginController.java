package com.pabs.test.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pabs.test.model.User;
import com.pabs.test.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String loadLogin(Model model) {
		
		model.addAttribute(new User());
		return "loginUser"; //Must be the name of HTML file.
	}
	
	@PostMapping("loginUser")
	public String loginUser(@ModelAttribute User user, Model model) {
		User searchedUser = null;
		boolean isLogin = false;
		searchedUser = userService.retrieveUser(user.getUsername());
		
		if (searchedUser != null) {
			if (searchedUser.getPassword().equals(user.getPassword())) {
				isLogin = true;
			}
		}
		
		if (isLogin) {
			return "redirect:/mainPage"; 
		}
		
		model.addAttribute("user", new User());
		model.addAttribute("isLogin", isLogin);
		
		return "loginUser.html";
	}
}
