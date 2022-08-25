
package com.Proyecto.demo.repository;
import com.Proyecto.demo.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author maryg
 */
@Repository
public interface PersonaRepository extends CrudRepository<Persona,Long>{
    Persona findByNombre (String nombre);
    
    
}
