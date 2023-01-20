package work.appdeploys.veterinaria.services;

import work.appdeploys.veterinaria.models.dtos.UsuarioDto;

import java.util.List;

public interface UsuarioService extends CRUDService<UsuarioDto> {

    UsuarioDto save(UsuarioDto usuarioDto);
    void delete(Long id);
    UsuarioDto update(UsuarioDto usuarioDto);
    List<UsuarioDto> findAll();
    UsuarioDto findById(Long id);
    UsuarioDto findByDocumentoId(Integer idDocumento);
}
