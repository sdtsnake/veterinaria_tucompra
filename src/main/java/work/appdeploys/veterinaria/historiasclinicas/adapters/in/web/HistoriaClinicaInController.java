package work.appdeploys.veterinaria.historiasclinicas.adapters.in.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.appdeploys.veterinaria.constans.MessageResource;
import work.appdeploys.veterinaria.historiasclinicas.adapters.in.web.Dto.HistoriaClinicaInDto;
import work.appdeploys.veterinaria.historiasclinicas.adapters.in.web.Dto.HistoriaClinicaPostInDto;
import work.appdeploys.veterinaria.historiasclinicas.adapters.in.web.mapper.HistoriaClinicaInMapper;
import work.appdeploys.veterinaria.historiasclinicas.application.port.in.HistoriaClinicaInPort;
import work.appdeploys.veterinaria.historiasclinicas.common.WebAdapter;
import work.appdeploys.veterinaria.models.dtos.ControllerResponseDto;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Historia Clinica")
@RequestMapping(value = "/api/hexagonal/veterinaria/historia/clinica")
@WebAdapter
@RestController
public class HistoriaClinicaInController {

    private final HistoriaClinicaInPort historiaClinicaInPort;
    private final HistoriaClinicaInMapper historiaClinicaOutMapper;

    public HistoriaClinicaInController(HistoriaClinicaInPort historiaClinicaInPort, HistoriaClinicaInMapper historiaClinicaOutMapper) {
        this.historiaClinicaInPort = historiaClinicaInPort;
        this.historiaClinicaOutMapper = historiaClinicaOutMapper;
    }

    @PostMapping
    public ResponseEntity<ControllerResponseDto<HistoriaClinicaInDto>> save(@RequestBody @Valid HistoriaClinicaPostInDto dto) {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(historiaClinicaInPort.save(historiaClinicaOutMapper.toEntity(dto))));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(ex));
        }
    }
    @PutMapping
    public ResponseEntity<ControllerResponseDto<HistoriaClinicaInDto>> update(@RequestBody @Valid HistoriaClinicaInDto dto) {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(historiaClinicaInPort.update(historiaClinicaOutMapper.toModelDomain(dto))));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(ex));
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ControllerResponseDto<HistoriaClinicaInDto>> delete(@PathVariable Long id) {
        try {
            if(historiaClinicaInPort.delete(id)) {
                return ResponseEntity.ok(ControllerResponseDto.fromValid(null));
            }else {
                return ResponseEntity.ok(ControllerResponseDto.fromError(MessageResource.HISTORIA_CLINICA_ERROR_DELETE.getValue()));
            }
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(MessageResource.CONSTRAIN_VIOLATION.getValue()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(ex));
        }
    }

    @GetMapping
    public ResponseEntity<ControllerResponseDto<List<HistoriaClinicaInDto>>> findAll() {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(historiaClinicaInPort.findAll()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ControllerResponseDto.fromError(ex));
        }
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<ControllerResponseDto<HistoriaClinicaInDto>> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(historiaClinicaInPort.findById(id)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ControllerResponseDto.fromError(ex));
        }
    }



}
