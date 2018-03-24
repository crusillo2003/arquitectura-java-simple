package mx.rafex.blog.back.servicios.usuarios.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.rafex.blog.back.daos.usuarios.IUsuarioDao;
import mx.rafex.blog.back.dtos.daos.usuarios.UsuarioDaoDto;
import mx.rafex.blog.back.dtos.servicios.usuarios.UsuarioServicioDto;
import mx.rafex.blog.back.servicios.usuarios.IUsuarioServicio;
import mx.rafex.blog.back.utilidades.mapeos.usuarios.UsuarioDtoMaper;

@Service("usuarioServicio")
public class UsuarioServicio implements IUsuarioServicio {

    private static final Logger LOG = LogManager.getLogger(UsuarioServicio.class);

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    public Boolean autenticar(final UsuarioServicioDto usuario) {
        LOG.debug("autenticar: " + usuario);
        UsuarioDaoDto usuarioDaoDto = UsuarioDtoMaper.INSTANCE.usuarioServicioDtoAUsuarioDaoDto(usuario);
        usuarioDaoDto = usuarioDao.obtenerUnUsuario(usuarioDaoDto);
        LOG.debug("Resultado Dao: " + usuarioDaoDto);

        if ((usuarioDaoDto != null) && (usuarioDaoDto.getIdentificador() != null)
                && (usuarioDaoDto.getIdentificador() > 0)) {

            final UsuarioDaoDto usuarioDaoDtoTmp = new UsuarioDaoDto();
            usuarioDaoDtoTmp.setIdentificador(usuarioDaoDto.getIdentificador());
            usuarioDaoDtoTmp.setAcceso(new Date());
            final Boolean actualizar = usuarioDao.actualizar(usuarioDaoDtoTmp);

            if (!actualizar) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Error al actualizar la fecha de acceso");
                }
            }

            return true;
        }

        return false;
    }

    @Override
    public List<UsuarioServicioDto> todosLosUsuarios() {
        final List<UsuarioDaoDto> obtenerTodos = usuarioDao.obtenerTodos();

        if (CollectionUtils.isNotEmpty(obtenerTodos)) {
            return UsuarioDtoMaper.INSTANCE.convertirListaUsuarioDaoDtoAUsuarioServicioDto(obtenerTodos);
        }

        return null;
    }

    @Override
    public Boolean actualizar(final UsuarioServicioDto usuario) {
        final UsuarioDaoDto usuarioDaoDto = UsuarioDtoMaper.INSTANCE.usuarioServicioDtoAUsuarioDaoDto(usuario);
        usuarioDaoDto.setModificacion(new Date());
        return usuarioDao.actualizar(usuarioDaoDto);
    }

    @Override
    public void limpiarCache() {
        usuarioDao.limpiarCache();
    }

}
