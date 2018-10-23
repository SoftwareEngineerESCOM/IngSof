package com.david.alumno;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepo extends CrudRepository<Alumno, Long> {

}
