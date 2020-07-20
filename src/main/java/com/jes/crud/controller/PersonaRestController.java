package com.jes.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jes.crud.model.Persona;
import com.jes.crud.service.PersonaService;

@RestController
@RequestMapping(value = "/api/")
public class PersonaRestController {

	@Autowired
	PersonaService personaService;

	// http://localhost:8888/ (GET)
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Persona> getAll() {
		return personaService.getAll();
	}

	// http://localhost:8888/find/{id} (GET)
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public Persona showSave(@PathVariable("id") Long id) {
		return personaService.get(id);
	}

	// http://localhost:8888/save (POST)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Persona> save(Persona persona) {
		Persona obj = personaService.save(persona);
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}

	// http://localhost:8888/delete/{id} (GET)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<Persona> delete(@PathVariable Long id) {
		Persona persona = personaService.get(id);
		if (persona != null) {
			personaService.delete(id);
			return new ResponseEntity<Persona>(persona, HttpStatus.OK);
		} else {
			return new ResponseEntity<Persona>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
