package work.appdeploys.veterinaria.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "Historia Clinica para grabacion")
public class HistoriaClinicaPostDto {
    @Schema(description = "Id de la mascota",example = "1")
    private Long idMascota;
    @Schema(description = "Fecha de apertura de la historia clinica",example = "2023-01-01")
    private LocalDate fechaCreacion;
}
