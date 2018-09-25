package com.alumnos.rest;


import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alumnos.models.Alumno;
import com.alumnos.models.Materias;
import com.alumnos.repositories.AlumnoRepository;
import com.alumnos.repositories.MateriaRepository;

@RestController()   //Declaramos que tipo de controlador será
@RequestMapping("/alumno") //Aqui asignamos una dirección que será el descriptor de nuestro RestController
public class AlumnoRest {
	
	@Autowired //Esta notación ayuda a Spring a saber con que bean nos vamos a conectar para evitar configurarlo nosotros.
	private AlumnoRepository alumnoRepo; 
	
	@Autowired
	private MateriaRepository materiaRepo;

	@PostMapping("/crear")
	public @ResponseBody boolean crearMateria (@RequestBody Map<String, Object> datos) {
		//RequestBody nos ayuda obtener todo el cuerpo de request, la mejor forma de tratarlo es con un Map<String,Object>, debido a la facilidad
		//a la hora de obtener los datos.
		//ResponseBody, esta notación indica a Spring que solo responderemos un tipo de dato al request, no vamos a cargar ninguna página ni
		//nada por el estilo, al igual que nos ayuda a castear el tipo de dato que sea regresado a un objeto JSON.
		Alumno alumno = new Alumno((String)datos.get("nombre"),Integer.toString((Integer)datos.get("boleta")));
		if(datos.get("materias")!=null) {
			ArrayList<?> idsMaterias = (ArrayList<?>) datos.get("materias"); //Hacemos un casteo, debido a que este es un tipo de dato array, enviado por
			//el multiple select del frontend
			for(Object id : idsMaterias) {
				Materias materia = materiaRepo.findByIds((Integer.parseInt((String)id))); //crear esta clase para obtener un Objeto tipo Materia
				//Ya que el predefinido por JPARepository nos regresa un Optional.
				alumno.setMaterias(materia); //Este metodo agrega una materia a la relación many to many de materia_alumno
				materia.setAlumnos(alumno); //Este metodo agrega un alumno a la relación many to many materia_alumno
				//Al ser un campo meny to many la relación alumno materia, se tiene que asignar 
				//tanto el alumno en la materia como la materia en el alumno en su arreglo declarado en el modal.
				//Esto hacer que exista una relación bidireccional
			}
		}
		alumnoRepo.save(alumno);
		return true;
	}

	
}