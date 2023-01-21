package work.appdeploys.veterinaria.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "Colaboradores")
public class ColaboradorDto {
    @Schema(description = "Id de la tabla auto incremental", example = "1")
    private Long id;
    @Schema(description = "Nombres del colaborador", example = "Paula Andrea")
    private String nombre;
    @Schema(description = "Apellidos del colaborador", example = "Nuñez Giraldo")
    private String apellido;
    @Schema(description = "Cargo del colaborador", example = "Zootecnista")
    private String cargo;
    @Schema(description = "Especialidad del colaborador no es requerido", example = "Traumatologa canino")
    private String especialidad;
    @Schema(description = "Tipos de identificacion del usuario los cuales pueden " +
            "tener los sigientes valoes CC=Cedula,TI=Tarjeta de identificaion," +
            "RUT=Registro unico tributario", example = "CC")
    private String tipoDocumento;
    @Schema(description = "Numero de identificacion", example = "29346967")
    private Integer documentoIdentificacion;
}