package com.codingdojo.mvc.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Ninja;
import com.codingdojo.mvc.repositories.NinjaRepository;

@Service
public class NinjaService {
	// //// FIELDS ////
	@Autowired
	NinjaRepository ninjaRepository;
	
	// //// CREATE NEW NINJA ///////////
	public Ninja newNinja(Ninja ninja) {
		System.out.println("-------------- CREATE NEW NINJA DB ---------------");
		return ninjaRepository.save(ninja);
	}
}
