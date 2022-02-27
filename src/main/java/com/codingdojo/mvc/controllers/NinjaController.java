package com.codingdojo.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.mvc.models.Dojo;
import com.codingdojo.mvc.models.Ninja;
import com.codingdojo.mvc.services.DojoService;
import com.codingdojo.mvc.services.NinjaService;

@Controller
public class NinjaController {
	
	// //// FIELDS ////
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	// //// RETRIEVE DOJO ////
	@GetMapping("/dojos/{id}")
	public String showNinjasDojo(@PathVariable("id") Long id, Model model) {
		System.out.println("controller-dojo-id: "+id);
		Dojo dojo = dojoService.findDojobyId(id);
		model.addAttribute("dojo", dojo);
		return "dojoshow";
	}
	// //// NINJA NEW ////
	// ---- show page ---------
	@GetMapping("/ninjas/new")
	public String newNinjaView(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "ninjanew";
	}
	// ---- post ninja --------
	@PostMapping("/ninjas/new")
	public String postNinja(@Valid @ModelAttribute("ninja") Ninja ninja,
							BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println("------ THE FORM HAS ERRORS -------");
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos", dojos);
			return "ninjanew";
		} else {
			System.out.println("----------- INIT CREATE NEW NINJA ------------");
			ninjaService.newNinja(ninja);
			System.out.println("controller-new-ninja-dojo_id: "+ninja.getDojo().getId());
			return "redirect:/dojos/"+ninja.getDojo().getId();
		}
	}
	
}
