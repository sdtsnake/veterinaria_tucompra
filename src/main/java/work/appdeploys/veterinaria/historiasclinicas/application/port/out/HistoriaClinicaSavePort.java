package work.appdeploys.veterinaria.historiasclinicas.application.port.out;

import work.appdeploys.veterinaria.historiasclinicas.application.port.in.HistoriaClinicaCommand;
import work.appdeploys.veterinaria.historiasclinicas.domain.HistoriaClinica;

public interface HistoriaClinicaSavePort {

    HistoriaClinica save(HistoriaClinicaCommand historiaClinicaCommand);
}
