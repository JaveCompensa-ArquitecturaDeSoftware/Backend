package proj.arqui.servicioreservas.entidades;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reserva;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date fechaCreacion;
    private float duracionReserva;
    private String estado;
    private Integer cantidadPersonas;
    private float total;
    private String metodoPago;
}
