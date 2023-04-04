package work.appdeploys.veterinaria.historiasclinicas.application.port.out;

import work.appdeploys.veterinaria.historiasclinicas.domain.HistoriaClinica;

public interface HistoriaClinicaUpdatePort {
    HistoriaClinica update(HistoriaClinica historiaClinica);
}
