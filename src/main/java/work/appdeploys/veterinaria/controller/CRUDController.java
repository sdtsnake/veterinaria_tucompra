package work.appdeploys.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import work.appdeploys.veterinaria.constans.MessageResource;
import work.appdeploys.veterinaria.models.dtos.ControllerResponseDto;
import work.appdeploys.veterinaria.services.CRUDService;

import java.util.List;

public abstract class CRUDController<D, S extends CRUDService<D>> {

    @Autowired
    protected S service;

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ControllerResponseDto<D>> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(ControllerResponseDto.fromValid(null));
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(MessageResource.CONSTRAIN_VIOLATION.getValue()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(ex));
        }
    }

    @GetMapping
    public ResponseEntity<ControllerResponseDto<List<D>>> findAll() {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(service.findAll()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ControllerResponseDto.fromError(ex));
        }
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<ControllerResponseDto<D>> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(service.findById(id)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ControllerResponseDto.fromError(ex));
        }
    }
}
