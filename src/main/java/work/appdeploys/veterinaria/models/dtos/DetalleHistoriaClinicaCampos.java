package work.appdeploys.veterinaria.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class DetalleHistoriaClinicaCampos {
    @Schema(description = "Registro de la temperatura", example = "38.00")
    private String temperatura;
    @Schema(description = "Registro del peso", example = "4.00")
    private Double peso;
    @Schema(description = "Registro de la frecuencia cardiaca", example = "110.00")
    private Double frecuenciaCardiaca;
    @Schema(description = "Registro de la frecuencia respiratoria", example = "35.00")
    private Double frecuenciaRespiratoria;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @Schema(description = "Fecha y hora del registro de la historia en formato ISO", example = "2023-01-24T16:29:49.816Z")
    private LocalDateTime fechaHora;
    @Schema(description = "Registro de la alimentacion", example = "Croquetas nutrecan")
    private String alimentacion;
    @Schema(description = "habitad", example = "Apartamento")
    private String habitad;
    @Schema(description = "Observaciones", example = "Paciente registra sobre peso se recomienta alimentacion especializada")
    private String observacion;
}
