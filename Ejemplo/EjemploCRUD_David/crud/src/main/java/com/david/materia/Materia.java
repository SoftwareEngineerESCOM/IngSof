package com.david.materia;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.david.alumno.Alumno;

@Entity
@Table(name = "Materia")
public class Materia {
	@Id
	@GeneratedValue
	public Long id;
	public String nombre;
	public String grupo;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "materia_alumno", joinColumns = @JoinColumn(name = "materiaId"), inverseJoinColumns = @JoinColumn(name = "alumnoId"))
	public Set<Alumno> alumnos;

	public Materia() {
	}

	public Materia(String nombre, String grupo) {
		this.nombre = nombre;
		this.grupo = grupo;
	}

	public Materia(String nombre, String grupo, Set<Alumno> alumnos) {
		this.nombre = nombre;
		this.grupo = grupo;
		this.alumnos = alumnos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

}
