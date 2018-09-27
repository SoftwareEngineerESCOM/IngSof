package com.archivos;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="archivo")
public class ArchivoModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String path;
 
	
	public ArchivoModel() {
		super();
	}
	
	public ArchivoModel(String nombre, String path) {
		super();
		this.nombre = nombre;
		this.path = path;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPath() {
		return nombre;
	}
	public void setPath(String path) {
		this.path = path;
	}
   

	
}