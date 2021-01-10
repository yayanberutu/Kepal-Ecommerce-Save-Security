package com.buyer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.buyer.api.KamarApi;
import com.buyer.model.Kamar;


@RestController
@RequestMapping("kamar")
public class KamarController {
	@Autowired KamarApi kamarapi;
	
	@GetMapping("")
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("listKamar", kamarapi.getAllKamar());
		return mv;
	}
	

}
