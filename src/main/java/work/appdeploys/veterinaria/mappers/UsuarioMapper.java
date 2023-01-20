package work.appdeploys.veterinaria.mappers;

import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import work.appdeploys.veterinaria.models.Usuario;
import work.appdeploys.veterinaria.models.dtos.UsuarioDto;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario toModel(UsuarioDto usuarioDto);
    UsuarioDto toDto(Usuario usuario);
    @BeforeMapping
    default void tirmModles(Usuario usuario, @MappingTarget UsuarioDto usuarioDto){
        usuario.setApellido(usuario.getApellido().trim());
        usuario.setNombre(usuario.getNombre().trim());
        usuario.setEstado(usuario.getEstado().trim());
        usuario.setTipoDocumento(usuario.getTipoDocumento().trim());
    }
}
