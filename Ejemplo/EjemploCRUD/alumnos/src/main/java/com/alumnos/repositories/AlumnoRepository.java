package com.alumnos.repositories;

import org.springframework.stereotype.Repository;

import com.alumnos.models.Alumno;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Integer>{
	
	@Query(value = "select * from alumno where id = :id", nativeQuery = true)
	Alumno findByIds(Integer id);
	
	@Modifying
	@Query("update alumno set boleta = ':boleta' where id = :id")
	void setUserInfo(Integer id, String boleta);

}

