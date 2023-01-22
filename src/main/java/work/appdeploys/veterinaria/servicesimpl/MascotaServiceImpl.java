package work.appdeploys.veterinaria.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import work.appdeploys.veterinaria.constans.MessageResource;
import work.appdeploys.veterinaria.exceptions.MascotaExeptionBadRequest;
import work.appdeploys.veterinaria.mappers.MascotaMapper;
import work.appdeploys.veterinaria.models.Mascota;
import work.appdeploys.veterinaria.models.dtos.MascotaDto;
import work.appdeploys.veterinaria.repositories.MascotaRepository;
import work.appdeploys.veterinaria.repositories.UsuarioRepository;
import work.appdeploys.veterinaria.services.MascotaService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService {
    private final MascotaMapper mascotaMapper;
    private final MascotaRepository mascotaRepository;
    private final UsuarioRepository usuarioRepository;
    public final Set<Integer> sexoValido = new HashSet<>(Arrays.asList(0, 1));
    @Override
    public MascotaDto save(MascotaDto mascotaDto) {
        if(!Objects.isNull(mascotaDto.getId())){
            validateNotExistMascotaById(mascotaDto.getId(), MessageResource.MASCOTA_ALREADY_EXISTS_ID.getValue().trim());
        }
        validateExistUsuarioById(mascotaDto.getUsuario().getId(), MessageResource.USUARIO_NOT_EXISTS.getValue().trim());
        validateNameAndUsuarioId(mascotaDto.getUsuario().getId(), mascotaDto.getNombre());
        validaCampos(mascotaDto.getSexo());
        return mascotaMapper.toDto(mascotaRepository.save(mascotaMapper.toModel(mascotaDto)));
    }
    @Override
    public void delete(Long id) {
        validateExistMascotaById(id, MessageResource.MASCOTA_NOT_EXISTS_DELETE.getValue().trim());
        mascotaRepository.deleteById(id);
    }
    @Override
    public MascotaDto update(MascotaDto mascotaDto) {
        validateExistMascotaById(mascotaDto.getId(), MessageResource.MASCOTA_NOT_EXISTS.getValue().trim());
        validaCampos(mascotaDto.getSexo());
        validateNameAndUsuarioId(mascotaDto.getUsuario().getId(), mascotaDto.getNombre());
        return mascotaMapper.toDto(mascotaRepository.save(mascotaMapper.toModel(mascotaDto)));
    }
    @Override
    public List<MascotaDto> findAll() {
        List<Mascota> mascotaList = mascotaRepository.findAll();
        if(mascotaList.isEmpty()){
            throw new MascotaExeptionBadRequest(MessageResource.MASCOTAS_NOT_FOUND.getValue());
        }
        return mascotaList.stream().map(mascotaMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public List<MascotaDto> findAllSinHistoria() {

        return mascotaRepository.findAllByMascotasSinHistoria().stream().map(mascotaMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public MascotaDto findById(Long id) {
        Mascota mascota = mascotaRepository
                .findById(id)
                .orElseThrow(() ->new MascotaExeptionBadRequest(MessageResource.MASCOTAS_NOT_FOUND.getValue()));

        return mascotaMapper.toDto(mascota);
    }
    private void validateNameAndUsuarioId(Long id, String nombre) {
        List<Mascota> mascotaList = mascotaRepository.findAllByUsuarioId_Id(id);
        for (Mascota m : mascotaList) {
            if (m.getNombre().trim().equalsIgnoreCase(nombre)) {
                throw new MascotaExeptionBadRequest(MessageResource.MASCOTA_ALREADY_EXISTS.getValue());
            }
        }
    }
    private void validaCampos(Integer sexo) {
        if (!sexoValido.contains(sexo)) {
            throw new MascotaExeptionBadRequest(MessageResource.MASCOTA_SEX_CODE_NOT_EXISTS.getValue());
        }
    }
    private void validateExistUsuarioById(Long id, String message) {
        usuarioRepository.findById(id).orElseThrow(() -> new MascotaExeptionBadRequest(message));
    }
    private void validateNotExistMascotaById(Long id, String message) {
        if (mascotaRepository.findById(id).isPresent()) {
            throw new MascotaExeptionBadRequest(message);
        }
    }
    private void validateExistMascotaById(Long id, String message){
        mascotaRepository.findById(id).orElseThrow(() -> new MascotaExeptionBadRequest(message));
    }

}
