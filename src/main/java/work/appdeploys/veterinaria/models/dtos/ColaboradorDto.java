package work.appdeploys.veterinaria.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "Colaboradores")
public class ColaboradorDto implements Serializable {
    @Schema(description = "Id de la tabla auto incremental",example = "1")
    private final Long id;
    @Schema(description = "Nombres del colaborador",example = "Paula Andrea")
    private final String nombre;
    @Schema(description = "Apellidos del colaborador",example = "Nuñez Giraldo")
    private final String apellido;
    @Schema(description = "Cargo del colaborador",example = "Zootecnista")
    private final String cargo;
    @Schema(description = "Especialidad del colaborador no es requerido",example = "Traumatologa canino")
    private final String espcialidad;
    @Schema(description = "Tipos de identificacion del usuario los cuales pueden " +
            "tener los sigientes valoes CC=Cedula,TI=Tarjeta de identificaion," +
            "RUT=Registro unico tributario",example = "CC")
    private final String tipoDocumento;
    @Schema(description = "Numero de identificacion",example = "29346967")
    private final Integer documentoIdentificacion;
}