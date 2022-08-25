
package com.Proyecto.demo.repository;
import com.Proyecto.demo.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author maryg
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long>{
    Usuario findByNombre (String nombre);
    
    
}
