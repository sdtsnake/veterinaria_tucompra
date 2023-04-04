package work.appdeploys.veterinaria.historiasclinicas.application.port.out;

import work.appdeploys.veterinaria.historiasclinicas.domain.HistoriaClinica;

import java.util.List;

public interface HistoriaClinicaFindAllByIdMascotaPort {
    List<HistoriaClinica> findAllByMascota_Id(Long id);
}
