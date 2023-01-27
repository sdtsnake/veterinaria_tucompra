package work.appdeploys.veterinaria.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@Schema(description = "Detalles historias clinicas para grabacion")
@EqualsAndHashCode(callSuper=true)
public class DetalleHistoriaClinicaPostDto extends DetalleHistoriaClinicaCampos {
    @Schema(description = "Numero de id del colaborador", example = "3")
    private Long idColaborador;
    @Schema(description = "Numero de id de la historia clinica", example = "65")
    private Long idHistoriaClinica;
}