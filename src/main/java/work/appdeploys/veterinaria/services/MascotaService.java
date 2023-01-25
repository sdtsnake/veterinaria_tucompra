package work.appdeploys.veterinaria.services;

import work.appdeploys.veterinaria.models.dtos.MascotaDto;

import java.util.List;

public interface MascotaService extends CRUDService<MascotaDto>{
    @Override
    void delete(Long id);
    @Override
    List<MascotaDto> findAll();
    @Override
    MascotaDto findById(Long id);
    List<MascotaDto> findAllSinHistoria();
    MascotaDto save(MascotaDto mascotaDto);
    MascotaDto update(MascotaDto mascotaDto);
}
