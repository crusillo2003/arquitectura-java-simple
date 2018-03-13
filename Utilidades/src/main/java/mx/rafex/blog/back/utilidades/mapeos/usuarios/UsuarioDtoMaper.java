package mx.rafex.blog.back.utilidades.mapeos.usuarios;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import mx.rafex.blog.back.dtos.daos.sql.usuarios.UsuarioSqlDto;
import mx.rafex.blog.back.dtos.daos.usuarios.UsuarioDaoDto;
import mx.rafex.blog.back.dtos.rest.usuarios.UsuarioRestDto;
import mx.rafex.blog.back.dtos.servicios.usuarios.UsuarioServicioDto;

@Mapper
public interface UsuarioDtoMaper {

    UsuarioDtoMaper INSTANCE = Mappers.getMapper(UsuarioDtoMaper.class);

    @Mappings({ @Mapping(source = "id", target = "identificador") })
    UsuarioDaoDto usuarioSqlDtoAUsuarioSqlDto(UsuarioSqlDto usuario);

    @InheritInverseConfiguration
    UsuarioSqlDto usuarioDaoDtoAUsuarioSqlDto(UsuarioDaoDto usuario);

    UsuarioServicioDto usuarioDaoDtoAUsuarioServicioDto(UsuarioDaoDto usuario);

    UsuarioDaoDto usuarioServicioDtoAUsuarioDaoDto(UsuarioServicioDto usuario);

    @Mapping(target = "contrasenya", ignore = true)
    UsuarioRestDto usuarioServicioDtoAUsuarioRestDto(UsuarioServicioDto usuario);

    UsuarioServicioDto usuarioRestDtoAUsuarioServicioDto(UsuarioRestDto usuario);

    List<UsuarioRestDto> convertirListaUsuarioServicioDtoAUsuarioRestDto(List<UsuarioServicioDto> usuario);

    List<UsuarioDaoDto> convertirListaUsuarioSqlDtoAUsuarioDaoDto(List<UsuarioSqlDto> usuario);

    List<UsuarioSqlDto> convertirListaUsuarioDaoDtoAUsuarioSqlDto(List<UsuarioDaoDto> usuario);

    List<UsuarioServicioDto> convertirListaUsuarioDaoDtoAUsuarioServicioDto(List<UsuarioDaoDto> usuario);

}
