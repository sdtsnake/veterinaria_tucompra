package work.appdeploys.veterinaria.historiasclinicas.application.port.in;

import work.appdeploys.veterinaria.historiasclinicas.adapters.in.web.Dto.HistoriaClinicaInDto;
import work.appdeploys.veterinaria.historiasclinicas.domain.HistoriaClinica;

import java.util.List;

public interface HistoriaClinicaInPort {
    boolean delete(Long id);
    List<HistoriaClinicaInDto> findAll();
    HistoriaClinicaInDto findById(Long id);
    HistoriaClinicaInDto save(HistoriaClinicaCommand historiaClinicaCommand);
    HistoriaClinicaInDto update(HistoriaClinica historiaClinica);
}
