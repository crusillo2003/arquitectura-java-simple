package mx.rafex.blog.back.daos.sql.mapeos.usuarios;

import static mx.rafex.blog.back.daos.sql.mapeos.usuarios.UsuarioConsultas.SELECT_USUARIOS;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import mx.rafex.blog.back.dtos.daos.sql.usuarios.UsuarioSqlDto;

@Mapper
public interface UsuarioSqlMaper {

    @Select(SELECT_USUARIOS)
    public List<UsuarioSqlDto> select();

    public UsuarioSqlDto selectUnUsuario(UsuarioSqlDto usuario);

    public Integer insert(UsuarioSqlDto usuario);

    public Integer update(UsuarioSqlDto usuario);

    public Integer delete(UsuarioSqlDto usuario);
}
