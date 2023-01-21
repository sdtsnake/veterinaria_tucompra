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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "historias_clinicas")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @NotNull(message = "Id de la mascota tiene un valos no numerico")
    @JoinColumn(name = "mascota_id", nullable = false)
    private Mascota mascota;
    @Column(name = "fecha_creacion")
    @NotNull(message = "Fecha de creacion no tiene un valor valido  debne ser AAAA-MM-DD")
    private LocalDate fechaCreacion;
}
