package work.appdeploys.veterinaria.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Mascotas")
public class MascotaDto {
    @Schema(description = "Id de la tabla auto incremental",example = "1")
    private Long id;
    @Schema(description = "Nombre la mascota",example = "Damian")
    private String nombre;
    @Schema(description = "Raza de la mascota",example = "Criollo")
    private String raza;
    @Schema(description = "Id del usuario",example = "1")
    private UsuarioDto usuario;
    @Schema(description = "Sexo del usuario que pueden tener los siguiente valores" +
            "0=Masculino " +
            "1=Femenino " ,example = "0")
    private Integer sexo;
}
