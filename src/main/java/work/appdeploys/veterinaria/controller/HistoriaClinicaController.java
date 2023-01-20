package work.appdeploys.veterinaria.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.appdeploys.veterinaria.models.dtos.HistoriaClinicaDto;
import work.appdeploys.veterinaria.models.dtos.MascotaDto;
import work.appdeploys.veterinaria.services.HistoriaClinicaService;
import work.appdeploys.veterinaria.services.MascotaService;

@Tag(name = "Historia Clinica")
@RequiredArgsConstructor
@RequestMapping(value = "/api/veterinaria/historia/clinica")
@RestController
public class HistoriaClinicaController extends CRUDController<HistoriaClinicaDto, HistoriaClinicaService> {

}


