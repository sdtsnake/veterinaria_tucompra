package work.appdeploys.veterinaria.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import work.appdeploys.veterinaria.constans.MessageResource;
import work.appdeploys.veterinaria.exceptions.UsuarioExeptionBadRequest;
import work.appdeploys.veterinaria.mappers.ColaboradorMapper;
import work.appdeploys.veterinaria.models.Colaborador;
import work.appdeploys.veterinaria.models.dtos.ColaboradorDto;
import work.appdeploys.veterinaria.repositories.ColaboradorRepository;
import work.appdeploys.veterinaria.services.ColaboradorServicio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColaboradorServiceImpl implements ColaboradorServicio {
    private final ColaboradorMapper colaboradorMapper;
    private final ColaboradorRepository colaboradorRepository;
    protected static final Set<String> tipoDocumentoValido = new HashSet<>(Arrays.asList("CC", "TI", "RUT"));
    @Override
    public ColaboradorDto save(ColaboradorDto colaboradorDto) {
        if(!Objects.isNull(colaboradorDto.getId())){
            validateNotExistUsuarioById(colaboradorDto.getId(), MessageResource.COLABORADOR_ALREADY_EXISTS.getValue());
        }
        validateExistUsuarioByDocumentId(colaboradorDto.getDocumentoIdentificacion(),MessageResource.COLABORADOR_DOCUMENT_ID_ALREADY_EXISTS.getValue());
        validaCampos(colaboradorDto.getTipoDocumento());
        return colaboradorMapper.toDto(colaboradorRepository.save(colaboradorMapper.toModel(colaboradorDto)));
    }
    @Override
    public void delete(Long id) {
        validateExistColaboradorById(id, MessageResource.COLABORADOR_NOT_EXISTS_DELETE.getValue());
        colaboradorRepository.deleteById(id);
    }
    @Override
    public ColaboradorDto update(ColaboradorDto colaboradorDto) {
        validaCampos(colaboradorDto.getTipoDocumento());
        validateExistUsuarioByDocumentId(colaboradorDto.getDocumentoIdentificacion(),colaboradorDto.getId(),MessageResource.COLABORADOR_NOT_EXISTS_DELETE.getValue());
        return colaboradorMapper.toDto(colaboradorRepository.save(colaboradorMapper.toModel(colaboradorDto)));
    }
    @Override
    public List<ColaboradorDto> findAll() {
        List<Colaborador> colaboradorList = colaboradorRepository.findAll();
        if(colaboradorList.isEmpty()){
            throw new UsuarioExeptionBadRequest(MessageResource.COLABORADOR_NOT_FOUND.getValue());
        }
        return colaboradorList.stream().map(colaboradorMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public ColaboradorDto findById(Long id) {
        Colaborador colaborador = colaboradorRepository
                .findById(id)
                .orElseThrow(() ->new UsuarioExeptionBadRequest(MessageResource.USUARIO_NOT_FOUND.getValue()));

        return colaboradorMapper.toDto(colaborador);
    }

    @Override
    public ColaboradorDto findByDocumentoId(Integer idDocumento) {
        return null;
    }
    private void validateNotExistUsuarioById(Long id,String message){
        if(colaboradorRepository.findById(id).isPresent()){
            throw new UsuarioExeptionBadRequest(message);
        }
    }
    private void validateExistUsuarioByDocumentId(Integer documentoId, String message) {
        if(colaboradorRepository.findByDocumentoIdentificacion(documentoId).isPresent()){
            throw new UsuarioExeptionBadRequest(message);
        }
    }
    private void validaCampos(String tipoDocumento){
        if (!tipoDocumentoValido.contains(tipoDocumento)) {
            throw new UsuarioExeptionBadRequest(MessageResource.COLABORADOR_DOCUMENT_TYPE_NOT_EXISTS.getValue());
        }
    }
    private void validateExistColaboradorById(Long id, String message) {
        colaboradorRepository.findById(id).orElseThrow(() -> new UsuarioExeptionBadRequest(message));
    }
    private void validateExistUsuarioByDocumentId(Integer documentoId, Long id ,String message) {
        List<Colaborador> colaboradorList = colaboradorRepository.findAllByDocumentoIdentificacion(documentoId);
        for (Colaborador l: colaboradorList) {
            if(l.getId() != id){
                throw new UsuarioExeptionBadRequest(message);
            }
        }
    }

}
