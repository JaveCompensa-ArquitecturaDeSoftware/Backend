package proj.arqui.servicioactividad.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import proj.arqui.servicioactividad.entidades.Actividad;

@Repository
public interface RepositorioActividad extends CrudRepository<Actividad, Long>{

}
