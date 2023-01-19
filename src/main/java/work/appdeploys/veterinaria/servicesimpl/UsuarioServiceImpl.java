package work.appdeploys.veterinaria.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import work.appdeploys.veterinaria.constans.MessageResource;
import work.appdeploys.veterinaria.exceptions.UsuarioExeptionBadRequest;
import work.appdeploys.veterinaria.mappers.UsuarioMapper;
import work.appdeploys.veterinaria.models.dtos.UsuarioDto;
import work.appdeploys.veterinaria.repositories.UsuarioRepository;
import work.appdeploys.veterinaria.services.UsuarioService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

    public static Set<String> tipoDocumentoValido = new HashSet<>(Arrays.asList("CC", "TI", "RUT"));
    public static Set<Integer> sexoValido = new HashSet<>(Arrays.asList(0, 1, 2));

    @Override
    public UsuarioDto save(UsuarioDto usuarioDto) {
        validateUsuarioById(usuarioDto.getId(),MessageResource.USUARIO_ALREADY_EXISTS.getValue());
        if (!tipoDocumentoValido.contains(usuarioDto.getTipoDocumento())) {
            throw new UsuarioExeptionBadRequest(MessageResource.USUARIO_DOCUMENT_TYPE_NOT_EXISTS.getValue());
        }
        if (!sexoValido.contains(usuarioDto.getSexo())) {
            throw new UsuarioExeptionBadRequest(MessageResource.USUARIO_SEX_CODE_NOT_EXISTS.getValue());
        }
        return usuarioMapper.toDto(usuarioRepository.save(usuarioMapper.toModel(usuarioDto)));
    }

    @Override
    public void delete(Long id) {
        validateUsuarioById(id,MessageResource.USUARIO_NOT_EXISTS.getValue());
        usuarioRepository.deleteById(id);
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

    private void validateUsuarioById(Long id, String message) {
        usuarioRepository.findById(id).orElseThrow(() -> new UsuarioExeptionBadRequest(message));
    }


}
