package mx.rafex.blog.back.servicios.usuarios.impl;

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
        UsuarioDaoDto usuarioDaoDto = UsuarioDtoMaper.INSTANCE.usuarioServicioDtoAUsuarioDaoDto(usuario);
        usuarioDaoDto = usuarioDao.obtenerUnUsuario(usuarioDaoDto);
        return (usuarioDaoDto != null) && (usuarioDaoDto.getIdentificador() != null) ? true : false;
    }

}
