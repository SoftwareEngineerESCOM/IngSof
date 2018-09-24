package com.alumnos.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.ManyToMany;

@Entity
@Table(name="materia")
public class Materias implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String grupo;
    private String nombre;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "materia_alumno", joinColumns = @JoinColumn(name = "materiaId"), inverseJoinColumns = @JoinColumn(name = "alumnoId"))
    private Set<Alumno> alumnos;
       
    public Materias() {
    	super();
    }
	public Materias(String nombre, String grupo) {
		super();
		this.nombre = nombre;
		this.grupo = grupo;
	}
	public Materias(String[] datos) {
		super();
		this.nombre = datos[0];
		this.grupo = datos[1];
	}
	public Materias(String nombre, String grupo,Set<Alumno> alumnos) {
		super();
		this.nombre = nombre;
		this.grupo = grupo;
		this.alumnos = alumnos;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;	
	}
	
	public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
	    	
}