package proj.arqui.serviciosedes.reporsitorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import proj.arqui.serviciosedes.entidades.Sede;

@Repository
public interface RepositorioSede extends CrudRepository<Sede, Long>{

}
