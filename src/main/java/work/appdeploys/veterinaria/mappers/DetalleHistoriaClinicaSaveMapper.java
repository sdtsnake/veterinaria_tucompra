package work.appdeploys.veterinaria.mappers;

import org.springframework.stereotype.Component;
import work.appdeploys.veterinaria.models.Colaborador;
import work.appdeploys.veterinaria.models.DetalleHistoriaClinica;
import work.appdeploys.veterinaria.models.HistoriaClinica;
import work.appdeploys.veterinaria.models.Mascota;
import work.appdeploys.veterinaria.models.dtos.DetalleHistoriaClinicaPostDto;
import work.appdeploys.veterinaria.models.dtos.HistoriaClinicaPostDto;

@Component
public class DetalleHistoriaClinicaSaveMapper {

    public DetalleHistoriaClinica toModel(DetalleHistoriaClinicaPostDto detalleHistoriaClinicaPostDto){
        HistoriaClinica historiaClinica = new HistoriaClinica();
        historiaClinica.setId(detalleHistoriaClinicaPostDto.getIdHistoriaClinica());
        Colaborador colaborador = new Colaborador();
        colaborador.setId(detalleHistoriaClinicaPostDto.getIdColaborador());
        DetalleHistoriaClinica detalleHistoriaClinica = new DetalleHistoriaClinica();
        detalleHistoriaClinica.setTemperatura(detalleHistoriaClinicaPostDto.getTemperatura());
        detalleHistoriaClinica.setPeso(detalleHistoriaClinicaPostDto.getPeso());
        detalleHistoriaClinica.setFrecuenciaCardiaca(detalleHistoriaClinicaPostDto.getFrecuenciaCardiaca());
        detalleHistoriaClinica.setFrecuenciaRespiratoria(detalleHistoriaClinicaPostDto.getFrecuenciaRespiratoria());
        detalleHistoriaClinica.setFechaHora(detalleHistoriaClinicaPostDto.getFechaHora());
        detalleHistoriaClinica.setAlimentacion(detalleHistoriaClinicaPostDto.getAlimentacion());
        detalleHistoriaClinica.setHabitad(detalleHistoriaClinicaPostDto.getHabitad());
        detalleHistoriaClinica.setObservacion(detalleHistoriaClinicaPostDto.getObservacion());
        detalleHistoriaClinica.setColaborador(colaborador);
        detalleHistoriaClinica.setHistoriaClinica(historiaClinica);
        return detalleHistoriaClinica;
    }

}
