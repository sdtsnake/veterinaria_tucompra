package work.appdeploys.veterinaria.services;

import work.appdeploys.veterinaria.models.dtos.MascotaDto;

import java.util.List;

public interface MascotaService extends CRUDService<MascotaDto>{

    MascotaDto save(MascotaDto mascotaDto);
    void delete(Long id);
    MascotaDto update(MascotaDto mascotaDto);
    List<MascotaDto> findAll();
    List<MascotaDto> findAllSinHistoria();
    MascotaDto findById(Long id);
}
