package work.appdeploys.veterinaria.mappers;

import org.springframework.stereotype.Component;
import work.appdeploys.veterinaria.models.HistoriaClinica;
import work.appdeploys.veterinaria.models.Mascota;
import work.appdeploys.veterinaria.models.dtos.HistoriaClinicaPostDto;

@Component
public class HistoriaClinicaSaveMapper {
    public HistoriaClinica toModel(HistoriaClinicaPostDto historiaClinicaPostDto){
        HistoriaClinica historiaClinica = new HistoriaClinica();
        historiaClinica.setFechaCreacion(historiaClinicaPostDto.getFechaCreacion());
        historiaClinica.setMascota(new Mascota(historiaClinicaPostDto.getIdMascota()));
        return historiaClinica;
    };
}
