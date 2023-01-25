package work.appdeploys.veterinaria.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.DateValidator;
import org.springframework.stereotype.Service;
import work.appdeploys.veterinaria.constans.MessageResource;
import work.appdeploys.veterinaria.exceptions.DetalleHistoriaClinicaExeptionBadRequest;
import work.appdeploys.veterinaria.exceptions.HistoriaClinicaExeptionBadRequest;
import work.appdeploys.veterinaria.exceptions.UsuarioExeptionBadRequest;
import work.appdeploys.veterinaria.mappers.DetalleHistoriaClinicaMapper;
import work.appdeploys.veterinaria.mappers.DetalleHistoriaClinicaStructuresMapper;
import work.appdeploys.veterinaria.models.DetalleHistoriaClinica;
import work.appdeploys.veterinaria.models.dtos.DetalleHistoriaClinicaDto;
import work.appdeploys.veterinaria.models.dtos.DetalleHistoriaClinicaPostDto;
import work.appdeploys.veterinaria.models.dtos.DetalleHistoriaClinicaPutDto;
import work.appdeploys.veterinaria.repositories.ColaboradorRepository;
import work.appdeploys.veterinaria.repositories.DetalleHistoriaClinicaRepository;
import work.appdeploys.veterinaria.repositories.HistoriaClinicaRepository;
import work.appdeploys.veterinaria.services.DetalleHistoriaClinicaService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DetalleHistoriaClinicaServiceImpl implements DetalleHistoriaClinicaService {
    private final DetalleHistoriaClinicaMapper detalleHistoriaClinicaMapper;
    private final DetalleHistoriaClinicaStructuresMapper detalleHistoriaClinicaStructuresMapper;
    private final DetalleHistoriaClinicaRepository detalleHistoriaClinicaRepository;
    private final ColaboradorRepository colaboradorRepository;
    private final HistoriaClinicaRepository historiaClinicaRepository;

    @Override
    public DetalleHistoriaClinicaDto save(DetalleHistoriaClinicaPostDto detalleHistoriaClinicaPostDto) {
        dateTimeValidator(detalleHistoriaClinicaPostDto.getFechaHora().toString(), MessageResource.HISTORIA_DETALLE_CLINICA_INVALID_DATE_TIME.getValue().trim());
        validateExistHistoriaClinica(detalleHistoriaClinicaPostDto.getIdHistoriaClinica(), MessageResource.HISTORIA_CLINICA_NOT_EXISTS.getValue().trim());
        validateExistColaboradorById(detalleHistoriaClinicaPostDto.getIdColaborador(), MessageResource.COLABORADOR_NOT_EXISTS.getValue().trim());
        DetalleHistoriaClinica detalleHistoriaClinica = detalleHistoriaClinicaRepository.save(detalleHistoriaClinicaStructuresMapper.toModel(detalleHistoriaClinicaPostDto));
        detalleHistoriaClinica.setColaborador(colaboradorRepository.findById(detalleHistoriaClinica.getColaborador().getId()).get());
        detalleHistoriaClinica.setHistoriaClinica(historiaClinicaRepository.findById(detalleHistoriaClinica.getHistoriaClinica().getId()).get());
        return detalleHistoriaClinicaMapper.toDto(detalleHistoriaClinica);
    }

    @Override
    public void delete(Long id) {
        validateExistDetalleHistoriaClinica(id, MessageResource.HISTORIA_DETALLE_CLINICA_NOT_EXISTS.toString());
        detalleHistoriaClinicaRepository.deleteById(id);
    }

    @Override
    public DetalleHistoriaClinicaDto update(DetalleHistoriaClinicaPutDto detalleHistoriaClinicaPutDto) {
        validateExistDetalleHistoriaClinica(detalleHistoriaClinicaPutDto.getId(), MessageResource.HISTORIA_DETALLE_CLINICA_NOT_EXISTS.getValue());
        dateTimeValidator(detalleHistoriaClinicaPutDto.getFechaHora().toString(), MessageResource.HISTORIA_DETALLE_CLINICA_INVALID_DATE_TIME.getValue().trim());
        validateExistHistoriaClinica(detalleHistoriaClinicaPutDto.getIdHistoriaClinica(), MessageResource.HISTORIA_CLINICA_NOT_EXISTS.getValue().trim());
        validateExistColaboradorById(detalleHistoriaClinicaPutDto.getIdColaborador(), MessageResource.COLABORADOR_NOT_EXISTS.getValue().trim());
        DetalleHistoriaClinica detalleHistoriaClinica = detalleHistoriaClinicaRepository.save(detalleHistoriaClinicaStructuresMapper.toModel(detalleHistoriaClinicaPutDto));
        return detalleHistoriaClinicaMapper.toDto(caragaModelo(detalleHistoriaClinica));
    }

    @Override
    public List<DetalleHistoriaClinicaDto> findAll() {
        List<DetalleHistoriaClinica> detalleHistoriaClinicaList = detalleHistoriaClinicaRepository.findAll();
        if (detalleHistoriaClinicaList.isEmpty()) {
            throw new DetalleHistoriaClinicaExeptionBadRequest(MessageResource.HISTORIA_CLINICA_NOT_FOUND.getValue());
        }
        return detalleHistoriaClinicaList.stream().map(detalleHistoriaClinicaMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public DetalleHistoriaClinicaDto findById(Long id) {
        DetalleHistoriaClinica detalleHistoriaClinica = detalleHistoriaClinicaRepository
                .findById(id)
                .orElseThrow(() -> new DetalleHistoriaClinicaExeptionBadRequest(MessageResource.DETALLE_HISTORIA_CLINICA_NOT_FOUND.getValue()));

        return detalleHistoriaClinicaMapper.toDto(detalleHistoriaClinica);
    }

    @Override
    public List<DetalleHistoriaClinicaDto> findAllByHistoriaId(Long idHistoriClinica) {
        List<DetalleHistoriaClinica> detalleHistoriaClinicaList = detalleHistoriaClinicaRepository.findAllByHistoriaClinica_IdOrderByFechaHoraDesc(idHistoriClinica);
        if (detalleHistoriaClinicaList.isEmpty()) {
            throw new DetalleHistoriaClinicaExeptionBadRequest(MessageResource.DETALLE_HISTORIA_CLINICA_NOT_FOUND.getValue());
        }
        return detalleHistoriaClinicaList.stream().map(detalleHistoriaClinicaMapper::toDto).collect(Collectors.toList());
    }

    public void dateTimeValidator(String date, String message) {
        DateValidator validator = DateValidator.getInstance();
        if (!validator.isValid(date, "yyyy-MM-dd'T'HH:mm:ss.SSS")) {
            throw new DetalleHistoriaClinicaExeptionBadRequest(message);
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

    private DetalleHistoriaClinica caragaModelo(DetalleHistoriaClinica detalleHistoriaClinica) {
        detalleHistoriaClinica.setHistoriaClinica(historiaClinicaRepository.findById(detalleHistoriaClinica.getHistoriaClinica().getId()).get());
        detalleHistoriaClinica.setColaborador(colaboradorRepository.findById(detalleHistoriaClinica.getColaborador().getId()).get());
        return detalleHistoriaClinica;
    }
}
