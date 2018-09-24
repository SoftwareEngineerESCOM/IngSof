package com.alumnos.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alumnos.models.Materias;
import com.alumnos.repositories.MateriaRepository;

@RestController    // This means that this class is a Controller
@RequestMapping("/materia")
public class MateriaRest {
	
	@Autowired
	private MateriaRepository materiaRepo;

	@PostMapping(path="/crear")
	public String crearMateria (@RequestBody Materias materia) {
		materiaRepo.save(materia);
		return "Materia Guardada";
	}

	@GetMapping(path="/obtener")
	public @ResponseBody Iterable<Materias> buscarMaterias() {
		System.out.println("hola");
		return materiaRepo.findAll();
	}
}