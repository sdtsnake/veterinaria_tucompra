package work.appdeploys.veterinaria.services;

import work.appdeploys.veterinaria.models.dtos.DetalleHistoriaClinicaDto;
import work.appdeploys.veterinaria.models.dtos.DetalleHistoriaClinicaPostDto;

import java.util.List;

public interface DetalleHistoriaClinicaService extends CRUDService<DetalleHistoriaClinicaDto>{
    @Override
    void delete(Long id);
    @Override
    DetalleHistoriaClinicaDto update(DetalleHistoriaClinicaDto detalleHistoriaClinicaDto);
    @Override
    List<DetalleHistoriaClinicaDto> findAll();
    @Override
    DetalleHistoriaClinicaDto findById(Long id);
    List<DetalleHistoriaClinicaDto> findAllByHistoriaId(Long idHistoriClinica);
    DetalleHistoriaClinicaDto save(DetalleHistoriaClinicaPostDto detalleHistoriaClinicaPostDto);
}
