package com.alumnos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * Este main es importante ya que todoas las páginas que no serán consumidas, podrían ir aquí.
 * para tener un mejor control y una practica más limpia en cuanto a la implementación de código en Spring.
 * Este controlador no será mas que la plataforma para navegar sin consultar la base de datos.
 * 
 * */
@Controller
public class MainController {
	
	@RequestMapping("/")
	public String main() {
		return "menu";
	}
}
