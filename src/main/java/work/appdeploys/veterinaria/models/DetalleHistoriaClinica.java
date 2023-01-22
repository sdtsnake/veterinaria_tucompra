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
import java.time.LocalDateTime;

@Entity
@Table(name = "Detalles_historias_clinicas")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class DetalleHistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Temperatura tiene un valor invalido")
    private String temperatura;
    @NotNull(message = "Peso tiene un valor invalido")
    private Double peso;
    @NotNull(message = "Frecuencia cardiaca tiene un valor invalido")
    @Column(name = "frecuencia_cardiaca")
    private Double frecuenciaCardiaca;
    @NotNull(message = "Frecuencia respiratoria tiene un valor invalido")
    @Column(name = "frecuencia_respiratoria")
    private Double frecuenciaRespiratoria;
    @NotNull(message = "Frecuencia respiratoria tiene un valor invalido")
    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;
    private String alimentacion;
    private String habitad;
    private String observacion;
    @ManyToOne
    @JoinColumn(name = "colaborador_id", nullable = false)
    @NotNull(message = "id del colaborador con un valor invalid")
    private Colaborador colaborador;
    @ManyToOne
    @JoinColumn(name = "historia_clinica_id", nullable = false)
    @NotNull(message = "id de la historia clinica con un valor invalid")
    private HistoriaClinica historiaClinica;
}
