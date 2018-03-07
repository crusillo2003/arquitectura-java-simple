package mx.rafex.blog.back.daos.usuarios;

import java.util.List;

import mx.rafex.blog.back.dtos.daos.usuarios.UsuarioDaoDto;

public interface IUsuarioDao {

    public List<UsuarioDaoDto> obtenerTodos();

    public Boolean crear(UsuarioDaoDto usuario);
}
