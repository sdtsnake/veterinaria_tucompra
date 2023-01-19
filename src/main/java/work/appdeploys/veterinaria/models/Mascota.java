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
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String raza;
    @Column(name = "usuario_id")
    private Integer usuarioId;
    private Integer sexo;



}
