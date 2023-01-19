package work.appdeploys.veterinaria.models;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@RequiredArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Column(name = "documento_identificacion")
    private Integer documentoId;
    private String estado;
    private Integer sexo;
}
