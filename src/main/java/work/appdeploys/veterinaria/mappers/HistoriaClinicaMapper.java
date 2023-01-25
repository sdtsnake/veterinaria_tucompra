package work.appdeploys.veterinaria.mappers;

import org.mapstruct.Mapper;
import work.appdeploys.veterinaria.models.HistoriaClinica;
import work.appdeploys.veterinaria.models.dtos.HistoriaClinicaDto;

@Mapper(componentModel = "spring")
public interface HistoriaClinicaMapper {

    HistoriaClinica toModel(HistoriaClinicaDto historiaClinicaDto);
    HistoriaClinicaDto toDto(HistoriaClinica historiaClinica);
}
