package com.jes.crud.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.jes.crud.model.Persona;
import com.jes.crud.service.PersonaService;
import com.jes.crud.commons.*;
import com.jes.crud.dao.PersonaDaoAPI;


@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaService{
	
	@Autowired
	private PersonaDaoAPI personaDaoAPI;
	
	@Override
	public CrudRepository<Persona, Long> getDao() {

		return personaDaoAPI;
	}
}