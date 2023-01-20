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

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;
    public static Set<String> tipoDocumentoValido = new HashSet<>(Arrays.asList("CC", "TI", "RUT"));
    public final Set<Integer> sexoValido = new HashSet<>(Arrays.asList(0, 1, 2));

    @Override
    public UsuarioDto save(UsuarioDto usuarioDto) {
        if(!Objects.isNull(usuarioDto.getId())){
            validateNotExistUsuarioById(usuarioDto.getId(), MessageResource.USUARIO_ALREADY_EXISTS.getValue());
        }
        validateExistUsuarioByDocumentId(usuarioDto.getDocumentoId(),MessageResource.USUARIO_DOCUMENT_ID_ALREADY_EXISTS.getValue());
        validaCampos(usuarioDto.getTipoDocumento(), usuarioDto.getSexo());
        return usuarioMapper.toDto(usuarioRepository.save(usuarioMapper.toModel(usuarioDto)));
    }

    @Override
    public void delete(Long id) {
        validateExistUsuarioById(id, MessageResource.USUARIO_NOT_EXISTS_DELETE.getValue());
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioDto update(UsuarioDto usuarioDto) {
        validaCampos(usuarioDto.getTipoDocumento(), usuarioDto.getSexo());
        validateExistUsuarioByDocumentId(usuarioDto.getDocumentoId(),usuarioDto.getId(),MessageResource.USUARIO_DOCUMENT_ID_ALREADY_EXISTS.getValue());
        return usuarioMapper.toDto(usuarioRepository.save(usuarioMapper.toModel(usuarioDto)));
    }
    @Override
    public List<UsuarioDto> findAll() {
        List<Usuario> usuarioList = usuarioRepository.findAll();
        if(usuarioList.isEmpty()){
            throw new UsuarioExeptionBadRequest(MessageResource.USUARIO_NOT_FOUND.getValue());
        }
        return usuarioList.stream().map(usuarioMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UsuarioDto findByDocumentoId(Integer idDocumento) {
        Usuario usuario = usuarioRepository
                .findByDocumentoId(idDocumento)
                .orElseThrow(() ->new UsuarioExeptionBadRequest(MessageResource.USUARIO_NOT_FOUND.getValue()));

        return usuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioDto findById(Long id) {
        Usuario usuario = usuarioRepository
                .findById(id)
                .orElseThrow(() ->new UsuarioExeptionBadRequest(MessageResource.USUARIO_NOT_FOUND.getValue()));

        return usuarioMapper.toDto(usuario);
    }

    private void validateNotExistUsuarioById(Long id, String message) {
        if(usuarioRepository.findById(id).isPresent()){
            throw new UsuarioExeptionBadRequest(message);
        }
    }
    private void validateExistUsuarioByDocumentId(Integer documentoId, Long id ,String message) {
        List<Usuario> usuarioList = usuarioRepository.findAllByDocumentoId(documentoId);
        for (Usuario l: usuarioList) {
            if(l.getId() != id){
                throw new UsuarioExeptionBadRequest(message);
            }
        }
    }
    private void validateExistUsuarioByDocumentId(Integer documentoId, String message) {
        if(usuarioRepository.findByDocumentoId(documentoId).isPresent()){
            throw new UsuarioExeptionBadRequest(message);
        }
    }
    private void validateExistUsuarioById(Long id, String message) {
        usuarioRepository.findById(id).orElseThrow(() -> new UsuarioExeptionBadRequest(message));
    }
    private void validaCampos(String tipoDocumento, Integer sexo) {
        if (!tipoDocumentoValido.contains(tipoDocumento)) {
            throw new UsuarioExeptionBadRequest(MessageResource.USUARIO_DOCUMENT_TYPE_NOT_EXISTS.getValue());
        }
        if (!sexoValido.contains(sexo)) {
            throw new UsuarioExeptionBadRequest(MessageResource.USUARIO_SEX_CODE_NOT_EXISTS.getValue());
        }

    }


}
