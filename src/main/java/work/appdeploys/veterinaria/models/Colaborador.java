package work.appdeploys.veterinaria.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "colaboradores")
@Getter
@Setter
@ToString
@RequiredArgsConstructor

public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nombre del colaborador no puede ser espacios")
    private String nombre;
    @NotBlank(message = "Apellido del colaborador no puede ser espacios")
    private String apellido;
    @NotBlank(message = "Cargo del colaborador no puede ser espacios")
    private String cargo;
    private String especialidad;
    @NotBlank(message = "Tipo de documento esta en blanco")
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @NotNull(message = "Documento de identificaion con valor invalido")
    @Column(name = "documento_identificacion")
    private Integer documentoIdentificacion;
}
