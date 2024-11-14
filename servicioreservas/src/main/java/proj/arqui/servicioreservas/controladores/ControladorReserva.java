package proj.arqui.servicioreservas.controladores;

import java.util.List;
import java.util.Optional;

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
import proj.arqui.servicioreservas.servicios.ServicioReserva;



@RestController
@RequestMapping(value = "/Reserva")
public class ControladorReserva {
    private final ServicioReserva ServicioReserva;

    @Autowired
    public ControladorReserva(ServicioReserva ServicioReserva) {
        this.ServicioReserva = ServicioReserva;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<ReservaDTO> obtenerReservaPorId(@PathVariable Long id) {
        return ServicioReserva.obtenerReservaPorId(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservaDTO> obtenerTodasReservas() {
        return (List<ReservaDTO>) ServicioReserva.obtenerTodasReservas();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ReservaDTO guardarReserva(@RequestBody ReservaDTO reservaDto) {
        return ServicioReserva.guardarReserva(reservaDto);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReservaDTO actualizarReserva(@PathVariable Long id, @RequestBody ReservaDTO reservaDto) {
        return ServicioReserva.actualizarReserva(id, reservaDto);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarReserva(@PathVariable Long id) {
        ServicioReserva.eliminarReserva(id);
    }
}
