package work.appdeploys.veterinaria.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.appdeploys.veterinaria.models.dtos.ControllerResponseDto;
import work.appdeploys.veterinaria.models.dtos.MascotaDto;
import work.appdeploys.veterinaria.models.dtos.UsuarioDto;
import work.appdeploys.veterinaria.services.MascotaService;

import java.util.List;

@Tag(name = "Mascota")
@RequiredArgsConstructor
@RequestMapping(value = "/api/veterinaria/mascota/")
@RestController
public class MascotaController extends CRUDController<MascotaDto, MascotaService> {

    @GetMapping(path = "/sin/historia/clinica")
    public ResponseEntity<ControllerResponseDto<List<MascotaDto>>> getmascotas(){
        try{
            return ResponseEntity.ok(ControllerResponseDto.fromValid(service.findAllSinHistoria()));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ControllerResponseDto.fromError(ex));
        }
    }

}


