package com.ista.springboot.web.prueba.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.springboot.web.prueba.app.entity.Asignatura;
import com.ista.springboot.web.prueba.app.entity.Docente;
import com.ista.springboot.web.prueba.app.repository.IDocenteRepository;

@Service
public class DocenteServiceImpl implements IDocenteService {
	@Autowired
	IDocenteRepository docenteRepository;

	@Override
	public List<Docente> findAll() {
		// TODO Auto-generated method stub
		return (List<Docente>) docenteRepository.findAll();
	}

	@Override
	public Docente save(Docente docente) {
		// TODO Auto-generated method stub
		return docenteRepository.save(docente);
	}

	@Override
	public List<Docente> findById(String nombre) {
		// TODO Auto-generated method stub
		return (List<Docente>) docenteRepository.findAll();
	}
	
	@Override
	public void deleteByid(Integer id) {
		// TODO Auto-generated method stub
		docenteRepository.deleteById(id);
	}

}
