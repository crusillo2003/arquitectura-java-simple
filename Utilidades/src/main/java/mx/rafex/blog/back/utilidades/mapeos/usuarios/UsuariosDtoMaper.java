package mx.rafex.blog.back.utilidades.mapeos.usuarios;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import mx.rafex.blog.back.dtos.daos.sql.usuarios.UsuarioSqlDto;
import mx.rafex.blog.back.dtos.daos.usuarios.UsuarioDaoDto;

@Mapper
public interface UsuariosDtoMaper {

    UsuariosDtoMaper INSTANCE = Mappers.getMapper(UsuariosDtoMaper.class);

    @Mappings({ @Mapping(source = "id", target = "identificador") })
    UsuarioDaoDto convertir(UsuarioSqlDto usuario);

    @InheritInverseConfiguration
    UsuarioSqlDto convertir(UsuarioDaoDto usuario);

    List<UsuarioDaoDto> convertirListaUsuarioSqlDto(List<UsuarioSqlDto> usuario);

    List<UsuarioSqlDto> convertirListaUsuarioDaoDto(List<UsuarioDaoDto> usuario);

}
