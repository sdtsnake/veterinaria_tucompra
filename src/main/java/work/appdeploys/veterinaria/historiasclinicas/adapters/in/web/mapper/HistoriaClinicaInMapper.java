package work.appdeploys.veterinaria.historiasclinicas.adapters.in.web.mapper;

import org.mapstruct.Mapper;
import work.appdeploys.veterinaria.historiasclinicas.adapters.in.web.Dto.HistoriaClinicaInDto;
import work.appdeploys.veterinaria.historiasclinicas.adapters.in.web.Dto.HistoriaClinicaPostInDto;
import work.appdeploys.veterinaria.historiasclinicas.application.port.in.HistoriaClinicaCommand;
import work.appdeploys.veterinaria.historiasclinicas.domain.HistoriaClinica;


@Mapper(componentModel = "spring")
public interface HistoriaClinicaInMapper {

    HistoriaClinicaCommand toEntity(HistoriaClinicaPostInDto historiaClinicaPostInDto);
    HistoriaClinica toModelDomain(HistoriaClinicaInDto historiaClinicaInDto);
    HistoriaClinicaInDto toDto(HistoriaClinica historiaClinica);
}
