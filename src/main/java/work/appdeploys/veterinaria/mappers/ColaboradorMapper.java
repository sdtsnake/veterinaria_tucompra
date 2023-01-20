package work.appdeploys.veterinaria.mappers;

import org.mapstruct.Mapper;
import work.appdeploys.veterinaria.models.Colaborador;
import work.appdeploys.veterinaria.models.dtos.ColaboradorDto;

@Mapper(componentModel = "spring")
public interface ColaboradorMapper {
    Colaborador toModel(ColaboradorDto colaboradorDto);
    ColaboradorDto toDto(Colaborador colaborador);
}
