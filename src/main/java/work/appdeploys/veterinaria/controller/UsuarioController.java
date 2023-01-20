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
import work.appdeploys.veterinaria.models.dtos.UsuarioDto;
import work.appdeploys.veterinaria.services.UsuarioService;

@Tag(name="Usuario")
@RequiredArgsConstructor
@RequestMapping(value = "/api/veterinaria/usuario/")
@RestController
public class UsuarioController extends CRUDController<UsuarioDto, UsuarioService>{

    @GetMapping(path = "/documentoid/{documentoId}")
    public ResponseEntity<ControllerResponseDto<UsuarioDto>> update(@PathVariable Integer documentoId){
        try{
            return ResponseEntity.ok(ControllerResponseDto.fromValid(service.findByDocumentoId(documentoId)));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ControllerResponseDto.fromError(ex));
        }
    }
}

