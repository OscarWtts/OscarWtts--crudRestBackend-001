package com.jes.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.jes.crud.model.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {
	
}
