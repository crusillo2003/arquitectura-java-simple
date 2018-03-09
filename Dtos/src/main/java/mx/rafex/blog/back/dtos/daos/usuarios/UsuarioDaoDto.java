package mx.rafex.blog.back.dtos.daos.usuarios;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.GsonBuilder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDaoDto implements Serializable {

    private static final long serialVersionUID = -6638350426618012372L;

    private Integer identificador;
    private String alias;
    private String correo;
    private String contrasenya;
    private Date registro;
    private Date acceso;
    private Date modificacion;

    public String toJson() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }

}
