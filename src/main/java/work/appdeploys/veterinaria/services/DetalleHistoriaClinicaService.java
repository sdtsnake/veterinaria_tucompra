package work.appdeploys.veterinaria.services;

import work.appdeploys.veterinaria.models.dtos.DetalleHistoriaClinicaDto;
import work.appdeploys.veterinaria.models.dtos.DetalleHistoriaClinicaPostDto;
import work.appdeploys.veterinaria.models.dtos.DetalleHistoriaClinicaPutDto;

import java.util.List;

public interface DetalleHistoriaClinicaService extends CRUDService<DetalleHistoriaClinicaDto>{
    @Override
    void delete(Long id);
    @Override
    List<DetalleHistoriaClinicaDto> findAll();
    @Override
    DetalleHistoriaClinicaDto findById(Long id);
    List<DetalleHistoriaClinicaDto> findAllByHistoriaId(Long idHistoriClinica);
    DetalleHistoriaClinicaDto save(DetalleHistoriaClinicaPostDto detalleHistoriaClinicaPostDto);
    DetalleHistoriaClinicaDto update(DetalleHistoriaClinicaPutDto detalleHistoriaClinicaPutDto);
}
