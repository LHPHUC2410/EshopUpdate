package com.Estore.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Estore.entity.User;
import com.Estore.repository.UserRepository;

@Controller
public class HomeController {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/test")
	public String index() {
		System.out.println("ok");
		return "index";
	}

	@GetMapping("/login")
	public String showform() {
		return "index";
	}

	@PostMapping("/login")
	public String login(Model model,@RequestParam("username") String username, @RequestParam("password") String password) 
	{
		User user = userRepository.findByUsername(username).orElse(null);
		if(password.equals(user.getPassword())) {
			model.addAttribute("message", "Succesfull");
			return "index";
		} else 
		{
			model.addAttribute("message", "failed");
			return "index";
		}

	}

}
