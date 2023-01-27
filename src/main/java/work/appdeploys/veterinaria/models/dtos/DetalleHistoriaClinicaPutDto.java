package work.appdeploys.veterinaria.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Schema(description = "Detalles historias clinicas para actualizacion")
@EqualsAndHashCode(callSuper=true)
public class DetalleHistoriaClinicaPutDto extends DetalleHistoriaClinicaCampos {
    @Schema(description = "Id de la tabla", example = "1")
    private Long id;
    @Schema(description = "Numero de id del colaborador", example = "3")
    private Long idColaborador;
    @Schema(description = "Numero de id de la historia clinica", example = "65")
    private Long idHistoriaClinica;
}