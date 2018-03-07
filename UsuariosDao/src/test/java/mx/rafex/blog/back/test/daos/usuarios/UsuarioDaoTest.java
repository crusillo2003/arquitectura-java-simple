package mx.rafex.blog.back.test.daos.usuarios;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.rafex.blog.back.daos.usuarios.IUsuarioDao;
import mx.rafex.blog.back.dtos.daos.usuarios.UsuarioDaoDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class UsuarioDaoTest extends AbstractJUnit4SpringContextTests {

    @Test
    public void validarQueElBeanNoSeaNulo() {
        final IUsuarioDao bean = (IUsuarioDao) applicationContext.getBean("usuarioDao");
        Assert.assertNotNull(bean);
    }

    @Test
    public void obtenerTodosLosUsuarios() {
        final IUsuarioDao bean = (IUsuarioDao) applicationContext.getBean("usuarioDao");

        final List<UsuarioDaoDto> listaUsuarios = bean.obtenerTodos();

        Assert.assertNotNull(listaUsuarios);
        Assert.assertFalse("Hubo un error al traer los usuarios", listaUsuarios.isEmpty());
        for (final UsuarioDaoDto usuario : listaUsuarios) {
            System.out.print(usuario);
        }
    }

}
