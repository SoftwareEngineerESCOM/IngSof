package com.david.materia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepo extends CrudRepository<Materia, Long>{

}
