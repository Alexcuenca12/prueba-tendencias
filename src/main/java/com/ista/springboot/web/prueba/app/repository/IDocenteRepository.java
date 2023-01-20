package com.ista.springboot.web.prueba.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ista.springboot.web.prueba.app.entity.Docente;


public interface IDocenteRepository extends JpaRepository<Docente, Integer> {

}
