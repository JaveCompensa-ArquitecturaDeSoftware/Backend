package proj.arqui.servicioadmin.controladores;

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

import proj.arqui.servicioadmin.dtos.AdminDTO;
import proj.arqui.servicioadmin.entidades.Admin;
import proj.arqui.servicioadmin.servicios.ServicioAdmin;;

@RestController
@RequestMapping(value = "/Admin")
public class ControladorAdmin {
    ServicioAdmin ServicioAdmin;

    @Autowired
    ControladorAdmin(ServicioAdmin ServicioAdmin){
        this.ServicioAdmin = ServicioAdmin;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminDTO get(@PathVariable Long id){
        return ServicioAdmin.get(id);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AdminDTO> get(){
        return ServicioAdmin.get();
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminDTO save(@RequestBody Admin Admine){
        return ServicioAdmin.save(Admine);
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminDTO update(@RequestBody Admin Admine){
        return ServicioAdmin.update(Admine);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id){
        ServicioAdmin.delete(id);
    }
}
