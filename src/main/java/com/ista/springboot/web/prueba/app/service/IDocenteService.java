package com.ista.springboot.web.prueba.app.service;

import java.util.List;

import com.ista.springboot.web.prueba.app.entity.Docente;

public interface IDocenteService{
	
	public List<Docente> findAll();

	public Docente save(Docente docente);

	public List<Docente> findById(String nombre);

	public void deleteByid(Integer id);

}
