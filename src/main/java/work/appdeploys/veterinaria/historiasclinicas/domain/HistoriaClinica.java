package work.appdeploys.veterinaria.historiasclinicas.domain;

import lombok.Getter;
import lombok.Setter;
import work.appdeploys.veterinaria.models.Mascota;

import java.time.LocalDate;
@Setter
@Getter
public class HistoriaClinica {
    private Long id;
    private Mascota mascota;
    private LocalDate fechaCreacion;
}
