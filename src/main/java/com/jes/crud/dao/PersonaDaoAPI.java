package com.jes.crud.dao;

import org.springframework.data.repository.CrudRepository;

import com.jes.crud.model.Persona;

public interface PersonaDaoAPI extends CrudRepository<Persona, Long> {
	
}
