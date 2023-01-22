package work.appdeploys.veterinaria.mappers;

import org.mapstruct.Mapper;
import work.appdeploys.veterinaria.models.DetalleHistoriaClinica;
import work.appdeploys.veterinaria.models.dtos.DetalleHistoriaClinicaDto;

@Mapper(componentModel = "spring")
public interface DetalleHistoriaClinicaMapper {
    DetalleHistoriaClinica toModel(DetalleHistoriaClinicaDto detalleHistoriaClinicaDto);
    DetalleHistoriaClinicaDto toDto(DetalleHistoriaClinica detalleHistoriaClinica);
}
