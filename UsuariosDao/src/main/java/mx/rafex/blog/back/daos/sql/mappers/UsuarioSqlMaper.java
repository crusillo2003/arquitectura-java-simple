package mx.rafex.blog.back.daos.sql.mappers;

import static mx.rafex.blog.back.daos.sql.mappers.UsuarioConsultas.INSERT_USUARIO;
import static mx.rafex.blog.back.daos.sql.mappers.UsuarioConsultas.SELECT_USUARIOS;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import mx.rafex.blog.back.dtos.daos.sql.usuarios.UsuarioSqlDto;

@Mapper
public interface UsuarioSqlMaper {

    @Select(SELECT_USUARIOS)
    public List<UsuarioSqlDto> select();

    @Options(useGeneratedKeys = true, keyProperty = "FI_USUARIO")
    @Insert(INSERT_USUARIO)
    public Long insert(UsuarioSqlDto usuario);
}
