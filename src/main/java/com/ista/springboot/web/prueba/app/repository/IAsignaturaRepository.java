package com.ista.springboot.web.prueba.app.repository;




import org.springframework.data.jpa.repository.JpaRepository;


import com.ista.springboot.web.prueba.app.entity.Asignatura;

public interface IAsignaturaRepository extends JpaRepository<Asignatura, Integer> {

}
