package mx.rafex.blog.back.daos.sql.mappers;

import static mx.rafex.blog.back.daos.sql.mappers.UsuarioConsultas.DELETE_USUARIO;
import static mx.rafex.blog.back.daos.sql.mappers.UsuarioConsultas.INSERT_USUARIO;
import static mx.rafex.blog.back.daos.sql.mappers.UsuarioConsultas.SELECT_USUARIOS;
import static mx.rafex.blog.back.daos.sql.mappers.UsuarioConsultas.UPDATE_USUARIO;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mx.rafex.blog.back.dtos.daos.sql.usuarios.UsuarioSqlDto;

@Mapper
public interface UsuarioSqlMaper {

    @Select(SELECT_USUARIOS)
    public List<UsuarioSqlDto> select();

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert(INSERT_USUARIO)
    public Integer insert(UsuarioSqlDto usuario);

    @Update(UPDATE_USUARIO)
    public Integer update(UsuarioSqlDto usuario);

    @Delete(DELETE_USUARIO)
    public Integer delete(UsuarioSqlDto usuario);
}
