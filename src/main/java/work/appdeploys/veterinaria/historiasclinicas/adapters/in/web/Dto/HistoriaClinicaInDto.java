package work.appdeploys.veterinaria.historiasclinicas.adapters.in.web.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import work.appdeploys.veterinaria.models.dtos.MascotaDto;

import java.time.LocalDate;

@Data
@Schema(description = "Historia Clinica")
@Setter
@Getter
public class HistoriaClinicaInDto {

    @Schema(description = "Id de la tabla auto incremental",example = "1")
    private Long id;
    @Schema(description = "Id de la mascota",example = "1")
    private MascotaDto mascota;
    @Schema(description = "Fecha de apertura de la historia clinica",example = "2023-01-01")
    private LocalDate fechaCreacion;
}
