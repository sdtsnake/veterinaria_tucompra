package work.appdeploys.veterinaria.services;

import work.appdeploys.veterinaria.models.dtos.ColaboradorDto;

import java.util.List;

public interface ColaboradorServicio extends CRUDService<ColaboradorDto> {
    @Override
    void delete(Long id);
    @Override
    List<ColaboradorDto> findAll();
    @Override
    ColaboradorDto findById(Long id);
    ColaboradorDto findByDocumentoId(Integer idDocumento);
    ColaboradorDto save(ColaboradorDto colaboradorDto);
    ColaboradorDto update(ColaboradorDto colaboradorDto);
}
