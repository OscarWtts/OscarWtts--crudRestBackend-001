package com.jes.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jes.crud.model.Persona;
import com.jes.crud.service.PersonaService;

@Controller
public class PersonaController {

	@Autowired
	PersonaService personaService;

	// http://localhost:8888/ (GET)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("list", personaService.getAll());
		return "index";
	}

	// http://localhost:8888/update/{id} (GET)
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String showSave(@PathVariable("id") Long id, Model model) {
		if (id != null && id != 0)
			model.addAttribute("persona", personaService.get(id));
		else
			model.addAttribute("persona", new Persona());

		return "add";
	}

	// http://localhost:8888/add (POST)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String save(Persona persona) {
		personaService.save(persona);
		return "redirect:/";
	}

	// http://localhost:8888/delete/{id} (GET)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		personaService.delete(id);
		return "redirect:/";
	}
}
