package work.appdeploys.veterinaria.services;

import work.appdeploys.veterinaria.models.dtos.MascotaDto;
import work.appdeploys.veterinaria.models.dtos.UsuarioDto;

import java.util.List;

public interface MascotaService {

    MascotaDto save(MascotaDto mascotaDto);
    void delete(Long id);
    MascotaDto update(MascotaDto mascotaDto);
    List<MascotaDto> findAll();
    MascotaDto findById(Long id);
}
