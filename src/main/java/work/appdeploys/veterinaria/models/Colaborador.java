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
    private String nombre;
    private String apellido;
    private String cargo;
    private String espcialidad;
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Column(name = "documento_identificacion")
    private Integer documentoIdentificacion;



}
