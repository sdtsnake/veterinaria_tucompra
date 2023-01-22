package work.appdeploys.veterinaria.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.appdeploys.veterinaria.models.dtos.DetalleHistoriaClinicaDto;
import work.appdeploys.veterinaria.services.DetalleHistoriaClinicaService;

@Tag(name = "Detalle Historia Clinica")
@RequiredArgsConstructor
@RequestMapping(value = "/api/veterinaria/detalle/historia/clinica")
@RestController
public class DetalleHistoriaClinicaController extends CRUDController<DetalleHistoriaClinicaDto, DetalleHistoriaClinicaService> {

}


