package com.alumnos.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alumnos.models.Materias;


@Repository
public interface MateriaRepository extends JpaRepository<Materias, Integer>{
	//Este repositorio es de gran ayuda para no implementar el crud completamente, para mayor información consutal:
	//https://docs.spring.io/spring-data/data-jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
	
	@Query(value = "SELECT * FROM materia where id = :id", nativeQuery = true)
	Materias findByIds(Integer id);
	//Esta función nos ayuda a implementar querys que necesitamos aparte de los que nos proporciona JpaRepository,
	//Como se ve se inicia con un @Query y se sigue escribiendo la cadena del script.
	//Es importante que al momento de hacer la busqueda el dato que vaya después del := , sea igual al de la función en este caso findByIds
	
}

