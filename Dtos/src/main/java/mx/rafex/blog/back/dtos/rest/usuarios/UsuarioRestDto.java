package mx.rafex.blog.back.dtos.rest.usuarios;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import mx.rafex.blog.back.dtos.base.JsonDto;

@Data
@NoArgsConstructor
public class UsuarioRestDto implements Serializable {

    private static final long serialVersionUID = 605689904521722810L;

    private String alias;
    private String correo;
    private String contrasenya;

    public String aJson() {
        return JsonDto.aJson(this);
    }

}
