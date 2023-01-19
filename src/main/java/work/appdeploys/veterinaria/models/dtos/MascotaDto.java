package work.appdeploys.veterinaria.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;

@Data
@Schema(description = "Mascotas")
public class MascotaDto {
    @Schema(description = "Id de la tabla auto incremental",example = "1")
    private Long id;
    @Schema(description = "Nombre la mascota",example = "Damian")
    private String nombre;
    @Schema(description = "Raza de la mascota",example = "Criollo")
    private String raza;
    @Schema(description = "Numero de indentificaicon del propietario",example = "94041436")
    private Integer usuarioId;
    @Schema(description = "Sexo del usuario que pueden tener los siguiente valores" +
            "0=Masculino " +
            "1=Femenino " ,example = "0")
    private Integer sexo;
}
