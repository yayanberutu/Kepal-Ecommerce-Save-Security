package com.buyer.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.buyer.api.UserApi;
import com.buyer.model.Role;
import com.buyer.model.User;
import com.buyer.utils.SecurePassword;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	@Autowired UserApi userapi;
	
	@GetMapping("")
	public ModelAndView pageRegistration() {
		ModelAndView mv = new ModelAndView("registration");
		mv.addObject("user", new User());
		return mv;
	}
	
	@RequestMapping(value = "/submit")
	public ModelAndView registration(@ModelAttribute User user) throws NoSuchAlgorithmException {
		SecurePassword scr = new SecurePassword();
		byte[] salt = scr.findSalt(); 
		scr.setSalt(salt);
		user.setPassword(scr.getSecurePassword(user.getPassword(), scr.getSalt()));
		user.setSalt(salt.toString());
		user.setEnabled(true);
		userapi.addUser(user);
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("user", user);
		return mv;
	}
	
}
