package com.buyer.controller;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.buyer.model.Role;
import com.buyer.model.User;

@RestController
public class LoginController {
	
	@GetMapping("/login")
	public ModelAndView pageLogin() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	

}