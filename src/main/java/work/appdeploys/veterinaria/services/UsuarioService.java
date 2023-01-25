package work.appdeploys.veterinaria.services;

import work.appdeploys.veterinaria.models.dtos.UsuarioDto;

import java.util.List;

public interface UsuarioService extends CRUDService<UsuarioDto> {
    @Override
    void delete(Long id);
    @Override
    UsuarioDto update(UsuarioDto usuarioDto);
    @Override
    List<UsuarioDto> findAll();
    @Override
    UsuarioDto findById(Long id);
    UsuarioDto findByDocumentoId(Integer idDocumento);
    UsuarioDto save(UsuarioDto usuarioDto);
}
