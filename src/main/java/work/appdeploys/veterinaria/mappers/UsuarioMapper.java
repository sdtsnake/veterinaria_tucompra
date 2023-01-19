package work.appdeploys.veterinaria.mappers;

import org.mapstruct.Mapper;
import work.appdeploys.veterinaria.models.Usuario;
import work.appdeploys.veterinaria.models.dtos.UsuarioDto;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toModel(UsuarioDto usuarioDto);
    UsuarioDto toDto(Usuario usuario);

}
