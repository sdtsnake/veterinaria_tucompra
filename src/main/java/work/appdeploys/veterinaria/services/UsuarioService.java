package work.appdeploys.veterinaria.services;

import work.appdeploys.veterinaria.models.dtos.UsuarioDto;

import java.util.List;

public interface UsuarioService {

    UsuarioDto save(UsuarioDto usuarioDto);
    void delete(Long id);
    UsuarioDto update(UsuarioDto usuarioDto);
    List<UsuarioDto> findAll();
    UsuarioDto findByDocumentoId(Integer idDocumento);
    UsuarioDto findById(Long id);
}
