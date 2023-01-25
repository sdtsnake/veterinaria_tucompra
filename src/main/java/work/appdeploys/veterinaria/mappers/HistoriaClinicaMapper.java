package work.appdeploys.veterinaria.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import work.appdeploys.veterinaria.models.HistoriaClinica;
import work.appdeploys.veterinaria.models.dtos.HistoriaClinicaDto;
import work.appdeploys.veterinaria.models.dtos.HistoriaClinicaPostDto;

@Mapper(componentModel = "spring")
public interface HistoriaClinicaMapper {

    HistoriaClinica toModel(HistoriaClinicaDto historiaClinicaDto);
    HistoriaClinicaDto toDto(HistoriaClinica historiaClinica);
}
