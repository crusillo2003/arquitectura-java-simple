package mx.rafex.blog.back.dtos.servicios.usuarios;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import mx.rafex.blog.back.dtos.base.JsonDto;

@Data
@NoArgsConstructor
public class UsuarioServicioDto implements Serializable {

    private static final long serialVersionUID = 605689904521722810L;

    private String alias;
    private String correo;
    private String contrasenya;
    private Date registro;
    private Date acceso;
    private Date modificacion;

    public String aJson() {
        return JsonDto.aJson(this);
    }

}
