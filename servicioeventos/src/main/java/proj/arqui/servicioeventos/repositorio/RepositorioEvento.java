package proj.arqui.servicioeventos.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import proj.arqui.servicioeventos.entidades.Evento;

@Repository
public interface RepositorioEvento extends CrudRepository<Evento, Long> {

}
