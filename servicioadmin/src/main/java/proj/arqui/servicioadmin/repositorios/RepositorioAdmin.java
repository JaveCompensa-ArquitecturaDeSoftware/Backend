package proj.arqui.servicioadmin.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import proj.arqui.servicioadmin.entidades.Admin;

@Repository
public interface RepositorioAdmin extends CrudRepository<Admin, Long>{

}
