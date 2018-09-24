package com.alumnos.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alumnos.models.Alumno;
import com.alumnos.models.Materias;
import com.alumnos.repositories.AlumnoRepository;

@RestController()   // This means that this class is a Controller
@RequestMapping("/alumno")
public class AlumnoRest {
	
	@Autowired
	private AlumnoRepository alumnoRepo;

	@GetMapping("/crear")
	public String crearMateria (@RequestBody Alumno alumno) {
		alumnoRepo.save(alumno);
		return "Guardado";
	}

	@GetMapping("/buscar")
	public @ResponseBody List<Alumno> buscarAlumnos() {
		return alumnoRepo.findAll();
	}
}