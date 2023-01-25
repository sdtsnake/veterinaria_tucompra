package work.appdeploys.veterinaria.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.appdeploys.veterinaria.models.dtos.ColaboradorDto;
import work.appdeploys.veterinaria.models.dtos.ControllerResponseDto;
import work.appdeploys.veterinaria.models.dtos.DetalleHistoriaClinicaDto;
import work.appdeploys.veterinaria.services.DetalleHistoriaClinicaService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "Detalle Historia Clinica")
@RequiredArgsConstructor
@RequestMapping(value = "/api/veterinaria/detalle/historia/clinica")
@RestController
public class DetalleHistoriaClinicaController extends CRUDController<DetalleHistoriaClinicaDto, DetalleHistoriaClinicaService> {
    @PostMapping
    public ResponseEntity<ControllerResponseDto<DetalleHistoriaClinicaDto>> save(@RequestBody @Valid DetalleHistoriaClinicaDto dto) {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(service.save(dto)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(ex));
        }
    }
    @GetMapping(path = "/idhistoria/{idHistoria}")
    public ResponseEntity<ControllerResponseDto<List<DetalleHistoriaClinicaDto>>> update(@PathVariable Long idHistoria){
        try{
            return ResponseEntity.ok(ControllerResponseDto.fromValid(service.findAllByHistoriaId(idHistoria)));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ControllerResponseDto.fromError(ex));
        }
    }
}


