package com.pabs.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pabs.test.constants.AppConstants;
import com.pabs.test.model.User;
import com.pabs.test.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//@RequestMapping(value="/LoadDetail", method=RequestMethod.GET)
	@GetMapping(value="/LoadUser")
	public String loadUsers(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("todo", AppConstants.ADD);
		model.addAttribute("listUser",userService.getAllUsers());
		return "maintenance/user_detail";
	}
	
	//@RequestMapping(value="/retrieveUser", method=RequestMethod.GET)
	@GetMapping(value="/RetrieveUser")
	public String retrieveUser(Model model, @RequestParam("username") String username) {
		User user = userService.retrieveUser(username);
		System.out.println("Retrieve here."+user.getUserId());
		model.addAttribute("user",user);
		model.addAttribute("todo", AppConstants.EDIT);
		model.addAttribute("listUser",userService.getAllUsers());
		return "maintenance/user_detail";
	}
	
	//@RequestMapping(value="/SaveUser", method=RequestMethod.POST)
	@PostMapping(value="/SaveUser")
	public String createUser(@Valid User usersss, BindingResult bindingResult, Model model) {
		
		if (!bindingResult.hasErrors()) {
			userService.createUser(usersss);
			model.addAttribute("user", new User());
			model.addAttribute("todo", AppConstants.ADD);
			System.out.println("Create here.");;
		}
		model.addAttribute("listUser",userService.getAllUsers());
		
		return "maintenance/user_detail";
	}
	
	//@RequestMapping(value="/UpdateUser", method=RequestMethod.POST)
	@PostMapping(value="/UpdateUser")
	public String updateUser(@Valid User user, BindingResult bindingResult, Model model) {
		
		if (!bindingResult.hasErrors()) {
			userService.editUser(user);
			System.out.println("Edit here."+user.getUserId());
			model.addAttribute("user", new User());
			model.addAttribute("todo", AppConstants.ADD);
		}
		model.addAttribute("listUser",userService.getAllUsers());
		
		return "maintenance/user_detail";
	}
	
	//@RequestMapping(value="/DeleteUser", method=RequestMethod.GET)
	@GetMapping(value="/DeleteUser")
	public String deleteUser(Model model, @RequestParam("userId") Long userId) {
		userService.deleteUser(userId);
		model.addAttribute("user", new User());
		model.addAttribute("todo", AppConstants.ADD);
		model.addAttribute("listUser",userService.getAllUsers());
		
		return "maintenance/user_detail";
	}
	
	/*
	@ModelAttribute("listUser")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}*/
}
