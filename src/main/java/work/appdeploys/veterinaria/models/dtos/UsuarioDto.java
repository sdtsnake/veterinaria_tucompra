package work.appdeploys.veterinaria.models.dtos;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Usuarios")
public class UsuarioDto {
    @Schema(description = "Id de la tabla auto incremental",example = "1")
    private Long id;
    @Schema(description = "Nombres del usuario",example = "Oscar Andres")
    private String nombre;
    @Schema(description = "Apellidos del usuario",example = "Ramos Lopez")
    private String apellido;
    @Schema(description = "Tipos de identificacion del usuario los cuales pueden " +
            "tener los sigientes valoes CC=Cedula,TI=Tarjeta de identificaion," +
            "RUT=Registro unico tributario",example = "CC")
    private String tipoDocumento;
    @Schema(description = "Numero de identificacion",example = "94041436")
    private Integer documentoId;
    @Schema(description = "Estado civil del usuario",example = "Casado")
    private String estado;
    @Schema(description = "Sexo del usuario que pueden tener los siguiente valores" +
            "0=Masculino, " +
            "1=Femenino, " +
            "2=No definido",example = "0")
    private Integer sexo;
}
