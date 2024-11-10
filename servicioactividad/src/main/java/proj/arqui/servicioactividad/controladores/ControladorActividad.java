package proj.arqui.servicioactividad.controladores;

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

import proj.arqui.servicioactividad.entidades.Actividad;
import proj.arqui.servicioactividad.servicio.ServicioActividad;

@RestController
@RequestMapping("/Actividad")
public class ControladorActividad {
    private ServicioActividad ServicioActividad;

    @Autowired
    ControladorActividad(ServicioActividad servicoActividad){
        this.ServicioActividad = servicoActividad;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Actividad get(@PathVariable Long id){
        return ServicioActividad.getActividad(id);
    }
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Actividad save(@RequestBody Actividad Actividade){
        return ServicioActividad.save(Actividade);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Actividad update(@RequestBody Actividad Actividade){
        return ServicioActividad.update(Actividade);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id){
        ServicioActividad.delete(id);
    }
}
