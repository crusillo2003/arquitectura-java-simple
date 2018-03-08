package mx.rafex.blog.back.daos.usuarios.impl;

import java.util.List;

import org.apache.commons.lang3.BooleanUtils;
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
    private UsuarioSqlMaper usuarioSqlMaper;

    public List<UsuarioDaoDto> obtenerTodos() {
        final List<UsuarioSqlDto> listaUsuarios = usuarioSqlMaper.select();
        return UsuarioDtoMaper.INSTANCE.convertirListaUsuarioSqlDto(listaUsuarios);
    }

    public UsuarioDaoDto crear(final UsuarioDaoDto usuario) {
        final UsuarioSqlDto usuarioSqlDto = UsuarioDtoMaper.INSTANCE.convertir(usuario);
        final Integer resultado = usuarioSqlMaper.insert(usuarioSqlDto);

        if ((resultado != null) && BooleanUtils.toBoolean(resultado)) {
            return UsuarioDtoMaper.INSTANCE.convertir(usuarioSqlDto);
        }

        return null;
    }

    public Boolean actualizar(final UsuarioDaoDto usuario) {
        final UsuarioSqlDto usuarioSqlDto = UsuarioDtoMaper.INSTANCE.convertir(usuario);
        final Integer resultado = usuarioSqlMaper.update(usuarioSqlDto);
        return (resultado != null) && (resultado > 0) ? true : false;
    }

    public Boolean eliminar(final UsuarioDaoDto usuario) {
        final UsuarioSqlDto usuarioSqlDto = UsuarioDtoMaper.INSTANCE.convertir(usuario);
        final Integer resultado = usuarioSqlMaper.delete(usuarioSqlDto);
        return (resultado != null) && (resultado > 0) ? true : false;
    }

}
