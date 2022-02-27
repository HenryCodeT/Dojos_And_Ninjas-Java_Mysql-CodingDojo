package com.codingdojo.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.mvc.models.Dojo;
import com.codingdojo.mvc.services.DojoService;

@Controller
public class DojoController {
	// //// FIELDS ////////////////////////////////////////////////
	@Autowired
	DojoService dojoService;
	
	// //// INDEX ///////////////////////////////////////////////
	// ---- retrieve dojos --------------------------------------
	@GetMapping("/dojos")
	public String index(Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		System.out.println("----------- CONTROLER INDEX PAGE SHOW ALL DOJOS ------------");
		return "index";
	}
	// //// NEW DOJO //////////////////////////////////////////
	// ---- retrieve new dojo --------------------------------
	@GetMapping("/dojos/new")
	public String dojoNew(@ModelAttribute("dojo") Dojo dojo) {
		return "dojonew";
	}
	@PostMapping("/dojos/new")
	public String dojoNewPost(	@Valid @ModelAttribute("dojo") Dojo dojo,
								BindingResult result,
								Model model) {
		if (result.hasErrors()) {
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos", dojos);
			System.out.println("----------- NOT VALID POST DOJO ------------");
			return "dojonew";
		}else {
			System.out.println("----------- VALID POST DOJO ------------");
			dojoService.newDojo(dojo);
			return "redirect:/dojos";
		}
	}
	
}
