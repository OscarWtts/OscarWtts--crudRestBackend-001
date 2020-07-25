package com.jes.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jes.crud.model.Persona;
import com.jes.crud.service.PersonaService;

@RestController
@RequestMapping(value = "/api") // Ruta inicial por defecto\
@CrossOrigin("*")
public class PersonaRestController {

	@Autowired
	PersonaService personaService;
	
	// *** LISTAR (READ) ****
	// http://localhost:8888/api/all (GET)
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<Persona> getAll() {
		return personaService.getAll();
	}
	
	// *** CREAR Y ACTUALIZAR (CREATE AND UPDATE) ***
	// http://localhost:8888/api/save (POST)
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Persona> save(@RequestBody Persona persona) {
		Persona obj = personaService.save(persona);
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}

	// *** ELIMINAR (DELETE) *** 
	// http://localhost:8888/api/delete/{id} (GET)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Persona> delete(@PathVariable Long id) {
		Persona persona = personaService.get(id);
		if (persona != null) {
			personaService.delete(id);
			return new ResponseEntity<Persona>(persona, HttpStatus.OK);
		} else {
			return new ResponseEntity<Persona>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// http://localhost:8888/api/find/{id} (GET)
		@RequestMapping(value = "/find/{id}", method = RequestMethod.GET, produces = "application/json")
		public Persona showSave(@PathVariable("id") Long id) {
			return personaService.get(id);
		}
}
