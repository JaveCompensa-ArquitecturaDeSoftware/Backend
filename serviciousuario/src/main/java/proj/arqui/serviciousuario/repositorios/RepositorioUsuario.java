package proj.arqui.serviciousuario.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import proj.arqui.serviciousuario.entidades.Usuario;

@Repository
public interface RepositorioUsuario extends CrudRepository<Usuario, Long>{

}
