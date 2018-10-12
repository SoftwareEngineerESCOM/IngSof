package com.alumnos.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.NaturalId;


@Entity
@Table(name="materia")
public class Materias implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String grupo;
    @NaturalId
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

    public void setAlumnos(Alumno alumnos) {
        this.alumnos.add(alumnos);
    }

	@Override
	public String toString() {
		return "{\"id\":" + id + ", \"nombre\" :" +" \" "+nombre+" \" "+"}";
		//Este string es por conveniencia, debido a que nos ayuda a la hora de la creación de nuestro JSON que responderemos en alguna llamada.
	}
		    	
}