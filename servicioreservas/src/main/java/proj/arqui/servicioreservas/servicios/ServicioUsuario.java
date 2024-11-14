package proj.arqui.servicioreservas.servicios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.arqui.servicioreservas.dtos.ReservaDTO;
import proj.arqui.servicioreservas.entidades.Reserva;
import proj.arqui.servicioreservas.repositorios.RepositorioReserva;


@Service
public class ServicioUsuario {
    

    @Autowired
    private RepositorioReserva repositorioReserva;

    @Autowired
    private ModelMapper modelMapper;

    public Iterable<ReservaDTO> obtenerTodasReservas() {
        Iterable<Reserva> reservas = repositorioReserva.findAll();
        return reservas.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public Optional<ReservaDTO> obtenerReservaPorId(Long id) {
        Optional<Reserva> reserva = repositorioReserva.findById(id);
        return reserva.map(this::convertToDto);
    }

    public ReservaDTO guardarReserva(ReservaDTO reservaDto) {
        Reserva reserva = convertToEntity(reservaDto);
        Reserva nuevaReserva = repositorioReserva.save(reserva);
        return convertToDto(nuevaReserva);
    }

    public ReservaDTO actualizarReserva(Long id, ReservaDTO reservaDto) {
        Optional<Reserva> reservaExistente = repositorioReserva.findById(id);
        if (reservaExistente.isPresent()) {
            Reserva reserva = reservaExistente.get();
            modelMapper.map(reservaDto, reserva);
            Reserva reservaActualizada = repositorioReserva.save(reserva);
            return convertToDto(reservaActualizada);
        }
        return null;
    }

    public void eliminarReserva(Long id) {
        repositorioReserva.deleteById(id);
    }

    private ReservaDTO convertToDto(Reserva reserva) {
        return modelMapper.map(reserva, ReservaDTO.class);
    }

    private Reserva convertToEntity(ReservaDTO reservaDto) {
        return modelMapper.map(reservaDto, Reserva.class);
    }
}
