package com.jes.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.jes.crud.model.Persona;
import com.jes.crud.repository.PersonaRepository;
import com.jes.crud.service.PersonaServiceImpl;
import com.jes.crud.commons.*;


@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaService{
	
	@Autowired
	private PersonaRepository personaDaoAPI;
	
	@Override
	public CrudRepository<Persona, Long> getDao() {

		return personaDaoAPI;
	}	
}