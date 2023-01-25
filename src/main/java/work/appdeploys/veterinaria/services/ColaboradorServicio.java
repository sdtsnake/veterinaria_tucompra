package work.appdeploys.veterinaria.services;

import work.appdeploys.veterinaria.models.dtos.ColaboradorDto;

import java.util.List;

public interface ColaboradorServicio extends CRUDService<ColaboradorDto> {
    @Override
    void delete(Long id);
    @Override
    ColaboradorDto update(ColaboradorDto colaboradorDto);
    @Override
    List<ColaboradorDto> findAll();
    @Override
    ColaboradorDto findById(Long id);
    ColaboradorDto findByDocumentoId(Integer idDocumento);
    ColaboradorDto save(ColaboradorDto colaboradorDto);
}
