package mx.rafex.blog.back.test.utilidades.mapeos.usuarios;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import mx.rafex.blog.back.dtos.daos.sql.usuarios.UsuarioSqlDto;
import mx.rafex.blog.back.dtos.daos.usuarios.UsuarioDaoDto;
import mx.rafex.blog.back.utilidades.mapeos.usuarios.UsuarioDtoMaper;

public class UsuarioDtoMaperTest {

    @Test
    public void UsuarioSqlDtoAUsuarioDaoDto() {
        final UsuarioSqlDto origen = new UsuarioSqlDto();
        origen.setId(1);
        origen.setAlias("rafexTest");
        origen.setCorreo("rafexTest@gmail.com");
        origen.setContrasenya("123333");
        origen.setRegistro(new Date());
        origen.setModificacion(new Date());
        origen.setAcceso(new Date());

        final UsuarioDaoDto destino = UsuarioDtoMaper.INSTANCE.convertir(origen);

        Assert.assertEquals(origen.getId(), destino.getIdentificador());
        Assert.assertEquals(origen.getAlias(), destino.getAlias());
        Assert.assertEquals(origen.getCorreo(), destino.getCorreo());
        Assert.assertEquals(origen.getContrasenya(), destino.getContrasenya());
        Assert.assertEquals(origen.getRegistro(), destino.getRegistro());
        Assert.assertEquals(origen.getModificacion(), destino.getModificacion());
        Assert.assertEquals(origen.getAcceso(), destino.getAcceso());

    }

    @Test
    public void UsuarioDaoDtoAUsuarioSqlDto() {
        final UsuarioDaoDto origen = new UsuarioDaoDto();
        origen.setIdentificador(1);
        origen.setAlias("rafexTest");
        origen.setCorreo("rafexTest@gmail.com");
        origen.setContrasenya("123333");
        origen.setRegistro(new Date());
        origen.setModificacion(new Date());
        origen.setAcceso(new Date());

        final UsuarioSqlDto destino = UsuarioDtoMaper.INSTANCE.convertir(origen);

        Assert.assertEquals(origen.getIdentificador(), destino.getId());
        Assert.assertEquals(origen.getAlias(), destino.getAlias());
        Assert.assertEquals(origen.getCorreo(), destino.getCorreo());
        Assert.assertEquals(origen.getContrasenya(), destino.getContrasenya());
        Assert.assertEquals(origen.getRegistro(), destino.getRegistro());
        Assert.assertEquals(origen.getModificacion(), destino.getModificacion());
        Assert.assertEquals(origen.getAcceso(), destino.getAcceso());

    }

}
