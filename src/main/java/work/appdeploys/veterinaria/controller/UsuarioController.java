package work.appdeploys.veterinaria.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import work.appdeploys.veterinaria.constans.MessageResource;
import work.appdeploys.veterinaria.models.dtos.ControllerResponseDto;
import work.appdeploys.veterinaria.models.dtos.UsuarioDto;
import work.appdeploys.veterinaria.services.UsuarioService;

import javax.validation.Valid;

@Tag(name="Usuario")
@RequiredArgsConstructor
@RequestMapping(value = "/api/veterinaria/")
@RestController
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<ControllerResponseDto<UsuarioDto>> save(@RequestBody @Valid UsuarioDto usuarioDto){
        try{
            return ResponseEntity.ok(ControllerResponseDto.fromValid(usuarioService.save(usuarioDto)));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(ex));
        }
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ControllerResponseDto<UsuarioDto>> delete(@PathVariable Long id){
        try{
            usuarioService.delete(id);
            return ResponseEntity.ok(ControllerResponseDto.fromValid(null));
        }catch (DataIntegrityViolationException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(MessageResource.USUARIO_CONSTRAIN_VIOLATION.toString()));
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(ex));
        }
    }
}
