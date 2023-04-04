package work.appdeploys.veterinaria.historiasclinicas.adapters.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import work.appdeploys.veterinaria.historiasclinicas.adapters.in.web.Dto.HistoriaClinicaInDto;
import work.appdeploys.veterinaria.historiasclinicas.adapters.out.persistence.entity.HistoriaClinicaEntity;
import work.appdeploys.veterinaria.historiasclinicas.application.port.in.HistoriaClinicaCommand;
import work.appdeploys.veterinaria.historiasclinicas.domain.HistoriaClinica;
import work.appdeploys.veterinaria.models.Mascota;

@Mapper(componentModel = "spring")
public interface HistoriaClinicaOutMapper {
    HistoriaClinica toDomainModel(HistoriaClinicaEntity historiaClinicaEntity);
    HistoriaClinicaInDto toDto(HistoriaClinica historiaClinica);
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "idMascota", target = "mascota", qualifiedByName = "idToMascota")
    HistoriaClinicaEntity toEntity(HistoriaClinicaCommand historiaClinicaCommand);

    @Named("idToMascota")
    default Mascota idToMascota(Long id) {
        Mascota mascota = new Mascota();
        mascota.setId(id);
        return mascota;
    }

    HistoriaClinicaEntity toEntity(HistoriaClinica historiaClinica);










}
