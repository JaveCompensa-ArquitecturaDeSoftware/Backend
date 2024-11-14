package proj.arqui.servicioreservas.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import proj.arqui.servicioreservas.entidades.Reserva;


@Repository
public interface RepositorioReserva extends CrudRepository<Reserva, Long>{

}
