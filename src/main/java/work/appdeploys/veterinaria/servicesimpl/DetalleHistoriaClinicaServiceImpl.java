package work.appdeploys.veterinaria.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.DateValidator;
import org.springframework.stereotype.Service;
import work.appdeploys.veterinaria.constans.MessageResource;
import work.appdeploys.veterinaria.exceptions.HistoriaClinicaExeptionBadRequest;
import work.appdeploys.veterinaria.exceptions.MascotaExeptionBadRequest;
import work.appdeploys.veterinaria.exceptions.UsuarioExeptionBadRequest;
import work.appdeploys.veterinaria.mappers.DetalleHistoriaClinicaMapper;
import work.appdeploys.veterinaria.models.DetalleHistoriaClinica;
import work.appdeploys.veterinaria.models.dtos.DetalleHistoriaClinicaDto;
import work.appdeploys.veterinaria.repositories.ColaboradorRepository;
import work.appdeploys.veterinaria.repositories.DetalleHistoriaClinicaRepository;
import work.appdeploys.veterinaria.repositories.HistoriaClinicaRepository;
import work.appdeploys.veterinaria.services.DetalleHistoriaClinicaService;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DetalleHistoriaClinicaServiceImpl implements DetalleHistoriaClinicaService {
    private final DetalleHistoriaClinicaMapper detalleHistoriaClinicaMapper;
    private final DetalleHistoriaClinicaRepository detalleHistoriaClinicaRepository;
    private final ColaboradorRepository colaboradorRepository;

    private final HistoriaClinicaRepository historiaClinicaRepository;

    @Override
    public DetalleHistoriaClinicaDto save(DetalleHistoriaClinicaDto detalleHistoriaClinicaDto) {
        if (!Objects.isNull(detalleHistoriaClinicaDto.getId())) {
            validateNotExistDetalleHistoriaClinicaById(detalleHistoriaClinicaDto.getId(), MessageResource.HISTORIA_DETALLE_CLINICA_ALREADY_EXISTS.getValue().trim());
        }
        dateTimeValidator(detalleHistoriaClinicaDto.getFechaHora().toString(),MessageResource.HISTORIA_DETALLE_CLINICA_INVALID_DATE_TIME.getValue().trim());
        validateExistHistoriaClinica(detalleHistoriaClinicaDto.getHistoriaClinica().getId(), MessageResource.HISTORIA_CLINICA_NOT_EXISTS.getValue().trim());
        validateExistColaboradorById(detalleHistoriaClinicaDto.getColaborador().getId(), MessageResource.COLABORADOR_NOT_EXISTS.getValue().trim());
        return detalleHistoriaClinicaMapper.toDto(detalleHistoriaClinicaRepository.save(detalleHistoriaClinicaMapper.toModel(detalleHistoriaClinicaDto)));
    }
    @Override
    public void delete(Long id) {
        validateExistDetalleHistoriaClinica(id,MessageResource.HISTORIA_DETALLE_CLINICA_NOT_EXISTS.toString());
        historiaClinicaRepository.deleteById(id);
    }
    @Override
    public DetalleHistoriaClinicaDto update(DetalleHistoriaClinicaDto detalleHistoriaClinicaDto) {
        validateExistDetalleHistoriaClinica(detalleHistoriaClinicaDto.getId(),MessageResource.HISTORIA_DETALLE_CLINICA_NOT_EXISTS.toString());
        dateTimeValidator(detalleHistoriaClinicaDto.getFechaHora().toString(),MessageResource.HISTORIA_DETALLE_CLINICA_INVALID_DATE_TIME.getValue().trim());
        validateExistHistoriaClinica(detalleHistoriaClinicaDto.getHistoriaClinica().getId(), MessageResource.HISTORIA_CLINICA_NOT_EXISTS.getValue().trim());
        validateExistColaboradorById(detalleHistoriaClinicaDto.getColaborador().getId(), MessageResource.COLABORADOR_NOT_EXISTS.getValue().trim());
        return detalleHistoriaClinicaMapper.toDto(detalleHistoriaClinicaRepository.save(detalleHistoriaClinicaMapper.toModel(detalleHistoriaClinicaDto)));
    }

    @Override
    public List<DetalleHistoriaClinicaDto> findAll() {
        List<DetalleHistoriaClinica> detalleHistoriaClinicaList = detalleHistoriaClinicaRepository.findAll();
        if(detalleHistoriaClinicaList.isEmpty()){
            throw new HistoriaClinicaExeptionBadRequest(MessageResource.HISTORIA_CLINICA_NOT_FOUND.getValue());
        }
        return detalleHistoriaClinicaList.stream().map(detalleHistoriaClinicaMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public DetalleHistoriaClinicaDto findById(Long id) {
        DetalleHistoriaClinica detalleHistoriaClinica  = detalleHistoriaClinicaRepository
                .findById(id)
                .orElseThrow(() ->new MascotaExeptionBadRequest(MessageResource.DETALLE_HISTORIA_CLINICA_NOT_FOUND.getValue()));

        return detalleHistoriaClinicaMapper.toDto(detalleHistoriaClinica);
    }

    private void validateNotExistDetalleHistoriaClinicaById(Long id, String message) {
        if (detalleHistoriaClinicaRepository.findById(id).isPresent()) {
            throw new HistoriaClinicaExeptionBadRequest(message);
        }
    }
    public void dateTimeValidator(String date, String message) {
        DateValidator validator = DateValidator.getInstance();
        if (!validator.isValid(date, "YYYY-MM-dd HH:mm:SS", Locale.US)) {
            throw new HistoriaClinicaExeptionBadRequest(message);
        }
    }
    private void validateExistHistoriaClinica(Long id, String message) {
        historiaClinicaRepository.findById(id).orElseThrow(() -> new HistoriaClinicaExeptionBadRequest(message));
    }
    private void validateExistDetalleHistoriaClinica(Long id, String message) {
        detalleHistoriaClinicaRepository.findById(id).orElseThrow(() -> new HistoriaClinicaExeptionBadRequest(message));
    }
    private void validateExistColaboradorById(Long id, String message) {
        colaboradorRepository.findById(id).orElseThrow(() -> new UsuarioExeptionBadRequest(message));
    }






























}
