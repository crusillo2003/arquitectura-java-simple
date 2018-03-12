package mx.rafex.blog.back.servicios.usuarios;

import mx.rafex.blog.back.dtos.servicios.usuarios.UsuarioServicioDto;

public interface IUsuarioServicio {

    Boolean autenticar(UsuarioServicioDto usuario);

}
