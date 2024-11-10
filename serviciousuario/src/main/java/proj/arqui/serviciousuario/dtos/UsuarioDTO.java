package proj.arqui.serviciousuario.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long id_usuario;
    private String nombre;
    private Integer edad;
    private String correo;
    private Boolean elimnado;
}
