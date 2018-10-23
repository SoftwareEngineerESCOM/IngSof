package com.david.alumno;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.david.materia.Materia;

@Entity
@Table(name="Alumno")
public class Alumno {
	@Id
	@GeneratedValue
	public Long id;
	public String nombre;
	public String boleta;
	@ManyToMany(mappedBy="alumnos")
	public Set<Materia> materias = new HashSet<Materia>();

	public Alumno() {
	}

	public Alumno(String nombre, String boleta) {
		this.nombre = nombre;
		this.boleta = boleta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getBoleta() {
		return boleta;
	}

	public void setBoleta(String boleta) {
		this.boleta = boleta;
	}

	public Set<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(Set<Materia> materias) {
		this.materias = materias;
	}

}
