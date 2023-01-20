package com.ista.springboot.web.prueba.app.service;

import java.util.List;


import com.ista.springboot.web.prueba.app.entity.Asignatura;

public interface IAsignaturaService {

	public List<Asignatura> findAll();

	public Asignatura save(Asignatura asignatura);

	public List<Asignatura> findById(String nombre);

	public void deleteById(Integer id);

}
