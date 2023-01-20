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

import com.ista.springboot.web.prueba.app.entity.Asignatura;
import com.ista.springboot.web.prueba.app.service.IAsignaturaService;
@RestController
@RequestMapping("/api/asignatura")
public class AsignaturaController {
	
	@Autowired
	IAsignaturaService asignaturaService;

	@GetMapping("/listar")
	public ResponseEntity<List<Asignatura>> obtenerLista() {
		return new ResponseEntity<>(asignaturaService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<Asignatura> crear(@Validated @RequestBody Asignatura a) {
		Asignatura asig = asignaturaService.save(a);
		if (asignaturaService.save(a).equals(true)) {
			return new ResponseEntity<>(asig, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Asignatura> eliminar(@PathVariable Integer id) {
		asignaturaService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Asignatura> actualizarUsuario(@PathVariable String nombre, @RequestBody Asignatura a) {
		Asignatura asignatura = (Asignatura) asignaturaService.findById(nombre);
		if (asignatura == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				asignatura. setHora_fin(a.getHora_fin());
				asignatura.setHora_ini(a.getHora_ini());
				asignatura.setCarrera(a.getCarrera());
				asignatura.setDocente(a.getDocente());
				return new ResponseEntity<>(asignaturaService.save(asignatura), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}

	}
}
