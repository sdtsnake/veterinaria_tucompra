package work.appdeploys.veterinaria.historiasclinicas.adapters.out.persistence.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import work.appdeploys.veterinaria.models.Mascota;

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
public class HistoriaClinicaEntity {
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
