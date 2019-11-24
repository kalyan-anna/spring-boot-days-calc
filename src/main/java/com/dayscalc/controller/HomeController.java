package com.dayscalc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dayscalc.model.DateForm;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("dateForm", new DateForm());
		return "index";
	}

	@PostMapping("/result")
	public String calculateDays(@Valid DateForm dateForm, BindingResult result, Model model) {
		model.addAttribute("dateForm", dateForm);
		
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
            return "index";
        }
		
		return "result";
	}
}
