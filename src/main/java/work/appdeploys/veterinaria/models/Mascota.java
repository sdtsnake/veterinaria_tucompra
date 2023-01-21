package work.appdeploys.veterinaria.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "mascotas")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nombre de la mascota no puede ser espacios")
    private String nombre;
    @NotBlank(message = "Raza de la mascota no puede ser espacios")
    private String raza;
    @NotNull(message = "Id del usuario no es valido")
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @NotNull(message = "Sexo con valores no valido debe ser 0 o 1")
    private Integer sexo;
}
