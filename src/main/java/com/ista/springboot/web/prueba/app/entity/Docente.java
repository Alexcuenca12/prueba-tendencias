package com.ista.springboot.web.prueba.app.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "docente")
@Getter
@Setter
public class Docente implements Serializable {

	private static final long serialVersionUID = 1917930176432009295L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id_docente;
	
	@NotNull(message = "400 Bad Request")
	private String nombre_docente;
	
	@NotNull(message = "400 Bad Request")
	private String apellido_docente;
	
	@NotNull(message = "400 Bad Request")
	private String celular;
	
	@Email
	private String email;
	
	@JsonIgnore
	 @OneToMany(mappedBy = "docente")
	private List<Asignatura> asignatura;
	


}
