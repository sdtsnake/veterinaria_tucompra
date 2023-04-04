package work.appdeploys.veterinaria.historiasclinicas.application.port.in;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HistoriaClinicaCommand {
    private Long idMascota;
    private LocalDate fechaCreacion;
}
