package com.archivos;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ArchivoRepository extends CrudRepository<ArchivoModel, Integer>{


}