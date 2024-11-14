package proj.arqui.servicioreservas.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {
    private Long idReserva;
    private Date fechaCreacion;
    private float duracionReserva;
    private String estado;
    private Integer cantidadPersonas;
    private float total;
    private String metodoPago;
}
