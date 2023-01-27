package work.appdeploys.veterinaria.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Schema(description = "Detalles historias clinicas")
@EqualsAndHashCode(callSuper=true)
public class DetalleHistoriaClinicaDto extends DetalleHistoriaClinicaCampos {
    @Schema(description = "Id de la tabla auto incremental", example = "1")
    private Long id;
    @Schema(description = "Numero de id del colaborador")
    private ColaboradorDto colaborador;
    @Schema(description = "Numero de id de la historia clinica", example = "2")
    private HistoriaClinicaDto historiaClinica;
}