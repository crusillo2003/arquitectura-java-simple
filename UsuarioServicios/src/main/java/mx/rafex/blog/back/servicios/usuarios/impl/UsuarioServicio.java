package mx.rafex.blog.back.servicios.usuarios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.rafex.blog.back.daos.usuarios.IUsuarioDao;
import mx.rafex.blog.back.servicios.usuarios.IUsuarioServicio;

@Service("usuarioServicio")
public class UsuarioServicio implements IUsuarioServicio {

    @Autowired
    private IUsuarioDao usuarioDao;

}
