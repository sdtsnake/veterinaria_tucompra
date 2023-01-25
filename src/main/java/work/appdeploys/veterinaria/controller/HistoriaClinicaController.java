package work.appdeploys.veterinaria.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.appdeploys.veterinaria.models.dtos.ControllerResponseDto;
import work.appdeploys.veterinaria.models.dtos.DetalleHistoriaClinicaDto;
import work.appdeploys.veterinaria.models.dtos.HistoriaClinicaDto;
import work.appdeploys.veterinaria.models.dtos.HistoriaClinicaPostDto;
import work.appdeploys.veterinaria.services.HistoriaClinicaService;

import javax.validation.Valid;

@Tag(name = "Historia Clinica")
@RequiredArgsConstructor
@RequestMapping(value = "/api/veterinaria/historia/clinica")
@RestController
public class HistoriaClinicaController extends CRUDController<HistoriaClinicaDto, HistoriaClinicaService> {
    @PostMapping
    public ResponseEntity<ControllerResponseDto<HistoriaClinicaDto>> save(@RequestBody @Valid HistoriaClinicaPostDto dto) {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(service.save(dto)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(ex));
        }
    }

    @PutMapping
    public ResponseEntity<ControllerResponseDto<HistoriaClinicaDto>> update(@RequestBody @Valid HistoriaClinicaDto dto) {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(service.update(dto)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(ex));
        }
    }
}


