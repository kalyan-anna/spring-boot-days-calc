package com.dayscalc.controller;

import java.time.temporal.ChronoUnit;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dayscalc.model.DateForm;

@Controller
public class DaysCalcController {

	@GetMapping("/")
	public String dateForm(Model model) {
		model.addAttribute("dateForm", new DateForm());
		return "index";
	}

	@PostMapping("/result")
	public String calculateDays(@Valid DateForm dateForm, BindingResult result, Model model) {
		model.addAttribute("dateForm", dateForm);
		
		if (result.hasErrors()) {
            return "index";
        }
		
		model.addAttribute("daysCount", ChronoUnit.DAYS.between(dateForm.getStartDate(), dateForm.getEndDate()));		
		return "result";
	}
}
