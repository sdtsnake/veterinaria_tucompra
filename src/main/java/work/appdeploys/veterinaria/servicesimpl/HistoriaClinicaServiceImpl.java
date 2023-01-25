package work.appdeploys.veterinaria.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.DateValidator;
import org.springframework.stereotype.Service;
import work.appdeploys.veterinaria.constans.MessageResource;
import work.appdeploys.veterinaria.exceptions.HistoriaClinicaExeptionBadRequest;
import work.appdeploys.veterinaria.exceptions.MascotaExeptionBadRequest;
import work.appdeploys.veterinaria.mappers.HistoriaClinicaMapper;
import work.appdeploys.veterinaria.mappers.HistoriaClinicaSaveMapper;
import work.appdeploys.veterinaria.models.HistoriaClinica;
import work.appdeploys.veterinaria.models.dtos.HistoriaClinicaDto;
import work.appdeploys.veterinaria.models.dtos.HistoriaClinicaPostDto;
import work.appdeploys.veterinaria.repositories.HistoriaClinicaRepository;
import work.appdeploys.veterinaria.repositories.MascotaRepository;
import work.appdeploys.veterinaria.services.HistoriaClinicaService;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {
    private final HistoriaClinicaMapper historiaClinicaMapper;
    private final HistoriaClinicaRepository historiaClinicaRepository;
    private final MascotaRepository mascotaRepository;
    private final HistoriaClinicaSaveMapper historiaClinicaSaveMapper;
    @Override
    public HistoriaClinicaDto save(HistoriaClinicaPostDto historiaClinicaPostDto) {
        validateExistMascotaById(historiaClinicaPostDto.getIdMascota(), MessageResource.MASCOTA_NOT_EXISTS.getValue().trim());
        validateMascotaHistoriaClinica(historiaClinicaPostDto.getIdMascota(),MessageResource.HISTORIA_CLINICA_MASCOTA_ALREADY_EXISTS.getValue().trim());
        dateValidator(historiaClinicaPostDto.getFechaCreacion().toString(), MessageResource.DATE_NOT_VALID.getValue().trim());
        return historiaClinicaMapper.toDto(historiaClinicaRepository.save(historiaClinicaSaveMapper.toModel(historiaClinicaPostDto)));
    }
    @Override
    public void delete(Long id) {
        validateExistHistoriaClinica(id,MessageResource.HISTORIA_CLINICA_NOT_EXISTS.getValue().trim());
        historiaClinicaRepository.deleteById(id);
    }
    @Override
    public HistoriaClinicaDto update(HistoriaClinicaDto historiaClinicaDto) {
        validateExistMascotaById(historiaClinicaDto.getMascota().getId(), MessageResource.MASCOTA_NOT_EXISTS.getValue().trim());
        validateMascotaHistoriaClinica(historiaClinicaDto.getId(),historiaClinicaDto.getMascota().getId(),MessageResource.HISTORIA_CLINICA_MASCOTA_ALREADY_EXISTS.getValue().trim());
        return historiaClinicaMapper.toDto(historiaClinicaRepository.save(historiaClinicaMapper.toModel(historiaClinicaDto)));
    }

    @Override
    public List<HistoriaClinicaDto> findAll() {
        List<HistoriaClinica> historiaClinicaList = historiaClinicaRepository.findAll();
        if(historiaClinicaList.isEmpty()){
            throw new HistoriaClinicaExeptionBadRequest(MessageResource.HISTORIA_CLINICA_NOT_FOUND.getValue());
        }
        return historiaClinicaList.stream().map(historiaClinicaMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public HistoriaClinicaDto findById(Long id) {
        HistoriaClinica historiaClinica = historiaClinicaRepository
                .findById(id)
                .orElseThrow(() ->new MascotaExeptionBadRequest(MessageResource.HISTORIA_CLINICA_NOT_FOUND.getValue()));

        return historiaClinicaMapper.toDto(historiaClinica);
    }

    private void validateExistMascotaById(Long id, String message) {
        mascotaRepository.findById(id).orElseThrow(() -> new HistoriaClinicaExeptionBadRequest(message));
    }

    public void dateValidator(String date, String message) {
        DateValidator validator = DateValidator.getInstance();
        if (!validator.isValid(date, "YYYY-MM-dd", Locale.US)) {
            throw new HistoriaClinicaExeptionBadRequest(message);
        }
    }
    private void validateExistHistoriaClinica(Long id, String message) {
        historiaClinicaRepository.findById(id).orElseThrow(() -> new HistoriaClinicaExeptionBadRequest(message));
    }
    private void validateNotExistHistoriaClinicaById(Long id, String message){
        if (historiaClinicaRepository.findById(id).isPresent()) {
            throw new HistoriaClinicaExeptionBadRequest(message);
        }
    }
    private void validateMascotaHistoriaClinica(Long id, String message){
        if (historiaClinicaRepository.findByMascota_Id(id).isPresent()) {
            throw new HistoriaClinicaExeptionBadRequest(message);
        }
    }
    private void validateMascotaHistoriaClinica(Long id,Long mascotaId, String message){
        List<HistoriaClinica> historiaLsit = historiaClinicaRepository.findAllByMascota_Id(mascotaId);
        for (HistoriaClinica h: historiaLsit) {
            if (h.getId() != id) {
                throw new HistoriaClinicaExeptionBadRequest(message);
            }
        }
    }
}
