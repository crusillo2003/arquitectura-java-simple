package mx.rafex.blog.back.daos.sql.mappers;

import static mx.rafex.blog.back.daos.sql.mappers.UsuarioConsultas.OBTENER_TODOS_LOS_USUARIOS;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import mx.rafex.blog.back.dtos.daos.sql.usuarios.UsuarioSqlDto;

@Mapper
public interface UsuarioSqlMapper {

    @Select(OBTENER_TODOS_LOS_USUARIOS)
    public List<UsuarioSqlDto> obtenerTodos();
}
