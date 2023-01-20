package work.appdeploys.veterinaria.mappers;

import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import work.appdeploys.veterinaria.models.Mascota;
import work.appdeploys.veterinaria.models.Usuario;
import work.appdeploys.veterinaria.models.dtos.MascotaDto;
import work.appdeploys.veterinaria.models.dtos.UsuarioDto;

@Mapper(componentModel = "spring")
public interface MascotaMapper {

    Mascota toModel(MascotaDto mascotaDto);
    MascotaDto toDto(Mascota mascota);
    @BeforeMapping
    default void trimModels(Mascota mascota, @MappingTarget MascotaDto mascotaDto){
        mascota.setNombre(mascota.getNombre().trim());
        mascota.setRaza(mascota.getRaza().trim());
        Usuario usuario = mascota.getUsuario();
        usuario.setTipoDocumento(usuario.getTipoDocumento().trim());
        usuario.setApellido(usuario.getApellido().trim());
        usuario.setNombre(usuario.getNombre().trim());
        usuario.setEstado(usuario.getEstado().trim());
        mascota.setUsuario(usuario);
    }

}
