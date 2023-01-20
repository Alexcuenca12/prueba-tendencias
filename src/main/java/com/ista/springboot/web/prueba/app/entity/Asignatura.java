package com.ista.springboot.web.prueba.app.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "asignatura")
@Getter
@Setter
public class Asignatura implements Serializable{

	private static final long serialVersionUID = -8423968969869049222L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_asignatura;
	
	@NotNull(message = "400 Bad Request")
	private String nombre;
	
	@NotNull(message = "400 Bad Request")
	private String carrera;
	
	@NotNull(message = "400 Bad Request")
	private String hora_ini;
	
	@NotNull(message = "400 Bad Request")
	private String hora_fin;
	
	  @ManyToOne
	  @JoinColumn(name = "id_docente", referencedColumnName = "id_docente")
	  private Docente docente;
	  

}
