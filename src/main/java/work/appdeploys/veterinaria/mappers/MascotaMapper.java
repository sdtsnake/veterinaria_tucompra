package work.appdeploys.veterinaria.mappers;

import org.mapstruct.Mapper;
import work.appdeploys.veterinaria.models.Mascota;
import work.appdeploys.veterinaria.models.dtos.MascotaDto;
import work.appdeploys.veterinaria.models.dtos.UsuarioDto;

@Mapper(componentModel = "spring")
public interface MascotaMapper {

    Mascota toModel(MascotaDto mascotaDto);
    UsuarioDto toDto(Mascota mascota);
}
