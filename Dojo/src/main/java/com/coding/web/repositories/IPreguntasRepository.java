package com.coding.web.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coding.web.models.Preguntas;

public interface IPreguntasRepository  extends CrudRepository<Preguntas, Long>{
	List<Preguntas> findAll();
}
