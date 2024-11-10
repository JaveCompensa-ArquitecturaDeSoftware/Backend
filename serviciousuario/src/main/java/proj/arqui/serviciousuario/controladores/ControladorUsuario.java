package proj.arqui.serviciousuario.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proj.arqui.serviciousuario.dtos.UsuarioDTO;
import proj.arqui.serviciousuario.entidades.Usuario;
import proj.arqui.serviciousuario.servicios.ServicioUsuario;

@RestController
@RequestMapping(value = "/Usuario")
public class ControladorUsuario {
    ServicioUsuario ServicioUsuario;

    @Autowired
    ControladorUsuario(ServicioUsuario ServicioUsuario){
        this.ServicioUsuario = ServicioUsuario;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDTO get(@PathVariable Long id){
        return ServicioUsuario.get(id);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UsuarioDTO> get(){
        return ServicioUsuario.get();
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDTO save(@RequestBody Usuario Usuarioe){
        return ServicioUsuario.save(Usuarioe);
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDTO update(@RequestBody Usuario Usuarioe){
        return ServicioUsuario.update(Usuarioe);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id){
        ServicioUsuario.delete(id);
    }
}
