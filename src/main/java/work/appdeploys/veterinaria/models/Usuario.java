package work.appdeploys.veterinaria.models;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
@RequiredArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nombres del Usuario en espacios")
    private String nombre;
    @NotBlank(message = "Apellidos del Usuario en espacios")
    private String apellido;
    @NotBlank(message = "Tipo de documento en blanco")
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @NotNull(message = "Numero de identificaicon con valor invalido debe ser numerico")
    @Column(name = "documento_identificacion")
    private Integer documentoId;
    private String estado;
    @NotNull(message = "Sexo con valor no valido debe ser 0, 1 o 2 ")
    private Integer sexo;
}
