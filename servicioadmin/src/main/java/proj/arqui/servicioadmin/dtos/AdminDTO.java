package proj.arqui.servicioadmin.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    private Long id_usuario;
    private String nombre;
    private Integer edad;
    private String correo;
    private Boolean elimnado;
}
