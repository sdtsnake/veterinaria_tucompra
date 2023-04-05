package work.appdeploys.veterinaria.historiasclinicas.application.service;

import org.apache.commons.validator.routines.DateValidator;
import work.appdeploys.veterinaria.constans.MessageResource;
import work.appdeploys.veterinaria.exceptions.HistoriaClinicaExeptionBadRequest;
import work.appdeploys.veterinaria.historiasclinicas.adapters.in.web.Dto.HistoriaClinicaInDto;
import work.appdeploys.veterinaria.historiasclinicas.adapters.out.persistence.mapper.HistoriaClinicaOutMapper;
import work.appdeploys.veterinaria.historiasclinicas.application.port.in.HistoriaClinicaCommand;
import work.appdeploys.veterinaria.historiasclinicas.application.port.in.HistoriaClinicaInPort;
import work.appdeploys.veterinaria.historiasclinicas.application.port.out.HistoriaClinicaDeletePort;
import work.appdeploys.veterinaria.historiasclinicas.application.port.out.HistoriaClinicaFindAllByIdMascotaPort;
import work.appdeploys.veterinaria.historiasclinicas.application.port.out.HistoriaClinicaFindAllPort;
import work.appdeploys.veterinaria.historiasclinicas.application.port.out.HistoriaClinicaFindByIdMascotaPort;
import work.appdeploys.veterinaria.historiasclinicas.application.port.out.HistoriaClinicaFindByIdPort;
import work.appdeploys.veterinaria.historiasclinicas.application.port.out.HistoriaClinicaSavePort;
import work.appdeploys.veterinaria.historiasclinicas.application.port.out.HistoriaClinicaUpdatePort;
import work.appdeploys.veterinaria.historiasclinicas.common.UseCase;
import work.appdeploys.veterinaria.historiasclinicas.domain.HistoriaClinica;
import work.appdeploys.veterinaria.repositories.MascotaRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@UseCase
public class HistortiaClinicaService implements HistoriaClinicaInPort {
    HistoriaClinicaDeletePort historiaClinicaDeletePort;
    HistoriaClinicaFindByIdPort historiaClinicaFindByIdPort;
    HistoriaClinicaFindAllPort historiaClinicaFindAllPort;
    HistoriaClinicaSavePort historiaClinicaSavePort;
    HistoriaClinicaFindByIdMascotaPort historiaClinicaFindByIdMascotaPort;
    HistoriaClinicaOutMapper historiaClinicaOutMapper;
    HistoriaClinicaUpdatePort historiaClinicaUpdatePort;
    MascotaRepository mascotaRepository;
    HistoriaClinicaFindAllByIdMascotaPort historiaClinicaFindAllByIdMascotaPort;

    public HistortiaClinicaService(HistoriaClinicaDeletePort historiaClinicaDeletePort,
                                   HistoriaClinicaFindByIdPort historiaClinicaFindByIdPort,
                                   HistoriaClinicaFindAllPort historiaClinicaFindAllPort,
                                   HistoriaClinicaOutMapper historiaClinicaOutMapper,
                                   HistoriaClinicaSavePort historiaClinicaSavePort,
                                   MascotaRepository mascotaRepository,
                                   HistoriaClinicaFindByIdMascotaPort historiaClinicaFindByIdMascotaPort,
                                   HistoriaClinicaFindAllByIdMascotaPort historiaClinicaFindAllByIdMascotaPort,
                                   HistoriaClinicaUpdatePort historiaClinicaUpdatePort) {
        this.historiaClinicaDeletePort = historiaClinicaDeletePort;
        this.historiaClinicaFindByIdPort = historiaClinicaFindByIdPort;
        this.historiaClinicaFindAllPort = historiaClinicaFindAllPort;
        this.historiaClinicaOutMapper = historiaClinicaOutMapper;
        this.historiaClinicaSavePort = historiaClinicaSavePort;
        this.historiaClinicaFindByIdMascotaPort = historiaClinicaFindByIdMascotaPort;
        this.historiaClinicaFindAllByIdMascotaPort = historiaClinicaFindAllByIdMascotaPort;
        this.historiaClinicaUpdatePort = historiaClinicaUpdatePort;
        this.mascotaRepository = mascotaRepository;
    }

    @Override
    public List<HistoriaClinicaInDto> findAll() {
        List<HistoriaClinica> listHistoriasClinicas = historiaClinicaFindAllPort.findAll();
        if(listHistoriasClinicas.isEmpty()){
            throw new HistoriaClinicaExeptionBadRequest(MessageResource.HISTORIA_CLINICA_NOT_FOUND.getValue());
        }
        return listHistoriasClinicas.stream().map(historiaClinicaOutMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public HistoriaClinicaInDto findById(Long id) {
        return historiaClinicaOutMapper.toDto(historiaClinicaFindByIdPort.findById(id));
    }

    @Override
    public HistoriaClinicaInDto save(HistoriaClinicaCommand historiaClinicaCommand) {
        //validaciones del comando
        validateExistMascotaById(historiaClinicaCommand.getIdMascota(), MessageResource.MASCOTA_NOT_EXISTS.getValue().trim());
        validateMascotaHistoriaClinica(historiaClinicaCommand.getIdMascota(),MessageResource.HISTORIA_CLINICA_MASCOTA_ALREADY_EXISTS.getValue().trim());
        dateValidator(historiaClinicaCommand.getFechaCreacion().toString(), MessageResource.DATE_NOT_VALID.getValue().trim());
        //llamado al adaptador de la persistencia
        HistoriaClinica historiaClinica = historiaClinicaSavePort.save(historiaClinicaCommand);
        //Carga de la mascota
        historiaClinica.setMascota(mascotaRepository.findById(historiaClinica.getMascota().getId()).get());
        return historiaClinicaOutMapper.toDto(historiaClinica);
    }

    @Override
    public HistoriaClinicaInDto update(HistoriaClinica historiaClinica) {
        //validaciones
        validateExistMascotaById(historiaClinica.getMascota().getId(), MessageResource.MASCOTA_NOT_EXISTS.getValue().trim());
        validateMascotaHistoriaClinica(historiaClinica.getId(),historiaClinica.getMascota().getId(),MessageResource.HISTORIA_CLINICA_MASCOTA_ALREADY_EXISTS.getValue().trim());
        //llamado a la capa de persistencia de datos y mapeo al dto
        return historiaClinicaOutMapper.toDto(historiaClinicaUpdatePort.update(historiaClinica));
    }

    @Override
    public boolean delete(Long id) {
        validateExistHistoriaClinica(id, MessageResource.HISTORIA_CLINICA_NOT_EXISTS.getValue().trim());
        if(historiaClinicaDeletePort.delete(id)){
            return true;
        }
        return false;
    }
    private void validateExistHistoriaClinica(Long id, String message) {
        if(historiaClinicaFindByIdPort.findById(id) == null)
        {
           throw new HistoriaClinicaExeptionBadRequest(message);
        }
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
    private void validateMascotaHistoriaClinica(Long id, String message){
        if (historiaClinicaFindByIdMascotaPort.findByMascota_Id(id).isPresent()) {
            throw new HistoriaClinicaExeptionBadRequest(message);
        }
    }
    private void validateMascotaHistoriaClinica(Long id,Long mascotaId, String message){
        List<HistoriaClinica> historiaLsit = historiaClinicaFindAllByIdMascotaPort.findAllByMascota_Id(mascotaId);
        for (HistoriaClinica h: historiaLsit) {
            if (h.getId() != id) {
                throw new HistoriaClinicaExeptionBadRequest(message);
            }
        }
    }
}
