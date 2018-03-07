package mx.rafex.blog.back.daos.usuarios.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.rafex.blog.back.daos.sql.mappers.UsuarioSqlMaper;
import mx.rafex.blog.back.daos.usuarios.IUsuarioDao;
import mx.rafex.blog.back.dtos.daos.sql.usuarios.UsuarioSqlDto;
import mx.rafex.blog.back.dtos.daos.usuarios.UsuarioDaoDto;
import mx.rafex.blog.back.utilidades.mapeos.usuarios.UsuarioDtoMaper;

@Repository("usuarioDao")
public class UsuarioDao implements IUsuarioDao {

    private static final Logger LOG = Logger.getLogger(UsuarioDao.class);

    @Autowired
    private UsuarioSqlMaper usuarioSql;

    public List<UsuarioDaoDto> obtenerTodos() {
        final List<UsuarioSqlDto> listaUsuarios = usuarioSql.select();
        return UsuarioDtoMaper.INSTANCE.convertirListaUsuarioSqlDto(listaUsuarios);
    }

    public Boolean crear(final UsuarioDaoDto usuario) {
        final UsuarioSqlDto usuarioSqlDto = UsuarioDtoMaper.INSTANCE.convertir(usuario);
        final Long identificador = usuarioSql.insert(usuarioSqlDto);
        return identificador != null ? true : false;
    }

}
