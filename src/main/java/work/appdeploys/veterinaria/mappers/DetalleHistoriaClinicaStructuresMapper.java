package work.appdeploys.veterinaria.mappers;

import org.springframework.stereotype.Component;
import work.appdeploys.veterinaria.models.Colaborador;
import work.appdeploys.veterinaria.models.DetalleHistoriaClinica;
import work.appdeploys.veterinaria.models.HistoriaClinica;
import work.appdeploys.veterinaria.models.dtos.DetalleHistoriaClinicaCampos;
import work.appdeploys.veterinaria.models.dtos.DetalleHistoriaClinicaPostDto;
import work.appdeploys.veterinaria.models.dtos.DetalleHistoriaClinicaPutDto;

@Component
public class DetalleHistoriaClinicaStructuresMapper {

    public DetalleHistoriaClinica toModel(DetalleHistoriaClinicaPostDto detalleHistoriaClinicaPostDto) {
        return toModelBase(detalleHistoriaClinicaPostDto);
    }

    public DetalleHistoriaClinica toModel(DetalleHistoriaClinicaPutDto detalleHistoriaClinicaPutDto) {
        DetalleHistoriaClinica detalleHistoriaClinica = toModelBase(detalleHistoriaClinicaPutDto);
        detalleHistoriaClinica.setId(detalleHistoriaClinicaPutDto.getId());

        return detalleHistoriaClinica;
    }

    private DetalleHistoriaClinica toModelBase(DetalleHistoriaClinicaCampos camposDetalleHistoriaClinica) {
        HistoriaClinica historiaClinica = new HistoriaClinica();
        Colaborador colaborador = new Colaborador();
        DetalleHistoriaClinica detalleHistoriaClinica = new DetalleHistoriaClinica();

        detalleHistoriaClinica.setTemperatura(camposDetalleHistoriaClinica.getTemperatura());
        detalleHistoriaClinica.setPeso(camposDetalleHistoriaClinica.getPeso());
        detalleHistoriaClinica.setFrecuenciaCardiaca(camposDetalleHistoriaClinica.getFrecuenciaCardiaca());
        detalleHistoriaClinica.setFrecuenciaRespiratoria(camposDetalleHistoriaClinica.getFrecuenciaRespiratoria());
        detalleHistoriaClinica.setFechaHora(camposDetalleHistoriaClinica.getFechaHora());
        detalleHistoriaClinica.setAlimentacion(camposDetalleHistoriaClinica.getAlimentacion());
        detalleHistoriaClinica.setHabitad(camposDetalleHistoriaClinica.getHabitad());
        detalleHistoriaClinica.setObservacion(camposDetalleHistoriaClinica.getObservacion());

        detalleHistoriaClinica.setColaborador(colaborador);
        detalleHistoriaClinica.setHistoriaClinica(historiaClinica);

        return detalleHistoriaClinica;
    }
}

