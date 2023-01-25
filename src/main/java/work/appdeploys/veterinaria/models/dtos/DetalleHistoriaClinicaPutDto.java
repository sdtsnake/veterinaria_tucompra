package work.appdeploys.veterinaria.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Schema(description = "Detalles historias clinicas para actualizacion")
@EqualsAndHashCode(callSuper=false)
public class DetalleHistoriaClinicaPutDto extends DetalleHistoriaClinicaPostDto {
    @Schema(description = "Id de la tabla", example = "1")
    private Long id;
}