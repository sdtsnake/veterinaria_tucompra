package work.appdeploys.veterinaria.servicesimpl;

import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.DateValidator;
import org.springframework.stereotype.Service;
import work.appdeploys.veterinaria.constans.MessageResource;
import work.appdeploys.veterinaria.exceptions.HistoriaClinicaExeptionBadRequest;
import work.appdeploys.veterinaria.exceptions.MascotaExeptionBadRequest;
import work.appdeploys.veterinaria.mappers.HistoriaClinicaMapper;
import work.appdeploys.veterinaria.models.dtos.HistoriaClinicaDto;
import work.appdeploys.veterinaria.repositories.HistoriaClinicaRepository;
import work.appdeploys.veterinaria.repositories.MascotaRepository;
import work.appdeploys.veterinaria.services.HistoriaClinicaService;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {
    private final HistoriaClinicaMapper historiaClinicaMapper;
    private final HistoriaClinicaRepository historiaClinicaRepository;
    private final MascotaRepository mascotaRepository;

    @Override
    public HistoriaClinicaDto save(HistoriaClinicaDto historiaClinicaDto) {
        validateExistMascotaById(historiaClinicaDto.getMascota().getId(), MessageResource.MASCOTA_NOT_EXISTS.getValue().trim());
        dateValidator(historiaClinicaDto.getFechaCreacion().toString(), MessageResource.DATE_NOT_VALID.getValue().trim());
        return historiaClinicaMapper.toDto(historiaClinicaRepository.save(historiaClinicaMapper.toModel(historiaClinicaDto)));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public HistoriaClinicaDto update(HistoriaClinicaDto historiaClinicaDto) {
        return null;
    }

    @Override
    public List<HistoriaClinicaDto> findAll() {
        return null;
    }

    @Override
    public HistoriaClinicaDto findById(Long id) {
        return null;
    }

    private void validateExistMascotaById(Long id, String message) {
        mascotaRepository.findById(id).orElseThrow(() -> new MascotaExeptionBadRequest(message));
    }

    public void dateValidator(String date, String message) {
        DateValidator validator = DateValidator.getInstance();
        if (!validator.isValid(date, "YYYY-MM-dd", Locale.US)) {
            throw new HistoriaClinicaExeptionBadRequest(message);
        }
    }
}
