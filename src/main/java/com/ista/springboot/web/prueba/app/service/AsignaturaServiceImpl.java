package com.ista.springboot.web.prueba.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.springboot.web.prueba.app.entity.Asignatura;
import com.ista.springboot.web.prueba.app.repository.IAsignaturaRepository;


@Service
public class AsignaturaServiceImpl implements IAsignaturaService{

	@Autowired
	IAsignaturaRepository asignaturaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Asignatura> findAll() {
		// TODO Auto-generated method stub
		return  (List<Asignatura>)asignaturaRepository.findAll();
	}

	@Override
	@Transactional
	public Asignatura save(Asignatura asignatura) {
		// TODO Auto-generated method stub
		return asignaturaRepository.save(asignatura);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asignatura> findById(String nombre) {
		// TODO Auto-generated method stub
		return (List<Asignatura>) asignaturaRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		asignaturaRepository.deleteById(id);
	}
	



}
