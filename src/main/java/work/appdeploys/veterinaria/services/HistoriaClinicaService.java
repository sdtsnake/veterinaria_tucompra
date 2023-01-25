package work.appdeploys.veterinaria.services;

import work.appdeploys.veterinaria.models.dtos.HistoriaClinicaDto;
import work.appdeploys.veterinaria.models.dtos.HistoriaClinicaPostDto;

import java.util.List;

public interface HistoriaClinicaService extends CRUDService<HistoriaClinicaDto>{
    @Override
    void delete(Long id);
    @Override
    List<HistoriaClinicaDto> findAll();
    @Override
    HistoriaClinicaDto findById(Long id);
    HistoriaClinicaDto save(HistoriaClinicaPostDto historiaClinicaPostDto);
    HistoriaClinicaDto update(HistoriaClinicaDto historiaClinicaDto);
}
