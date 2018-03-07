package mx.rafex.blog.back.daos.usuarios.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.rafex.blog.back.daos.sql.mappers.UsuarioSqlMapper;
import mx.rafex.blog.back.daos.usuarios.IUsuarioDao;
import mx.rafex.blog.back.dtos.daos.sql.usuarios.UsuarioSqlDto;
import mx.rafex.blog.back.dtos.daos.usuarios.UsuarioDaoDto;
import mx.rafex.blog.back.utilidades.mapeos.usuarios.UsuariosDtoMaper;

@Repository("usuarioDao")
public class UsuarioDao implements IUsuarioDao {

    private static final Logger LOG = Logger.getLogger(UsuarioDao.class);

    @Autowired
    private UsuarioSqlMapper usuarioSql;

    public List<UsuarioDaoDto> obtenerTodos() {
        final List<UsuarioSqlDto> listaUsuarios = usuarioSql.obtenerTodos();
        return UsuariosDtoMaper.INSTANCE.convertirListaUsuarioSqlDto(listaUsuarios);
    }

}
