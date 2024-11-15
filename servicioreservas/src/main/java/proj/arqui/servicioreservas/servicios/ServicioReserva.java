package proj.arqui.servicioreservas.servicios;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.arqui.servicioreservas.dto.ReservaDTO;
import proj.arqui.servicioreservas.entidades.Reserva;
import proj.arqui.servicioreservas.repositorios.RepositorioReserva;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ServicioReserva {

    @Autowired
    private RepositorioReserva repositorioReserva;

    @Autowired
    private ModelMapper modelMapper;

    public Iterable<ReservaDTO> obtenerTodasReservas() {
        Iterable<Reserva> reservas = repositorioReserva.findAll();
        return StreamSupport.stream(reservas.spliterator(), false)
                            .map(reserva -> convertToDto(reserva))
                            .collect(Collectors.toList());
    }
    
    public Optional<ReservaDTO> obtenerReservaPorId(Long id) {
        Optional<Reserva> reserva = repositorioReserva.findById(id);
        return reserva.map(res -> convertToDto(res));
    }
    
    public ReservaDTO guardarReserva(ReservaDTO reservaDto) {
        Reserva reserva = convertToEntity(reservaDto);
        
        if (!isReservationValid(reserva)) {
            throw new IllegalArgumentException("Reserva tiene conflicto de horario con otra reserva existente");
        }
        
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
//AQUI PONEMOS KAFKA
    private boolean isReservationValid(Reserva reserva) {
        List<Reserva> existingReservas = StreamSupport.stream(repositorioReserva.findAll().spliterator(), false)
                                                      .filter(r -> !r.getId_reserva().equals(reserva.getId_reserva()))
                                                      .collect(Collectors.toList());

        for (Reserva existingReserva : existingReservas) {
            if (hasTimeConflict(existingReserva, reserva)) {
                return false; 
            }
        }

        return true;
    }

    private boolean hasTimeConflict(Reserva existingReserva, Reserva newReserva) {
        Timestamp existingStart = existingReserva.getFechaCreacion();
        Timestamp existingEnd = new Timestamp(existingStart.getTime() + (long) (existingReserva.getDuracionReserva() * 3600000));

        Timestamp newStart = newReserva.getFechaCreacion();
        Timestamp newEnd = new Timestamp(newStart.getTime() + (long) (newReserva.getDuracionReserva() * 3600000));

        return newStart.before(existingEnd) && newEnd.after(existingStart);
    }
}
