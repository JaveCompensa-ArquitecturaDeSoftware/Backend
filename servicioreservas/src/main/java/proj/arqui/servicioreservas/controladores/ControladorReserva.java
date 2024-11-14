package proj.arqui.servicioreservas.controladores;

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

import proj.arqui.servicioreservas.dtos.ReservaDTO;
import proj.arqui.servicioreservas.servicios.ServicioUsuario;



@RestController
@RequestMapping(value = "/Reservas")
public class ControladorReserva {
    private final ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorReserva(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<ReservaDTO> obtenerReservaPorId(@PathVariable Long id) {
        return servicioUsuario.obtenerReservaPorId(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservaDTO> obtenerTodasReservas() {
        return (List<ReservaDTO>) servicioUsuario.obtenerTodasReservas();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ReservaDTO guardarReserva(@RequestBody ReservaDTO reservaDto) {
        return servicioUsuario.guardarReserva(reservaDto);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReservaDTO actualizarReserva(@PathVariable Long id, @RequestBody ReservaDTO reservaDto) {
        return servicioUsuario.actualizarReserva(id, reservaDto);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarReserva(@PathVariable Long id) {
        servicioUsuario.eliminarReserva(id);
    }
}
