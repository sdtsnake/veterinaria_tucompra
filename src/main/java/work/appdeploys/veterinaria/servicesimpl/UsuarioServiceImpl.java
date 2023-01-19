package work.appdeploys.veterinaria.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import work.appdeploys.veterinaria.constans.MessageResource;
import work.appdeploys.veterinaria.exceptions.UsuarioExeptionBadRequest;
import work.appdeploys.veterinaria.mappers.UsuarioMapper;
import work.appdeploys.veterinaria.models.Usuario;
import work.appdeploys.veterinaria.models.dtos.UsuarioDto;
import work.appdeploys.veterinaria.repositories.UsuarioRepository;
import work.appdeploys.veterinaria.services.UsuarioService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto save(UsuarioDto usuarioDto) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByDocumentoId(usuarioDto.getDocumentoId());
        if (!usuarioOpt.isEmpty()) {
            throw new UsuarioExeptionBadRequest(MessageResource.USUARIO_ALREADY_EXISTS.getValue());
        }
        if (usuarioDto.getTipoDocumento() != "CC" &&
                usuarioDto.getTipoDocumento() != "TI" &&
                usuarioDto.getTipoDocumento() != "RUT") {
            throw new UsuarioExeptionBadRequest(MessageResource.USUARIO_DOCUMENT_TYPE_NOT_EXISTS.getValue());
        }
        if (usuarioDto.getSexo() != 0 &&
                usuarioDto.getSexo() != 1 &&
                usuarioDto.getSexo() != 2) {
            throw new UsuarioExeptionBadRequest(MessageResource.USUARIO_SEX_CODE_NOT_EXISTS.getValue());
        }
        return usuarioMapper.toDto(usuarioRepository.save(usuarioMapper.toModel(usuarioDto)));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UsuarioDto update(UsuarioDto usuarioDto) {
        return null;
    }

    @Override
    public List<UsuarioDto> findAll() {
        return null;
    }

    @Override
    public UsuarioDto findByDocumentoId(Long idDocumento) {
        return null;
    }


}
