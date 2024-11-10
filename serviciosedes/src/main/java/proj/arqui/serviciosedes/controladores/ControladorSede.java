package proj.arqui.serviciosedes.controladores;

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

import proj.arqui.serviciosedes.entidades.Sede;
import proj.arqui.serviciosedes.servicios.ServicioSede;

@RestController
@RequestMapping("/Sede")
public class ControladorSede {
    private ServicioSede servicioSede;

    @Autowired
    ControladorSede(ServicioSede servicosede){
        this.servicioSede = servicosede;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Sede get(@PathVariable Long id){
        return servicioSede.getSede(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Sede save(@RequestBody Sede sedee){
        return servicioSede.save(sedee);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Sede update(@RequestBody Sede sedee){
        return servicioSede.update(sedee);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id){
        servicioSede.delete(id);
    }
}
