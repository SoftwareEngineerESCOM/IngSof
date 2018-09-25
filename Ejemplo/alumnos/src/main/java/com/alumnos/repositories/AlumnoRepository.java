package com.alumnos.repositories;

import org.springframework.stereotype.Repository;

import com.alumnos.models.Alumno;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Integer>{


}

