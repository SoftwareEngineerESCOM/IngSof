package com.alumnos.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alumnos.models.Materias;
import com.alumnos.repositories.MateriaRepository;

@RestController
@RequestMapping("/materia")
public class MateriaRest {
	
	@Autowired
	private MateriaRepository materiaRepo;

	@PostMapping(path="/crear")
	public @ResponseBody boolean crearMateria (@RequestBody Materias materia) { 
		//Spring tiene la capacidad de iniciar un objeto siempre y cuando los parametros enviados en el form sean de la clase.
		//En este caso RequestBody lo guardo en materia, y en la llamada al constructor, spring se dedica a hacer todo el trabajo.
		materiaRepo.save(materia);
		return true;
	}

	@GetMapping(path="/obtener") //Esta función es para refrescar el select del ejemplo.
	public @ResponseBody ArrayList<String> buscarMaterias() {
		Iterable<Materias> materiasAux = materiaRepo.findAll();
		ArrayList<String> materias = new ArrayList<String>();
		for(Materias s : materiasAux) {
			materias.add(s.toString());
		}
		return materias;		
	}
}