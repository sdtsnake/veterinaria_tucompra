package work.appdeploys.veterinaria.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import work.appdeploys.veterinaria.constans.MessageResource;
import work.appdeploys.veterinaria.models.dtos.ControllerResponseDto;
import work.appdeploys.veterinaria.models.dtos.MascotaDto;
import work.appdeploys.veterinaria.services.MascotaService;

import javax.validation.Valid;

@Tag(name = "Mascota")
@RequiredArgsConstructor
@RequestMapping(value = "/api/veterinaria/mascota/")
@RestController
public class MacotaController {

    private final MascotaService mascotaService;

    @PostMapping
    public ResponseEntity<ControllerResponseDto<MascotaDto>> save(@RequestBody @Valid MascotaDto mascotaDto) {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(mascotaService.save(mascotaDto)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(ex));
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ControllerResponseDto<MascotaDto>> delete(@PathVariable Long id) {
        try {
            mascotaService.delete(id);
            return ResponseEntity.ok(ControllerResponseDto.fromValid(null));
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(MessageResource.CONSTRAIN_VIOLATION.toString()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(ex));
        }
    }
}


