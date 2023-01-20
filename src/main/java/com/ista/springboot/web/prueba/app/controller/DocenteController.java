package com.ista.springboot.web.prueba.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ista.springboot.web.prueba.app.entity.Docente;
import com.ista.springboot.web.prueba.app.service.IDocenteService;

@RestController
@RequestMapping("/api/docente")
public class DocenteController {

	@Autowired
	IDocenteService docenteService;

	@GetMapping("/listar")
	public ResponseEntity<List<Docente>> obtenerLista() {
		return new ResponseEntity<>(docenteService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<Docente> crear(@Validated @RequestBody Docente d) {
		Docente doc = docenteService.save(d);
		if (docenteService.save(d).equals(true)) {
			return new ResponseEntity<>( HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Docente> eliminar(@PathVariable Integer id) {
		docenteService.deleteByid(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Docente> actualizarUsuario(@PathVariable String nombre, @RequestBody Docente d) {
		Docente docente = (Docente) docenteService.findById(nombre);
		if (docente == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				docente.setApellido_docente(d.getApellido_docente());
				docente.setCelular(d.getCelular());
				docente.setEmail(d.getEmail());
				return new ResponseEntity<>(docenteService.save(docente), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}

	}

}
