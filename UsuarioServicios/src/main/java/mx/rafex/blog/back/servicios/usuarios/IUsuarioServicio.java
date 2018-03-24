package mx.rafex.blog.back.servicios.usuarios;

import java.util.List;

import mx.rafex.blog.back.dtos.servicios.usuarios.UsuarioServicioDto;

public interface IUsuarioServicio {

    Boolean autenticar(UsuarioServicioDto usuario);

    Boolean actualizar(UsuarioServicioDto usuario);

    List<UsuarioServicioDto> todosLosUsuarios();

    void limpiarCache();

}
