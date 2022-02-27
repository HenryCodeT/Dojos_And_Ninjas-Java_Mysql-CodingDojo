package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Dojo;
import com.codingdojo.mvc.repositories.DojoRepository;

@Service
public class DojoService {
	
	// //// FIELDS ////
	@Autowired
	DojoRepository dojoRepository;
	
	// //// FIND ALL DOJOS ////
	public List<Dojo> allDojos() {
		System.out.println("service - find - all - dojos: "+dojoRepository.findAll());
		System.out.println("-------------- FIND ALL DOJOS FROM DB ---------------");
		return dojoRepository.findAll();
	}
	
	// //// CREATE NEW DOJO ////
	public Dojo newDojo(Dojo dojo) {
		System.out.println("-------------- CREATE NEW DOJO DB ---------------");
		return dojoRepository.save(dojo);
	}

	// //// FIND DOJO BY ID ////
	public Dojo findDojobyId(Long id) {
		System.out.println("-------------- SERVICE GET DOJO BY ID---------------");
		Optional<Dojo> optional = dojoRepository.findById(id);
		System.out.println("service-optional: "+optional);
		if (optional.isPresent()) {
			System.out.println("-------------- FIND DOJO BY ID DB ---------------");
			return optional.get();
		} else {
			System.out.println("-------------- NOT FIND DOJO BY ID DB ---------------");
			return null;
		}
	}
	
}
