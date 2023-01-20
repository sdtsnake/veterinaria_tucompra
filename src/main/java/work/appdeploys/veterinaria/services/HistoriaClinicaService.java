package work.appdeploys.veterinaria.services;

import work.appdeploys.veterinaria.models.dtos.HistoriaClinicaDto;

import java.util.List;

public interface HistoriaClinicaService extends CRUDService<HistoriaClinicaDto>{
    @Override
    HistoriaClinicaDto save(HistoriaClinicaDto historiaClinicaDto);

    @Override
    void delete(Long id);

    @Override
    HistoriaClinicaDto update(HistoriaClinicaDto historiaClinicaDto);

    @Override
    List<HistoriaClinicaDto> findAll();

    @Override
    HistoriaClinicaDto findById(Long id);
}
