package work.appdeploys.veterinaria.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.appdeploys.veterinaria.models.dtos.MascotaDto;

@Tag(name = "Mascota")
@RequiredArgsConstructor
@RequestMapping(value = "/api/veterinaria/mascota/")
@RestController
public class MascotaController extends CRUDController<MascotaDto> {

}


