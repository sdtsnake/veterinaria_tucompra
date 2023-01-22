package work.appdeploys.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import work.appdeploys.veterinaria.constans.MessageResource;
import work.appdeploys.veterinaria.models.dtos.ControllerResponseDto;
import work.appdeploys.veterinaria.services.CRUDService;

import javax.validation.Valid;
import java.util.List;

public abstract class CRUDController <D,S extends CRUDService<D>>  {

    @Autowired
    protected S service;
    @PostMapping
    public ResponseEntity<ControllerResponseDto<D>> save(@RequestBody @Valid D dto) {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(service.save(dto)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(ex));
        }
    }
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
    @PutMapping
    public ResponseEntity<ControllerResponseDto<D>> update(@RequestBody @Valid D dto) {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(service.update(dto)));
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
    public ResponseEntity<ControllerResponseDto<D>> findById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(ControllerResponseDto.fromValid(service.findById(id)));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ControllerResponseDto.fromError(ex));
        }
    }
}
