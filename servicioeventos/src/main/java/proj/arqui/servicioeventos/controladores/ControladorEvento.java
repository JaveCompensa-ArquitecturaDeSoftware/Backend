package proj.arqui.servicioeventos.controladores;

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

import proj.arqui.servicioeventos.entidades.Evento;
import proj.arqui.servicioeventos.servicios.ServicioEvento;

@RestController
@RequestMapping("/Evento")
public class ControladorEvento {
    private ServicioEvento ServicioEvento;

    @Autowired
    ControladorEvento(ServicioEvento servicoEvento){
        this.ServicioEvento = servicoEvento;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Evento get(@PathVariable Long id){
        return ServicioEvento.getEvento(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Evento save(@RequestBody Evento Eventoe){
        return ServicioEvento.save(Eventoe);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Evento update(@RequestBody Evento Eventoe){
        return ServicioEvento.update(Eventoe);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id){
        ServicioEvento.delete(id);
    }
}
