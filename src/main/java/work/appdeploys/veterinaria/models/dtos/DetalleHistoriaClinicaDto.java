package work.appdeploys.veterinaria.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "Detalles historias clinicas")
public class DetalleHistoriaClinicaDto {
    @Schema(description = "Id de la tabla auto incremental", example = "1")
    private Long id;
    @Schema(description = "Registro de la temperatura", example = "38.00")
    private String temperatura;
    @Schema(description = "Registro del peso", example = "4.00")
    private Double peso;
    @Schema(description = "Registro de la frecuencia cardiaca", example = "110.00")
    private Double frecuenciaCardiaca;
    @Schema(description = "Registro de la frecuencia respiratoria", example = "35.00")
    private Double frecuenciaRespiratoria;
    @Schema(description = "Fecha y hora del registro de la historia", example = "2023-01-01 10:00:00")
    private LocalDateTime fechaHora;
    @Schema(description = "Registro de la alimentacion", example = "Croquetas nutrecan")
    private String alimentacion;
    @Schema(description = "habitad", example = "Apartamento")
    private String habitad;
    @Schema(description = "Observaciones", example = "Paciente registra sobre peso se recomienta alimentacion especializada")
    private String observacion;
    @Schema(description = "Numero de id del colaborador")
    private ColaboradorDto colaborador;
    @Schema(description = "Numero de id de la historia clinica", example = "2")
    private HistoriaClinicaDto historiaClinica;
}