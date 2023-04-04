package work.appdeploys.veterinaria.historiasclinicas.application.port.out;

import work.appdeploys.veterinaria.historiasclinicas.domain.HistoriaClinica;

import java.util.Optional;

public interface HistoriaClinicaFindByIdMascotaPort {
    Optional<HistoriaClinica> findByMascota_Id(Long id);
}
